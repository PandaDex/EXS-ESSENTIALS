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
        Player p = (Player)sender;
        if (p.getGameMode().equals(GameMode.CREATIVE)) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] Ustawiles/as swoj tryb gry na: &aPrzetrwanie"));
            p.setGameMode(GameMode.SURVIVAL);
        } else if (p.getGameMode().equals(GameMode.SURVIVAL)) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&lEXS&7] &7Ustawiles/as swoj tryb gry na: &aKreatywny"));
            p.setGameMode(GameMode.CREATIVE);
            return true;
        }
        return false;
    }
}
