package com.zmj.user.designPattern.templatePattern.jdbcTemplate;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.templatePattern.jdbcTemplate
 * @date 2023/10/17 15:11
 */

@Component
public class JdbcTemplateDemo {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private TransactionTemplate transactionTemplate;


    public void demo() {
        Object execute = jdbcTemplate.execute(new StatementCallback<Object>() {
            @Override
            public Object doInStatement(Statement stmt) throws SQLException, DataAccessException {
                return null;
            }
        });

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                return;
            }
        });
    }
}
