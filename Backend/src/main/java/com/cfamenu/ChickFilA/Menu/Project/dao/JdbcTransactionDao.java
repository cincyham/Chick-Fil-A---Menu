package com.cfamenu.ChickFilA.Menu.Project.dao;

import com.cfamenu.ChickFilA.Menu.Project.model.Item;
import com.cfamenu.ChickFilA.Menu.Project.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransactionDao implements TransactionDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Transaction> getAllTransaction() throws JsonProcessingException {
        List<Transaction> transactionList = new ArrayList<>();
        String sql =
                " SELECT id, " +
                        " date, " +
                        " total, " +
                        " items " +
                        " FROM transaction;";

        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql);

        while (rowset.next()) {
            transactionList.add(transactionMapper(rowset));
        }

        return transactionList;
    }

    @Override
    public Transaction getTransactionById(int transactionId) throws JsonProcessingException {
        String sql =
                " SELECT id, " +
                        " date, " +
                        " total, " +
                        " items " +
                        " FROM transaction " +
                        " WHERE id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, transactionId);
        if (rowSet.next()) {
            return transactionMapper(rowSet);
        }
        return null;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) throws JsonProcessingException {
        String sql =
                " INSERT INTO transaction (date, total, items) " +
                        " VALUES (?, ?, ?::json) " +
                        " RETURNING id;";

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String json = objectMapper.writeValueAsString(transaction.getOrder());

        System.out.println("json: " + json);

        Integer transactionId = jdbcTemplate.queryForObject(sql, Integer.class, transaction.getDate(), transaction.getTotal(), json);

        return getTransactionById(transactionId);
    }

    private Transaction transactionMapper(SqlRowSet rowSet) throws JsonProcessingException {
        Transaction transaction = new Transaction();
        ObjectMapper objectMapper = new ObjectMapper();

        transaction.setId(rowSet.getInt("id"));
        transaction.setDate(rowSet.getDate("date").toLocalDate());
        transaction.setTotal(rowSet.getBigDecimal("total"));
        transaction.setOrder(objectMapper.readValue(rowSet.getString("items"), new TypeReference<List<Item>>() {}));

        return transaction;
    }
}
