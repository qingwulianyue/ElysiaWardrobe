package com.elysia.elysiawardrobe.command.subcommands;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements ISubCommand{
    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"reload"};
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ElysiaWardrobe.getConfigManager().loadConfig();
        sender.sendMessage("重载成功");
    }
}
