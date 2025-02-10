package com.elysia.elysiawardrobe;

import com.elysia.elysiawardrobe.filemanager.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ElysiaWardrobe extends JavaPlugin {
    private static ElysiaWardrobe instance;
    private static ConfigManager configManager;
    public static ElysiaWardrobe getInstance() {
        return instance;
    }
    public static ConfigManager getConfigManager() {
        return configManager;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        configManager = ConfigManager.getInstance();
        createFile();
        configManager.loadConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private void createFile() {
        saveDefaultConfig();
        createDefaultFile();
    }
    private void createDefaultFile(){
        saveDefaultConfig();
        Path folderPath = getDataFolder().toPath().resolve("PlayerData");
        createDirectoryIfNotExists(folderPath);
    }
    private void createDirectoryIfNotExists(Path directoryPath) {
        if (!Files.exists(directoryPath)) {
            try {
                Files.createDirectories(directoryPath);
            } catch (IOException e) {
                throw new UncheckedIOException("Failed to create directory.", e);
            }
        }
    }
}
