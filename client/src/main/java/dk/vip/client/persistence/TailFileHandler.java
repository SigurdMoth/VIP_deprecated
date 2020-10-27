package dk.vip.client.persistence;

import java.io.File;
import java.io.FileWriter;

import com.google.gson.Gson;

import dk.vip.client.domain.configuration.ConfigurationModel;
import dk.vip.client.domain.configuration.HeadFileHandler;

public class TailFileHandler implements HeadFileHandler {

    @Override
    public boolean save(ConfigurationModel config) {
        Gson gson = new Gson();
        String json = gson.toJson(config);

        File file = new File(config.getPath());
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(json);
        } catch (Exception e) {
            System.err.println(e + " filepath: " + file.getAbsolutePath());
            return false;
        }
        return true;
    }

    @Override
    public ConfigurationModel load(ConfigurationModel config) {
        return null;
    }
}
