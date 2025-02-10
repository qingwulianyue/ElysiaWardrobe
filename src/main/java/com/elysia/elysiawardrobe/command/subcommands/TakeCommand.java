package com.elysia.elysiawardrobe.command.subcommands;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import eos.moe.armourers.api.DragonAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class TakeCommand implements ISubCommand{
    @Override
    public String getName() {
        return "take";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"t"};
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 3) {
            String playerName = args[1];
            Player player = Bukkit.getPlayer(playerName);
            String id = args[2];
            List<String> playerSkins = ElysiaWardrobe.getPlayerManager().getPlayerData(player.getUniqueId());
            if (!playerSkins.contains(id)){
                sender.sendMessage("时装不存在");
                return;
            }
            ElysiaWardrobe.getPlayerManager().takePlayerSkin(player.getUniqueId(), id);
            DragonAPI.updatePlayerSkin(player);
            player.sendMessage(
                    ElysiaWardrobe.getConfigManager().getConfigData().getPrefix() +
                            ElysiaWardrobe.getConfigManager().getConfigData().getMessages().get("disable").replace("%name%", id)
            );
        }
    }
}
