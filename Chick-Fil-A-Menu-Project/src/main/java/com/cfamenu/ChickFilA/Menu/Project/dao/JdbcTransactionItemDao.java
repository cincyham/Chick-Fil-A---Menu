package com.cfamenu.ChickFilA.Menu.Project.dao;

import com.cfamenu.ChickFilA.Menu.Project.model.TransactionItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransactionItemDao implements TransactionItemDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTransactionItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public TransactionItem getTransactionItemById(int transactionItemId) {
        String sql =
                " SELECT transaction_item_id, " +
                        " item_id, " +
                        " transaction_id " +
                        " FROM transaction_item " +
                        " WHERE transaction_item_id = ?;";
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
                " SELECT transaction_item_id, " +
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
    public List<TransactionItem> createTransactionItemsFromList(List<TransactionItem> transactionItemList) {
        String sql =
                " INSERT INTO transaction_item (item_id, transaction_id) " +
                        " VALUES (?, ?) " +
                        " RETURNING transaction_item_id;";

        List<TransactionItem> newList = new ArrayList<>();

        for (TransactionItem item : transactionItemList) {
            Integer transactionItemId = jdbcTemplate.queryForObject(sql, Integer.class, item.getItemId(), item.getTransactionId());
            newList.add(getTransactionItemById(transactionItemId));
        }
        return newList;
    }

    private TransactionItem transactionItemMapper(SqlRowSet rowset) {
        TransactionItem transactionItem = new TransactionItem();

        transactionItem.setTransactionItemId(rowset.getInt("transaction_item_id"));
        transactionItem.setItemId(rowset.getInt("transaction_date"));
        transactionItem.setTransactionId(rowset.getInt("transaction_id"));

        return transactionItem;
    }

}
