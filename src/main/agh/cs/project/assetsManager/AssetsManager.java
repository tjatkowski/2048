package agh.cs.project.assetsManager;

import java.util.HashMap;

public class AssetsManager {
    public static AssetsManager ASSETS = new AssetsManager();

    public AssetsManager() {
        container = new HashMap<>();

    }

    public void put(String key, Object value) {
        if(!container.containsKey(key)) {
            container.put(key, value);
        }
    }

    public Object get(String key) {
        Object asset = container.get(key);
        if(asset != null)
            return asset;
        throw new IllegalArgumentException("Couldn't find asset " + key);
    }

    private HashMap<String, Object> container;
}
