package com.elysia.elysiawardrobe.command.subcommands;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import eos.moe.armourers.api.DragonAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ClearCommand implements ISubCommand{
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"c"};
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 2) {
            String playerName = args[1];
            Player player = Bukkit.getPlayer(playerName);
            ElysiaWardrobe.getPlayerManager().clearPlayerData(player.getUniqueId());
            DragonAPI.updatePlayerSkin(player);
        }
    }
}
