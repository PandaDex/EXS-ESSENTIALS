package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class midnight implements CommandExecutor {
    private Main plugin;

    public midnight(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("midnight").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }
        Player p = (Player)sender;
        World w = p.getWorld();
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiles czas na: &aPolnoc"));
        w.setTime(18000L);
        return true;
    }
}
