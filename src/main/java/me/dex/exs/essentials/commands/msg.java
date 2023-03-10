package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import me.dex.exs.essentials.Utils.Updater;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class msg implements CommandExecutor {
    private Main plugin;

    public msg(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("msg").setExecutor(this);
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (args.length == 0) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Uzyj: &a/msg <gracz> <wiadomosc>"));
            return true;
        }
        if (args.length == 1) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Uzyj: &a/msg <gracz> <wiadomosc>"));
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
            target.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&a" + p.getName() + " &7=> &c" + target.getName() + "&7: " + msg));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&aJA" + " &7=> &c" + target.getName() + "&7: " + msg));
        }
    return false;
    }
}
