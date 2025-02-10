package com.elysia.elysiawardrobe.command.subcommands;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import eos.moe.armourers.api.DragonAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class AddCommand implements ISubCommand{
    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"a"};
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 3) {
            String playerName = args[1];
            Player player = Bukkit.getPlayer(playerName);
            String id = args[2];
            if (!DragonAPI.getAllSkins().contains(id)){
                sender.sendMessage("时装不存在");
                return;
            }
            List<String> playerSkins = ElysiaWardrobe.getPlayerManager().getPlayerData(player.getUniqueId());
            if (playerSkins != null && playerSkins.contains(id)){
                sender.sendMessage("时装已存在");
                return;
            }
            ElysiaWardrobe.getPlayerManager().addPlayerSkin(player.getUniqueId(), id);
            DragonAPI.updatePlayerSkin(player);
            player.sendMessage(
                    ElysiaWardrobe.getConfigManager().getConfigData().getPrefix() +
                            ElysiaWardrobe.getConfigManager().getConfigData().getMessages().get("enable").replace("%name%", id)
            );
        }
    }
}
