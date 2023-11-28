package src.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private Properties properties = new Properties();

    public ConfigManager(String configFile) {
        try {
            FileInputStream input = new FileInputStream(configFile);

            try {
                this.properties.load(input);
            } catch (Throwable var6) {
                try {
                    input.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            input.close();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }

    public String getPropertyValue(String key) {
        return this.properties.getProperty(key);
    }
}
