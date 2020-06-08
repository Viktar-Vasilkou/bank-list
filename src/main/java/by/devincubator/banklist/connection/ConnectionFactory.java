package by.devincubator.banklist.connection;

import by.devincubator.banklist.connection.config.DataBaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private DataBaseConfig config;

    public ConnectionFactory(DataBaseConfig config){
        this.config = config;
        installDriver();
    }

    public Connection createConnection(){
        String url = config.getUrl();
        String user = config.getUser();
        String password = config.getPassword();

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            throw new  IllegalArgumentException(e.getMessage(), e);
        }
    }

    private void installDriver(){
        String driver = config.getDriver();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e){
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
