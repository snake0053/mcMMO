package com.gmail.nossr50.commands.database;

import com.gmail.nossr50.config.Config;
import com.gmail.nossr50.locale.LocaleLoader;
import com.gmail.nossr50.mcMMO;
import com.google.common.collect.ImmutableList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

public class McpurgeCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            mcMMO.getDatabaseManager().purgePowerlessUsers();

            if (Config.getInstance().getOldUsersCutoff() != -1) {
                mcMMO.getDatabaseManager().purgeOldUsers();
            }

            sender.sendMessage(LocaleLoader.getString("Commands.mcpurge.Success"));
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return ImmutableList.of();
    }
}
