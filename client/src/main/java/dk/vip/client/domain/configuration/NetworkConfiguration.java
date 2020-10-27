package dk.vip.client.domain.configuration;

public class NetworkConfiguration extends ConfigurationModel {

    private String node;
    private String network;

    public NetworkConfiguration(String path) {
        super(path);
    }

    public String getNode() {
        return this.node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getNetwork() {
        return this.network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    // to json

    // send to persistence and save to file
}
