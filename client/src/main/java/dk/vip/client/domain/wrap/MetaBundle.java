package dk.vip.client.domain.wrap;

import java.util.HashMap;
import java.util.Map;

public class MetaBundle {
    private final String name;
    private final Map<String, Object> properties;

    public MetaBundle(String name) {
        properties = new HashMap<>();
        this.name = name;
    }

    public void put(String key, Object value) {
        properties.put(key, value);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public String getName() {
        return name;
    }
}
