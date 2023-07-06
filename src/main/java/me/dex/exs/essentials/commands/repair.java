package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class repair implements CommandExecutor {
    private Main plugin;

    public repair(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("repair").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Komenda tylko dla graczy!"));
            return true;
        }

        Player p = (Player) sender;
        if (args.length == 0) {
            // Repair the item the player is currently holding
            ItemStack item = p.getInventory().getItemInMainHand();
            if (item == null || item.getType() == Material.AIR) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Nie trzymasz zadnego przedmiotu w rece!"));
                return true;
            }

            item.setDurability((short) 0);
            p.getInventory().setItemInMainHand(item);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Naprawiono przedmiot w twojej rece!"));
            return true;
        } else if (args.length == 1 && args[0].equalsIgnoreCase("all")) {
            // Repair all items in the player's inventory
            for (ItemStack item : p.getInventory().getContents()) {
                if (item != null && item.getType() != Material.AIR) {
                    item.setDurability((short) 0);
                }
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Naprawiono wszystkie przedmioty w twoim ekwipunku!"));
            return true;
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Nieprawidłowe użycie! Poprawne użycie: /repair lub /repair all"));
        }
        return false;
    }
}