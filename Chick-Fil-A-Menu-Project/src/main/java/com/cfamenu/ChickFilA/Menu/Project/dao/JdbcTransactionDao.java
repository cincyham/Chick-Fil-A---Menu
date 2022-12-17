package com.cfamenu.ChickFilA.Menu.Project.dao;

import com.cfamenu.ChickFilA.Menu.Project.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.GroovyWebApplicationContext;

@Component
public class JdbcTransactionDao implements TransactionDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        String sql =
                " SELECT transaction_id, " +
                        " transaction_date, " +
                        " total " +
                        " FROM transaction " +
                        " WHERE transaction_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, transactionId);
        if (rowSet.next()) {
            return transactionMapper(rowSet);
        }
        return null;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        String sql =
                " INSERT INTO transaction (transaction_date, total) " +
                        " VALUES (?, ?) " +
                        " RETURNING transaction_id;";

        Integer transactionId = jdbcTemplate.queryForObject(sql, Integer.class, transaction.getTransactionDate(), transaction.getTotal());

        return getTransactionById(transactionId);
    }

    private Transaction transactionMapper(SqlRowSet rowSet) {
        Transaction transaction = new Transaction();

        transaction.setTransactionId(rowSet.getInt("transaction_id"));
        transaction.setTransactionDate(rowSet.getDate("transaction_date"));
        transaction.setTotal(rowSet.getBigDecimal("total"));

        return transaction;
    }
}
