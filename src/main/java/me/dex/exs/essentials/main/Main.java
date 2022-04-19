package me.dex.exs.essentials.main;

import me.dex.exs.essentials.commands.*;
import me.dex.exs.essentials.events.GodEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin{
    private List<Player> GodPlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        new gm(this);
        new day(this);
        new night(this);
        new nv(this);
        new sun(this);
        new fly(this);
        new flySpeed(this);
        registerEvents();
    }

    @Override
    public void onDisable() {
        getLogger().info("Bye! :)");
    }

    //god
    public void addGodPlayer(Player player) {
        this.GodPlayers.add(player);
    }
    public void removeGodPlayer(Player player) {
        this.GodPlayers.remove(player);
    }
    public List<Player> getGodPlayers() {
        return this.GodPlayers;
    }
    public boolean hasGodPlayers() {
        if (this.GodPlayers.isEmpty())
            return false;
        return true;
    }
    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new GodEvent(this), (Plugin)this);
    }
    //god
}