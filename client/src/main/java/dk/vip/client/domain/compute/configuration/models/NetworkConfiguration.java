package dk.vip.client.domain.compute.configuration.models;

import dk.vip.client.domain.compute.configuration.ConfigurationModel;

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

    @Override
    public String toString() {
        return "NetworkConfiguration: node=" + node + "\t network=" + network;
    }
}
