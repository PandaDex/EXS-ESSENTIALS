package me.dex.exs.essentials.commands;
import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class flySpeed implements CommandExecutor {
    private Main plugin;

    public flySpeed(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("flySpeed").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        World w = p.getWorld();

        if (args.length == 0) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Predkosc lotu musi byc podana w przedziale &aod 1 do 10"));
            return false;
        }
        if (args.length == 1) {
            boolean var6 = true;
            int speed;
            try {
                speed = Integer.parseInt(args[0]);
            } catch (NumberFormatException var8) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Predkosc lotu musi byc podana w przedziale &aod 1 do 10"));
                return true;
            }
            if (speed >= -10 && speed <= 10) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiono predkosc lotu na: &a" + speed));
                p.setFlySpeed((float) speed / 10.0F);
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Predkosc lotu musi byc podana w przedziale &aod 1 do 10"));
            }
        }
        return true;
    }
}
