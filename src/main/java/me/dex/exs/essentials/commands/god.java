package me.dex.exs.essentials.commands;
import me.dex.exs.essentials.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class god implements CommandExecutor {
    private Main plugin;

    public god(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("god").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("dex.admin.god")) {
            if (this.plugin.hasGodPlayers() &&
                    this.plugin.getGodPlayers().contains(player)) {
                this.plugin.removeGodPlayer(player);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7 God mode &cWylaczono"));
                return true;
            }
            this.plugin.addGodPlayer(player);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7 God mode &aWlaczono"));
            return true;
        }
        return false;
    }
}
