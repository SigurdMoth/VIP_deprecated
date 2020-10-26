package dk.vip.client.domain.configuration;

public class Configuration {
    
    private final String path;

    public Configuration(String path) {
        this.path = path;
    }
    
    public String getPath(){
        return path;
    }
}
