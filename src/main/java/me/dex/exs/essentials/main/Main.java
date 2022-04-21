package me.dex.exs.essentials.main;

import me.dex.exs.essentials.Utils.Updater;
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
        PRNTCON("Witaj w EXS!");
        PRNTCON("Wyszukiwanie aktualizacji...");
        CheckUpdate();
        new gm(this);
        new day(this);
        new night(this);
        new nv(this);
        new sun(this);
        new fly(this);
        new flySpeed(this);
        new god(this);
        new exs(this);
        new heal(this);
        new feed(this);
        registerEvents();
    }

    @Override
    public void onDisable() {
        PRNTCON("Bye!");
    }

    public void PRNTCON(String msg) {
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "EXS" + ChatColor.GRAY + "]" + ChatColor.RESET + " " + msg);
    }

    public void CheckUpdate(){
        (new Updater(this, 101530)).getLatestVersion(version -> {
                    if (getDescription().getVersion().equalsIgnoreCase(version)) {
                        PRNTCON("Uzywasz najnowszej wersji!");
                    }else{
                        PRNTCON("Twoja wersja EXS jest " + ChatColor.DARK_RED + "nieaktualna!");
                        PRNTCON("Najnowsza wersja to: " + ChatColor.GREEN + version);
                        PRNTCON("Twoja wersja to: " + ChatColor.RED + getDescription().getVersion());
                        PRNTCON("Zaktualizuj tutaj: " + ChatColor.GREEN + "https://www.spigotmc.org/resources/exs-essentials.101530/");
                    }
                });
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