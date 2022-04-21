package me.dex.exs.essentials.Utils;

import me.dex.exs.essentials.main.Main;
import me.dex.exs.essentials.Utils.Updater;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UpdateMsg implements Listener {
    private Main plugin;

    public UpdateMsg(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(p.hasPermission("exs.update")) {
            (new Updater(this.plugin, 101530)).getLatestVersion(version -> {
                if(!this.plugin.getDescription().getVersion().equalsIgnoreCase(version)) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Twoja wersja EXS jest &cnieaktualna"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Nowa wersja: &a" + version));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Twoja wersja: &a" + this.plugin.getDescription().getVersion()));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Zaktualizuj tutaj:&a https://www.spigotmc.org/resources/exs-essentials.101530/"));
                }
            });
        }
    }
}
