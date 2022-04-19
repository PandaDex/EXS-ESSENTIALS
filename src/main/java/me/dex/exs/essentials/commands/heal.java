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
        plugin.getCommand("heal").setExecutor((CommandExecutor)this);
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if(p.hasPermission("exs.admin.heal")) {
            for (PotionEffect effect : p.getActivePotionEffects())
                p.removePotionEffect(effect.getType());
            p.setHealth(20.0D);
            p.setFoodLevel(20);
            p.setFireTicks(0);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Zostales wyleczony!"));
            return true;
        }
        return false;
    }


}
