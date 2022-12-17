package com.cfamenu.ChickFilA.Menu.Project.dao;

import com.cfamenu.ChickFilA.Menu.Project.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItemDao implements ItemDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Item getItemByName(String itemName) {

        String sql =
                "SELECT item_id, " +
                        " item_name, " +
                        " calories, " +
                        " item_type, " +
                        " price" +
                        " FROM item " +
                        " WHERE item_name = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, itemName);
        if (rowSet.next()) {
            return itemMapper(rowSet);
        }
        return null;
    }

    @Override
    public List<Item> getAllItems() {

        List<Item> items = new ArrayList<>();

        String sql =
                "SELECT item_id, " +
                        " item_name, " +
                        " calories, " +
                        " item_type, " +
                        " price" +
                        " FROM item;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        while (rowSet.next()) {
            items.add(itemMapper(rowSet));
        }

        return items;
    }


    private Item itemMapper(SqlRowSet rowset) {
        Item item = new Item();

        try {
            item.setItemId(rowset.getInt("item_id"));
            item.setItemName(rowset.getString("item_name"));
            item.setCalories(rowset.getInt("calories"));
            item.setItemType(rowset.getString("item_type"));
            item.setPrice(rowset.getBigDecimal("price"));
            return item;
        } catch (Exception ignored) {}
        return null;
    }
}
