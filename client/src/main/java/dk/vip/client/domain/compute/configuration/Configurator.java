package dk.vip.client.domain.compute.configuration;

import java.util.HashMap;
import java.util.Map;

import dk.vip.client.domain.compute.configuration.models.NetworkConfiguration;
import dk.vip.client.domain.compute.configuration.models.UserConfiguration;

public class Configurator {
    // singleton makes it easy to retrieve configuration files.
    private static Configurator instance;
    private HeadConfigurationFileHandler fileHandler;
    // Configurationmodel = instance of a configuration file
    private final Map<Class, ConfigurationModel> configurationModels;

    private Configurator() {
        configurationModels = new HashMap<>();
        configurationModels.put(NetworkConfiguration.class, new NetworkConfiguration("cfgNetwork.json"));
        configurationModels.put(UserConfiguration.class, new UserConfiguration("cfgUser.json"));
    }

    public void init() {
        loadAllConfigs();
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

    public <T extends ConfigurationModel> T loadConfig(Class<T> config) {
        return fileHandler.load(config, configurationModels.get(config).getPath());
    }

    public void loadAllConfigs() {
        for (ConfigurationModel oldConfigurationModel : configurationModels.values()) {
            ConfigurationModel newConfigurationModel = loadConfig(oldConfigurationModel.getClass());
            if (newConfigurationModel != null) {
                configurationModels.put(oldConfigurationModel.getClass(), newConfigurationModel);
            }
        }
    }

    public void setStrategy(HeadConfigurationFileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public <T extends ConfigurationModel> T get(Class<T> classModel) {
        return (T) configurationModels.get(classModel);
    }
}
