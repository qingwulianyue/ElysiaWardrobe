package com.elysia.elysiawardrobe.filemanager;

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
}
