package dk.vip.client.domain.configuration;

public enum EnumConfig {
    NETWORK(new NetworkConfiguration("cfgNetwork.json")), USER(new UserConfiguration("cfgUser.json"));

    Configuration configuration;

    private EnumConfig(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration get() {
        return configuration;
    }
}