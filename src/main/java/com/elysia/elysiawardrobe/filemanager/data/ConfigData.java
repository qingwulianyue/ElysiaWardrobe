package com.elysia.elysiawardrobe.filemanager.data;

import java.util.HashMap;
import java.util.List;

public class ConfigData {
    private final boolean debug;
    private final String prefix;
    private final int save_timer;
    private final boolean save_tips;
    private final List<String> default_skins;
    private final HashMap<String, String> messages;

    public ConfigData(boolean debug, String prefix, int saveTimer, boolean saveTips, List<String> defaultSkins, HashMap<String, String> messages) {
        this.debug = debug;
        this.prefix = prefix;
        save_timer = saveTimer;
        save_tips = saveTips;
        default_skins = defaultSkins;
        this.messages = messages;
    }

    public boolean isDebug() {
        return debug;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getSave_timer() {
        return save_timer;
    }

    public boolean isSave_tips() {
        return save_tips;
    }

    public List<String> getDefault_skins() {
        return default_skins;
    }

    public HashMap<String, String> getMessages() {
        return messages;
    }
}
