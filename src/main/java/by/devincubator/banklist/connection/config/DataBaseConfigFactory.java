package by.devincubator.banklist.connection.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataBaseConfigFactory {
    private static final String CONFIG_FILE = "database.properties";

    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public DataBaseConfig createConfig(){
         Properties properties = getPropertiesFromFile();
         String driver = properties.getProperty(DRIVER);
         String url = properties.getProperty(URL);
         String user = properties.getProperty(USER);
         String password = properties.getProperty(PASSWORD);
         return new DataBaseConfig(driver, url, user, password);
    }

    private Properties getPropertiesFromFile(){
        ClassLoader loader = getClass().getClassLoader();
        try (InputStream inputStream = loader.getResourceAsStream(CONFIG_FILE)) {
            if (inputStream == null) {
                String message = "database.properties not found";
                throw new IllegalStateException(message);
            }
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
