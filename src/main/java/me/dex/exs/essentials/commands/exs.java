package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class exs implements CommandExecutor {
    private Main plugin;

    public exs(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("exs").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&c-----------------------------------------------------"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Author: &aPandaDex_"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Version: &a1.0.0"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Repo: &ahttps://github.com/PandaDex/EXS-ESSENTIALS"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&c-----------------------------------------------------"));
        return true;
    }

}
