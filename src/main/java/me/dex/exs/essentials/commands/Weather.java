package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Weather implements CommandExecutor {
    private Main plugin;

    public Weather(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("thunder").setExecutor(this);
        plugin.getCommand("sun").setExecutor(this);
        plugin.getCommand("rain").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }

        Player p = (Player) sender;
        World w = p.getWorld();

        if (cmd.getName().equalsIgnoreCase("thunder")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiono pogode na: &aBurzowa"));
            w.setStorm(true);
            w.setThundering(true);
        } else if (cmd.getName().equalsIgnoreCase("sun")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiono pogode na: &aSloneczna"));
            w.setStorm(false);
            w.setThundering(false);
        } else if (cmd.getName().equalsIgnoreCase("rain")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiono pogode na: &aDeszczowa"));
            w.setStorm(true);
            w.setThundering(false);
        }

        return true;
    }
}
