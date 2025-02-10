package com.elysia.elysiawardrobe.command.subcommands;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SeeCommand implements ISubCommand{
    @Override
    public String getName() {
        return "see";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"see"};
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 2) {
            String playerName = args[1];
            Player player = Bukkit.getPlayer(playerName);
            sender.sendMessage(
                    ElysiaWardrobe.getConfigManager().getConfigData().getPrefix() +
                            "§a" + playerName + "的时装列表为："
            );
            for (String skin : ElysiaWardrobe.getPlayerManager().getPlayerData(player.getUniqueId())) {
                sender.sendMessage(
                        "§a -" + skin
                );
            }
        }
    }
}
