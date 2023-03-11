package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gm implements CommandExecutor {
    private Main plugin;

    public gm(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("gm").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }
        Player p = (Player)sender;
        GameMode gameMode;

        // Sprawdzenie, czy podano argument
        if (args.length == 1) {
            // Sprawdzenie, czy podany argument jest prawidłowy
            try {
                int mode = Integer.parseInt(args[0]);
                gameMode = GameMode.getByValue(mode);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Uzyj: &a/gm <tryb>"));
                return true;
            }

            if (gameMode == null) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Nieprawidlowy tryb!"));
                return true;
            }
        } else {
            // Zmiana trybu gry na przeciwny
            if (p.getGameMode().equals(GameMode.CREATIVE)) {
                gameMode = GameMode.SURVIVAL;
            } else {
                gameMode = GameMode.CREATIVE;
            }
        }

        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiles swoj tryb gry na: &a" + gameMode.toString()));
        p.setGameMode(gameMode);
        return true;
    }
}
