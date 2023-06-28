package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class msg implements CommandExecutor {
    private Main plugin;

    private final HashMap<UUID, UUID> replyMap = new HashMap<>();

    public msg(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("msg").setExecutor(this);
        plugin.getCommand("r").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }
        Player senderPlayer = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("msg")) {
            if (args.length < 2) {
                senderPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Uzyj: &a/msg <gracz> <wiadomosc>"));
                return true;
            }

            Player targetPlayer = plugin.getServer().getPlayer(args[0]);
            if (targetPlayer == null) {
                senderPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Gracz nie jest online!"));
                return true;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                sb.append(args[i]).append(" ");
            }
            String message = sb.toString().trim();

            targetPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a" + senderPlayer.getName() + " &7=> &cJA&7: " + message));
            senderPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aJA &7=> &c" + targetPlayer.getName() + "&7: " + message));

            replyMap.put(targetPlayer.getUniqueId(), senderPlayer.getUniqueId());

            return true;
        }

        if (cmd.getName().equalsIgnoreCase("r")) {
            UUID lastMessageSender = replyMap.get(senderPlayer.getUniqueId());
            if (lastMessageSender == null) {
                senderPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Nie masz komu odpowiedzieć!"));
                return true;
            }

            Player targetPlayer = plugin.getServer().getPlayer(lastMessageSender);
            if (targetPlayer == null) {
                senderPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Gracz nie jest online!"));
                return true;
            }

            StringBuilder sb = new StringBuilder();
            for (String arg : args) {
                sb.append(arg).append(" ");
            }
            String message = sb.toString().trim();

            targetPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a" + senderPlayer.getName() + " &7=> &cJA&7: " + message));
            senderPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aJA &7=> &c" + targetPlayer.getName() + "&7: " + message));

            replyMap.put(targetPlayer.getUniqueId(), senderPlayer.getUniqueId());

            return true;
        }

        return false;
    }
}