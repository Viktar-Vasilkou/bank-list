package by.devincubator.banklist.connection.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseConfigFactoryTest {

    private static final String EXPECTED_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String EXPECTED_URL = "jdbc:mysql://localhost:3306/mySQL?useUnicode=true&serverTimezone=UTC";
    private static final String EXPECTED_USER = "root";
    private static final String EXPECTED_PASSWORD = "V5i5t6a9s93";

    private DataBaseConfigFactory factory = new DataBaseConfigFactory();

    @Test
    void createConfig() {
        DataBaseConfig config = factory.createConfig();
        String driver = config.getDriver();
        String url = config.getUrl();
        String user = config.getUser();
        String password = config.getPassword();

        assertEquals(EXPECTED_DRIVER, driver);
        assertEquals(EXPECTED_URL, url);
        assertEquals(EXPECTED_USER, user);
        assertEquals(EXPECTED_PASSWORD, password);
    }
}