package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class oe implements CommandExecutor {
    private Main plugin;

    public oe(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("oe").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }

        Player target;
        if (args.length == 0) {
            target = (Player) sender;
        } else if (args.length == 1) {
            target = plugin.getServer().getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Gracz nie jest online!"));
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Uzyj: &a/oe <gracz>"));
            return false;
        }

        ((Player) sender).openInventory(target.getEnderChest());
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Otwarto ender chest gracza: &a" + target.getName()));
        return true;
    }
}
