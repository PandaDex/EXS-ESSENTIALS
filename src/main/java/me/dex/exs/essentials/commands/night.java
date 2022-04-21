package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class night implements CommandExecutor {
    private Main plugin;

    public night(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("night").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        World w = p.getWorld();
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiles/as czas na: &aNoc"));
        w.setTime(13000L);
        return true;
    }
}