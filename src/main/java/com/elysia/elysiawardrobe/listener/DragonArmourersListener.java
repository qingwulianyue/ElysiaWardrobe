package com.elysia.elysiawardrobe.listener;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import eos.moe.armourers.api.PlayerSkinUpdateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

public class DragonArmourersListener implements Listener {
    @EventHandler
    public void onPlayerSkinUpdate(PlayerSkinUpdateEvent event){
        List<String> skins = ElysiaWardrobe.getPlayerManager().getPlayerData(event.getPlayer().getUniqueId());
        if (skins == null) return;
        event.setSkinList(skins);
    }
}
