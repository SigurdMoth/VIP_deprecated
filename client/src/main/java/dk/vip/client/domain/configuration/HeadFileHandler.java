package dk.vip.client.domain.configuration;

public interface HeadFileHandler {

    boolean save(ConfigurationModel config);

    ConfigurationModel load(ConfigurationModel config);
}
