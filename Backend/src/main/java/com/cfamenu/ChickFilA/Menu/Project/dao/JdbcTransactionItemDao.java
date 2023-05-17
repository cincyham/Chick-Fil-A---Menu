package com.cfamenu.ChickFilA.Menu.Project.dao;

import com.cfamenu.ChickFilA.Menu.Project.model.Item;
import com.cfamenu.ChickFilA.Menu.Project.model.TransactionItem;
import com.cfamenu.ChickFilA.Menu.Project.controller.ItemController;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransactionItemDao implements TransactionItemDao{

    private JdbcTemplate jdbcTemplate;

    private ItemController itemController;

    public JdbcTransactionItemDao(JdbcTemplate jdbcTemplate, ItemController itemController) {
        this.jdbcTemplate = jdbcTemplate;
        this.itemController = itemController;
    }


    @Override
    public TransactionItem getTransactionItemById(int transactionItemId) {
        String sql =
                " SELECT id, " +
                        " item_id, " +
                        " transaction_id " +
                        " FROM transaction_item " +
                        " WHERE id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, transactionItemId);

        if (rowSet.next()) {
            return transactionItemMapper(rowSet);
        }
        return null;
    }

    @Override
    public List<TransactionItem> getAllTransactionItemsByTransactionId(int transactionId) {
        List<TransactionItem> transactionItems = new ArrayList<>();
        String sql =
                " SELECT id, " +
                        " item_id, " +
                        " transaction_id " +
                        " FROM transaction_item " +
                        " WHERE transaction_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, transactionId);

        try {
            while (rowSet.next()) {
                transactionItems.add(transactionItemMapper(rowSet));
            }
        } catch (Exception ignored) {}

        return transactionItems;
    }

    @Override
    public TransactionItem createTransactionItem(Item item, int transactionId) {
        String sql =
                " INSERT INTO transaction_item (item_id, transaction_id) " +
                        " VALUES (?, ?) " +
                        " RETURNING id;";
        Integer transactionItemId = jdbcTemplate.queryForObject(sql, Integer.class, item.getId(), transactionId);
        return getTransactionItemById(transactionItemId);
    }

    @Override
    public List<TransactionItem> createTransactionItemsFromList(List<Item> itemList, int transactionId) {
        List<TransactionItem> newList = new ArrayList<>();

        for (Item item : itemList) {
            TransactionItem transactionItem = createTransactionItem(item, transactionId);
            newList.add(transactionItem);
        }
        return newList;
    }

    private TransactionItem transactionItemMapper(SqlRowSet rowset) {
        TransactionItem transactionItem = new TransactionItem();

        transactionItem.setId(rowset.getInt("id"));
        int itemId = transactionItem.setItemId(rowset.getInt("item_id"));
        transactionItem.setItem((itemController.getItemById(itemId)));
        transactionItem.setTransactionId(rowset.getInt("transaction_id"));

        return transactionItem;
    }

}
