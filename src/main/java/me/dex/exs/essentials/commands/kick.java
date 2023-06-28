package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kick implements CommandExecutor {
    private Main plugin;

    public kick(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("kick").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }
        Player p = (Player)sender;
        if (args.length == 0) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Uzyj: &a/kick <gracz> <powod>"));
            return true;
        }
        if (args.length == 1) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Uzyj: &a/kick <gracz> <powod>"));
            return true;
        }
        if (args.length >= 2) {
            Player target = plugin.getServer().getPlayer(args[0]);
            if (target == null) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Gracz nie jest online!"));
                return true;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                sb.append(args[i]).append(" ");
            }
            String msg = sb.toString();
            target.kickPlayer(ChatColor.translateAlternateColorCodes('&',  "&cZostales wyrzucony \n \n &7Przez: &c" + p.getName() + "\n &7Powod: &c" + msg));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Wyrzucono gracza &a" + target.getName() + "&7!"));
        }
        return false;
    }
}
