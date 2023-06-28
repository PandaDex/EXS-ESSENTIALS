package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class tp implements CommandExecutor {
    private Main plugin;
    private Map<UUID, Location> lastPositions;

    public tp(final Main plugin) {
        this.plugin = plugin;
        this.lastPositions = new HashMap<>();
        plugin.getCommand("tp").setExecutor(this);
        plugin.getCommand("back").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("tp")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Uzycie: &a/tp <gracz>"));
                return true;
            }

            Player target = p.getServer().getPlayer(args[0]);
            if (target == null) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &cGracz nie jest online!"));
                return true;
            }

            lastPositions.put(p.getUniqueId(), p.getLocation());

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Teleportowano do gracza &a" + target.getName()));
            p.teleport(target);
        } else if (cmd.getName().equalsIgnoreCase("back")) {
            Location lastPosition = lastPositions.get(p.getUniqueId());
            if (lastPosition == null) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &cNie masz poprzedniej lokalizacji!"));
                return true;
            }

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Teleportowano do poprzedniej lokalizacji."));
            p.teleport(lastPosition);
            lastPositions.remove(p.getUniqueId());
        }

        return true;
    }
}
