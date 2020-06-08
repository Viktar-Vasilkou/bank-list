package by.devincubator.banklist.connection.config;

public class DataBaseConfig {
    private final String driver;
    private final String url;
    private final String user;
    private final String password;

    public DataBaseConfig(String driver, String url, String user, String password) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
