package com.cfamenu.ChickFilA.Menu.Project.dao;

import com.cfamenu.ChickFilA.Menu.Project.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcTransactionDao implements TransactionDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        String sql =
                " SELECT id, " +
                        " date, " +
                        " total " +
                        " FROM transaction " +
                        " WHERE id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, transactionId);
        if (rowSet.next()) {
            return transactionMapper(rowSet);
        }
        return null;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        String sql =
                " INSERT INTO transaction (date, total) " +
                        " VALUES (?, ?) " +
                        " RETURNING id;";

        Integer transactionId = jdbcTemplate.queryForObject(sql, Integer.class, transaction.getDate(), transaction.getTotal());

        return getTransactionById(transactionId);
    }

    private Transaction transactionMapper(SqlRowSet rowSet) {
        Transaction transaction = new Transaction();

        transaction.setId(rowSet.getInt("id"));
        transaction.setDate(rowSet.getDate("date"));
        transaction.setTotal(rowSet.getBigDecimal("total"));

        return transaction;
    }
}
