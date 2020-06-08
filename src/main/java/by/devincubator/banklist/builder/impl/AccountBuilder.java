package by.devincubator.banklist.builder.impl;

import by.devincubator.banklist.builder.Builder;
import by.devincubator.banklist.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountBuilder implements Builder<Account> {

    private static final String DEFAULT_ACCOUNT_ID_COLUMN = "accountid";
    private static final String ACCOUNT_COLUMN = "account";
    private static final String USER_ID_COLUMN = "userid";

    private String idAlias;

    public AccountBuilder() {
        idAlias = DEFAULT_ACCOUNT_ID_COLUMN;
    }

    public AccountBuilder(String idAlias) {
        this.idAlias = idAlias;
    }

    @Override
    public Account build(ResultSet resultSet) throws SQLException {
        Integer accountId = (Integer) resultSet.getInt(idAlias);
        if (resultSet.wasNull()) {
            return null;
        }
        Integer account = (Integer) resultSet.getInt(ACCOUNT_COLUMN);
        Integer userId = (Integer) resultSet.getInt(USER_ID_COLUMN);
        return new Account(accountId, account, userId);
    }
}
