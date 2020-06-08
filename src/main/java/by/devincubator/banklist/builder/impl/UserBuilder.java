package by.devincubator.banklist.builder.impl;

import by.devincubator.banklist.builder.Builder;
import by.devincubator.banklist.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements Builder<User> {

    private static final String DEFAULT_ID_COLUMN = "userid";
    private static final String FIRST_NAME_COLUMN = "name";
    private static final String SECOND_NAME_COLUMN= "surName";

    private String idAlias;

    public UserBuilder() {
        idAlias = DEFAULT_ID_COLUMN;
    }

    public UserBuilder(String idAlias) {
        this.idAlias = idAlias;
    }

    @Override
    public User build(ResultSet resultSet) throws SQLException {
        Integer id = (Integer) resultSet.getObject(idAlias);
        if (resultSet.wasNull()) {
            return null;
        }
        String firstName = resultSet.getString(FIRST_NAME_COLUMN);
        String secondName = resultSet.getString(SECOND_NAME_COLUMN);
        return new User(id, firstName, secondName);
    }
}
