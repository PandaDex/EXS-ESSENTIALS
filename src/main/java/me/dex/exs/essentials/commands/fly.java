package me.dex.exs.essentials.commands;
import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class fly implements CommandExecutor {
    private Main plugin;

    public fly(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("fly").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }
        Player p = (Player) sender;
        World w = p.getWorld();
        if (p.getAllowFlight()) {
            p.setFlying(false);
            p.setAllowFlight(false);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Latanie: &cWylaczone "));
        } else {
            p.setAllowFlight(true);
            p.setFlySpeed(0.1F);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Latanie: &aWlaczone "));
        }
        return true;
    }
}
