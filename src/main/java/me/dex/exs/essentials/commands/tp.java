package me.dex.exs.essentials.commands;

import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class tp implements CommandExecutor {
    private Main plugin;

    public tp(final Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("tp").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;
        Player t = (Player)p.getServer().getPlayer(args[0]);
        if (args.length == 0) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Uzycie: &a/tp <gracz>"));
        }
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Teleportacja do &a" + t.getName() + " &7Za &a3 &7Sekundy."));
        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {
                p.teleport(t);
            }
        };
        task.runTaskLater(plugin, 20L * 3);
        return true;
    }
}
