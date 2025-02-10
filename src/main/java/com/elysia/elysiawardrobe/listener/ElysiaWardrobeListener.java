package com.elysia.elysiawardrobe.listener;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import eos.moe.armourers.api.DragonAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;
import java.util.UUID;

public class ElysiaWardrobeListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        UUID uuid = event.getPlayer().getUniqueId();
        List<String> skins;
        if (ElysiaWardrobe.getPlayerManager().getPlayerData(uuid) == null)
            skins = ElysiaWardrobe.getConfigManager().getConfigData().getDefault_skins();
        else
            skins = ElysiaWardrobe.getPlayerManager().getPlayerData(uuid);
        if (skins == null) return;
        DragonAPI.setEntitySkin(uuid, skins);
        ElysiaWardrobe.getPlayerManager().setPlayerSkin(uuid, skins);
    }
}
