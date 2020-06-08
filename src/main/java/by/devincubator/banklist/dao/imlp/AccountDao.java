package by.devincubator.banklist.dao.imlp;

import by.devincubator.banklist.builder.Builder;
import by.devincubator.banklist.entity.Account;
import by.devincubator.banklist.entity.User;
import by.devincubator.banklist.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class AccountDao extends AbstractDao<Account> {

    private static final String TABLE_NAME = "mydb.account";

    private static final String FIND_BY_ID_QUERY = "SELECT * FROM %s WHERE accountid=?;";

    public AccountDao(Builder<Account> builder, Connection connection) {
        super(builder, connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Optional<Account> getById(int id) throws DaoException {
        String tableName = getTableName();
        String query = String.format(FIND_BY_ID_QUERY, tableName);
        String idParameter = Long.toString(id);
        return executeForSingleResult(query, idParameter);
    }

    @Override
    public void save(Account entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(int id) throws DaoException {
        throw new UnsupportedOperationException();
    }
}
