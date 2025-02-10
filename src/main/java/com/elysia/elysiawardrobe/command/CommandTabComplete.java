package com.elysia.elysiawardrobe.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> subCommands = new ArrayList<>();
        if (strings.length == 1) {
            if (strings[0].startsWith("h"))
                subCommands.add("help");
            else if (strings[0].startsWith("r"))
                subCommands.add("reload");
            else if (strings[0].startsWith("a"))
                subCommands.add("add");
            else if (strings[0].startsWith("t"))
                subCommands.add("take");
            else if (strings[0].startsWith("c"))
                subCommands.add("clear");
            else if (strings[0].startsWith("s"))
                subCommands.add("see");
            else {
                subCommands.add("help");
                subCommands.add("reload");
                subCommands.add("add");
                subCommands.add("take");
                subCommands.add("clear");
                subCommands.add("see");
            }
        }
        else if (strings.length == 2){
            for (Player player : Bukkit.getOnlinePlayers())
                subCommands.add(player.getName());
        }
        return subCommands;
    }
}
