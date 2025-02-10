package com.elysia.elysiawardrobe.filemanager;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PlayerManager {
    private PlayerManager(){}
    private static final PlayerManager instance = new PlayerManager();
    public static PlayerManager getInstance() {
        return instance;
    }
    private final HashMap<UUID, List<String>> playerDataHashMap = new HashMap<>();
    public List<String> getPlayerData(UUID uuid) {
        return playerDataHashMap.getOrDefault(uuid, null);
    }
    public void addPlayerSkin(UUID uuid, String skin){
        List<String> playerData = playerDataHashMap.getOrDefault(uuid, new ArrayList<>());
        playerData.add(skin);
        playerDataHashMap.put(uuid, playerData);
    }
    public void takePlayerSkin(UUID uuid, String skin){
        List<String> playerData = playerDataHashMap.getOrDefault(uuid, new ArrayList<>());
        playerData.remove(skin);
        playerDataHashMap.put(uuid, playerData);
    }
    public void setPlayerSkin(UUID uuid, List<String> skin){
        playerDataHashMap.put(uuid, skin);
    }
    public void clearPlayerData(UUID uuid){
        playerDataHashMap.put(uuid, new ArrayList<>());
    }
    public void loadPlayerData() {
        findAllYmlFiles(new File(ElysiaWardrobe.getInstance().getDataFolder() + "/PlayerData"));
    }
    private void findAllYmlFiles(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 如果是文件夹则递归查找
                    findAllYmlFiles(file);
                } else {
                    File playerDataFolder = new File(folder + "/" + file.getName());
                    YamlConfiguration config = YamlConfiguration.loadConfiguration(playerDataFolder);
                    loadPlayerData(config);
                }
            }
        }
    }
    private void loadPlayerData(YamlConfiguration config) {
        playerDataHashMap.put(UUID.fromString(config.getString("uuid")), config.getStringList("skins"));
    }
    public void savePlayerData() {
        for (UUID uuid : playerDataHashMap.keySet()) {
            Path playerDataPath = ElysiaWardrobe.getInstance().getDataFolder().toPath().resolve("PlayerData").resolve(uuid.toString());
            YamlConfiguration yamlConfiguration = new YamlConfiguration();
            yamlConfiguration.set("uuid", uuid.toString());
            yamlConfiguration.set("skins", playerDataHashMap.get(uuid));
            try {
                yamlConfiguration.save(playerDataPath.toFile());
            } catch (IOException e) {
                throw new UncheckedIOException("Failed to save player data.", e);
            }
        }
    }
}
