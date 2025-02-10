package com.elysia.elysiawardrobe.listener;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import eos.moe.armourers.api.PlayerSkinUpdateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DragonArmourersListener implements Listener {
    @EventHandler
    public void onPlayerSkinUpdate(PlayerSkinUpdateEvent event){
        event.setSkinList(ElysiaWardrobe.getPlayerManager().getPlayerData(event.getPlayer().getUniqueId()));
    }
}
