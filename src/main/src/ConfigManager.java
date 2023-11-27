import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private Properties properties;

    public ConfigManager(String configFile) {
        properties = new Properties();
        loadConfiguration(configFile);
    }

    private void loadConfiguration(String configFile) {
        try (InputStream input = new FileInputStream(configFile)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getPropertyValue(String key) {
        return properties.getProperty(key);
    }
}
