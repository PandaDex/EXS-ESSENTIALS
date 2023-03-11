package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class heal implements CommandExecutor {
    private Main plugin;

    public heal(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("heal").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }

        Player target;
        if (args.length == 1) {
            target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Gracz nie jest online! "));
                return true;
            }
        } else {
            target = (Player) sender;
        }

        for (PotionEffect effect : target.getActivePotionEffects()) {
            target.removePotionEffect(effect.getType());
        }

        target.setHealth(20.0D);
        target.setFireTicks(0);
        target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Zostales wyleczony!"));

        if (target != sender) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Wyleczyles gracza: &a" + target.getName()));
        }

        return true;
    }
}
