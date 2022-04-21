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
        Player p = (Player)sender;
        World w = p.getWorld();
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7trzymales/as efekt: &aWidzenie w ciemnosci"));
        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 255, true));
        return true;
    }
}
