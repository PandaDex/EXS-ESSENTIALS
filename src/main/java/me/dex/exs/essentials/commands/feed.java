package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.Bukkit;
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
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }
        Player target;
        if (args.length > 0) {
            target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Gracz nie jest online!"));
                return true;
            }
        } else {
            target = (Player) sender;
        }
        target.setFoodLevel(20);
        target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Zostales nakarmiony!"));
        if (!target.equals(sender)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &aNakarmiono gracza " + target.getName() + "!"));
        }
        return true;
    }
}
