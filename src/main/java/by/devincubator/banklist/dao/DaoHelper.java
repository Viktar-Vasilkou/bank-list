package by.devincubator.banklist.dao;

import by.devincubator.banklist.builder.Builder;
import by.devincubator.banklist.dao.imlp.AccountDao;
import by.devincubator.banklist.dao.imlp.UserDao;
import by.devincubator.banklist.entity.Account;
import by.devincubator.banklist.entity.User;

import java.sql.Connection;

public class DaoHelper {

    private Connection connection;

    public DaoHelper(Connection connection) {
        this.connection = connection;
    }

    public UserDao userDao(Builder<User> builder){
        return new UserDao(builder, connection);
    }

    public AccountDao accountDao(Builder<Account> builder){
        return new AccountDao(builder, connection);
    }
}
