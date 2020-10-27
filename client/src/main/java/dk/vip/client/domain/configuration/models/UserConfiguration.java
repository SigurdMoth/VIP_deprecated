package dk.vip.client.domain.configuration.models;

import dk.vip.client.domain.configuration.ConfigurationModel;

public class UserConfiguration extends ConfigurationModel {

    private String name;

    public UserConfiguration(String path) {
        super(path);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return "name=" + name;
    }
}
