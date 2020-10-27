package dk.vip.client.domain.configuration;

import java.util.HashMap;
import java.util.Map;

public class Configurator {
    // singleton makes it easy to retrieve configuration files.
    private static Configurator instance;
    private HeadConfigurationFileHandler fileHandler;
    // Configurationmodel = instance of a configuration file
    private final Map<Class, ConfigurationModel> configurationModels;

    private Configurator() {
        configurationModels = new HashMap<>();
        configurationModels.put(NetworkConfiguration.class, new NetworkConfiguration("cfgNetwork.json"));
    }

    public static Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator();
        }
        return instance;
    }

    public void saveConfig(Class config) {
        fileHandler.save(configurationModels.get(config));
    }

    public ConfigurationModel loadConfig(Class config) {
        return fileHandler.load(configurationModels.get(config));
    }

    public void setStrategy(HeadConfigurationFileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public <T extends ConfigurationModel> T get(Class<T> classModel) {
        return (T) configurationModels.get(classModel);
    }
}
