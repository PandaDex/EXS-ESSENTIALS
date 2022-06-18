package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.Utils.Updater;
import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class exs implements CommandExecutor {
    private Main plugin;

    public exs(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("exs").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if(args.length == 0){
                Player p = (Player) sender;
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&c-----------------------------------------------------"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Autor: &aPandaDex_"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Wersja: &a" + this.plugin.getDescription().getVersion()));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Strona: &a" + this.plugin.getDescription().getWebsite()));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&c-----------------------------------------------------"));
                return true;
            }

            if(args[0].equalsIgnoreCase("info")) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&c-----------------------------------------------------"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Autor: &aPandaDex_"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Wersja: &a" + this.plugin.getDescription().getVersion()));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Strona: &a" + this.plugin.getDescription().getWebsite()));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&c-----------------------------------------------------"));
                return true;
            }

            if(args[0].equalsIgnoreCase("update")) {
            Player p = (Player) sender;
            if(!p.hasPermission("exs.update")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &cNie masz uprawnien do tej komendy!"));
                return true; }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Wyszukiwanie aktualizacji..."));
            (new Updater(this.plugin, 101530)).getLatestVersion(version -> {
                if(!this.plugin.getDescription().getVersion().equalsIgnoreCase(version)) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Twoja wersja EXS jest &cnieaktualna"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Nowa wersja: &a" + version));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Twoja wersja: &c" + this.plugin.getDescription().getVersion()));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Zaktualizuj tutaj:&a https://www.spigotmc.org/resources/exs-essentials.101530/"));
                }
                else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Twoja wersja EXS jest &aaktualna"));
                }
            });
            return true;
            }

            if (args[0].equalsIgnoreCase("reload")) {
            Player p = (Player) sender;
            if(!p.hasPermission("exs.reload")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &cNie masz uprawnien do tej komendy!"));
                return true; }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Przeladowanie..."));
            this.plugin.reloadConfig();
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &aPrzeladowano!"));
            this.plugin.PRNTCON(ChatColor.GREEN + "Przeladowano!");
            return true;
            }
            return false;
    }
}
