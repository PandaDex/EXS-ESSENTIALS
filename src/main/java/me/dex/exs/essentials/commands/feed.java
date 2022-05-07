package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class feed implements CommandExecutor {
    private Main plugin;

    public feed(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("feed").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        p.setFoodLevel(20);
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Zostales/as nakarmiony!"));
        return true;
    }
}
