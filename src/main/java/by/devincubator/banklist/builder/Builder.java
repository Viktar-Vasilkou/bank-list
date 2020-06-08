package by.devincubator.banklist.builder;

import by.devincubator.banklist.entity.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Builder <T extends Identifiable> {

    T build(ResultSet resultSet) throws SQLException;

}
