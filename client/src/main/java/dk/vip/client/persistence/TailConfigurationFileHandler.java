package dk.vip.client.persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

import com.google.gson.Gson;

import dk.vip.client.domain.configuration.ConfigurationModel;
import dk.vip.client.domain.configuration.HeadConfigurationFileHandler;

public class TailConfigurationFileHandler implements HeadConfigurationFileHandler {

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
    public <T extends ConfigurationModel> T load(Class<T> config, String path) {
        Gson gson = new Gson();
        File file = new File(path);

        try (Reader reader = new FileReader(file)) {
            return gson.fromJson(reader, config);
        } catch (Exception e) {
            System.err.println(e + " filepath: " + file.getAbsolutePath());
        }
        return null;
    }
}
