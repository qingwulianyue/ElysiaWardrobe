package com.elysia.elysiawardrobe.command.subcommands;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import eos.moe.armourers.api.DragonAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetCommand implements ISubCommand{
    @Override
    public String getName() {
        return "set";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"set"};
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        String playerName = args[1];
        List<String> skin = new ArrayList<>(Arrays.asList(args).subList(2, args.length));
        Player player = Bukkit.getPlayer(playerName);
        ElysiaWardrobe.getPlayerManager().setPlayerSkin(player.getUniqueId(), skin);
        DragonAPI.updatePlayerSkin(player);
    }
}
