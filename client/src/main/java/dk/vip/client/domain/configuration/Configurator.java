package dk.vip.client.domain.configuration;

public class Configurator {

    private static Configurator instance;
    private HeadFileHandler fileHandler;

    public static Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator();
        }
        return instance;
    }

    public void setStrategy(HeadFileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void saveConfig(EnumConfig config){
        fileHandler.save(config.get());
    }

    public Configuration loadConfig(EnumConfig config){
        return fileHandler.load(config.get());
    }
}
