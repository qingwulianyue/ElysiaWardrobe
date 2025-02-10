package com.elysia.elysiawardrobe.filemanager;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import com.elysia.elysiawardrobe.filemanager.data.ConfigData;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public class ConfigManager {
    private ConfigManager(){}
    private static final ConfigManager instance = new ConfigManager();
    private ConfigData configData;
    public static ConfigManager getInstance(){
        return instance;
    }
    public ConfigData getConfigData(){
        if (configData == null)
            loadConfig();
        return configData;
    }
    public void loadConfig(){
        configData = null;
        ElysiaWardrobe.getInstance().reloadConfig();
        FileConfiguration config = ElysiaWardrobe.getInstance().getConfig();
        HashMap<String, String> messages = new HashMap<>();
        for (String key : config.getConfigurationSection("messages").getKeys(false))
            messages.put(key, config.getString("messages." + key));
        configData = new ConfigData(
                config.getBoolean("debug"),
                config.getString("prefix"),
                config.getInt("save_timer"),
                config.getBoolean("save_tips"),
                config.getStringList("default_skins"),
                messages
        );
        logConfigInfoIfDebug();
    }
    private void logConfigInfoIfDebug(){
        if (configData.isDebug()){
            ElysiaWardrobe.getInstance().getLogger().info("§eDebug: §a" + configData.isDebug());
            ElysiaWardrobe.getInstance().getLogger().info("§ePrefix: §a" + configData.getPrefix());
            ElysiaWardrobe.getInstance().getLogger().info("§eSave Timer: §a" + configData.getSave_timer());
            ElysiaWardrobe.getInstance().getLogger().info("§eSave Tips: §a" + configData.isSave_tips());
            ElysiaWardrobe.getInstance().getLogger().info("§eDefault Skins: §a" + configData.getDefault_skins());
            ElysiaWardrobe.getInstance().getLogger().info("§eMessages:");
            for (String key : configData.getMessages().keySet())
                ElysiaWardrobe.getInstance().getLogger().info("§e" + key + ": §a" + configData.getMessages().get(key));
        }
    }
}
