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

public class Tp implements CommandExecutor {
    private Main plugin;
    private Map<UUID, Location> lastPositions;

    public Tp(final Main plugin) {
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
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Uzycie: &c/tp <gracz | x y z> [gracz2]"));
                return true;
            }

            if (args.length == 1) {
                Player target = p.getServer().getPlayer(args[0]);
                if (target == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Gracz nie jest online!"));
                    return true;
                }

                lastPositions.put(p.getUniqueId(), p.getLocation());

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Teleportowano do gracza &a" + target.getName()));
                p.teleport(target);
            } else if (args.length == 3) {
                try {
                    double x = parseCoordinate(p.getLocation().getX(), args[0]);
                    double y = parseCoordinate(p.getLocation().getY(), args[1]);
                    double z = parseCoordinate(p.getLocation().getZ(), args[2]);

                    Location location = new Location(p.getWorld(), x, y, z);
                    lastPositions.put(p.getUniqueId(), p.getLocation());

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Teleportowano na pozycje: &a" + x + " " + y + " " + z));
                    p.teleport(location);
                } catch (NumberFormatException e) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Niepoprawne wspolrzedne! Uzyj: &c/tp <gracz | x y z> [gracz2] "));
                }
            } else {
                Player target1 = p.getServer().getPlayer(args[0]);
                Player target2 = p.getServer().getPlayer(args[1]);

                if (target1 == null || target2 == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Gracz nie jest online!"));
                    return true;
                }

                lastPositions.put(target1.getUniqueId(), target1.getLocation());

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Teleportowano gracza &a" + target1.getName() + " &7do gracza &a" + target2.getName()));
                target1.teleport(target2);
            }
        } else if (cmd.getName().equalsIgnoreCase("back")) {
            Location lastPosition = lastPositions.get(p.getUniqueId());
            if (lastPosition == null) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Nie masz poprzedniej lokalizacji!"));
                return true;
            }

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Teleportowano do poprzedniej lokalizacji."));
            p.teleport(lastPosition);
            lastPositions.remove(p.getUniqueId());
        }
        return true;
    }

    private double parseCoordinate(double current, String arg) throws NumberFormatException {
        if (arg.equals("~")) {
            return current;
        } else if (arg.startsWith("~")) {
            double offset = Double.parseDouble(arg.substring(1));
            return current + offset;
        } else {
            return Double.parseDouble(arg);
        }
    }
}
