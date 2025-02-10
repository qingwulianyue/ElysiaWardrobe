package com.elysia.elysiawardrobe;

import com.elysia.elysiawardrobe.command.CommandManager;
import com.elysia.elysiawardrobe.filemanager.ConfigManager;
import com.elysia.elysiawardrobe.filemanager.PlayerManager;
import com.elysia.elysiawardrobe.listener.DragonArmourersListener;
import com.elysia.elysiawardrobe.listener.ElysiaWardrobeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ElysiaWardrobe extends JavaPlugin {
    private static ElysiaWardrobe instance;
    private static ConfigManager configManager;
    private static PlayerManager playerManager;
    public static ElysiaWardrobe getInstance() {
        return instance;
    }
    public static ConfigManager getConfigManager() {
        return configManager;
    }
    public static PlayerManager getPlayerManager() {
        return playerManager;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        configManager = ConfigManager.getInstance();
        playerManager = PlayerManager.getInstance();
        createFile();
        configManager.loadConfig();
        Bukkit.getPluginManager().registerEvents(new ElysiaWardrobeListener(), this);
        Bukkit.getPluginManager().registerEvents(new DragonArmourersListener(), this);
        Bukkit.getPluginCommand("ElysiaWardrobe").setExecutor(new CommandManager());
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
