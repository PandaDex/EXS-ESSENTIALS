package me.dex.exs.essentials.commands;
import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class nv implements CommandExecutor {
    private Main plugin;

    public nv(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("nv").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }
        Player p = (Player)sender;
        World w = p.getWorld();
        int duration = Integer.MAX_VALUE;
        if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Widzenie w ciemnosci: &cWylaczono"));
            p.removePotionEffect(PotionEffectType.NIGHT_VISION);
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Widzenie w ciemnosci: &aWlaczono"));
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, duration, 255, false, false, false));
        }
        return true;
    }
}
