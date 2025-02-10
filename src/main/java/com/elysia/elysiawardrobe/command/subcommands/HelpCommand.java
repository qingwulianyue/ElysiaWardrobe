package com.elysia.elysiawardrobe.command.subcommands;

import org.bukkit.command.CommandSender;

public class HelpCommand implements ISubCommand{
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"help"};
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("/ElysiaWardrobe help   -   获取帮助");
        sender.sendMessage("/ElysiaWardrobe reload   -   重载插件");
        sender.sendMessage("/ElysiaWardrobe add {player} {skin}   -   为玩家的时装列表增加时装");
        sender.sendMessage("/ElysiaWardrobe take {player} {skin}   -   为玩家的时装列表移除时装");
        sender.sendMessage("/ElysiaWardrobe clear {player}   -   清空玩家的全部时装");
        sender.sendMessage("/ElysiaWardrobe see {player}   -  查看玩家的全部时装");
    }
}
