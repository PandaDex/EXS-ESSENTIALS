package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Time implements CommandExecutor {
    private Main plugin;

    public Time(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("noon").setExecutor(this);
        plugin.getCommand("night").setExecutor(this);
        plugin.getCommand("midnight").setExecutor(this);
        plugin.getCommand("day").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }

        Player p = (Player) sender;
        World w = p.getWorld();

        if (cmd.getName().equalsIgnoreCase("noon")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiles czas na: &aPoludnie"));
            w.setTime(6000L);
        } else if (cmd.getName().equalsIgnoreCase("night")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiles czas na: &aNoc"));
            w.setTime(13000L);
        } else if (cmd.getName().equalsIgnoreCase("midnight")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiles czas na: &aPolnoc"));
            w.setTime(18000L);
        } else if (cmd.getName().equalsIgnoreCase("day")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiles czas na: &aDzien"));
            w.setTime(1000L);
        }

        return true;
    }
}
