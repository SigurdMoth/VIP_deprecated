package dk.vip.client.domain.configuration;

public interface HeadFileHandler {

    boolean save(Configuration config);

    Configuration load(Configuration config);
}
