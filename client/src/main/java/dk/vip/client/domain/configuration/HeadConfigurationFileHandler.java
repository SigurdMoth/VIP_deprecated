package dk.vip.client.domain.configuration;

public interface HeadConfigurationFileHandler {

    boolean save(ConfigurationModel config);

    ConfigurationModel load(ConfigurationModel config);
}
