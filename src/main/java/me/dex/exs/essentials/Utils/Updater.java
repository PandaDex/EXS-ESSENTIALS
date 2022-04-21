package me.dex.exs.essentials.Utils;

import me.dex.exs.essentials.main.Main;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Updater {
    private Main plugin;

    private int ID;

    public Updater(Main plugin, int ID) {
        this.plugin = plugin;
        this.ID = ID;
    }

    public void getLatestVersion(Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)this.plugin, () -> {
            try(InputStream inputStream = (new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.ID)).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext())
                    consumer.accept(scanner.next());
            } catch (IOException exception) {
                this.plugin.getLogger().info("Nie udalo sie pobrac informacji o wersji " + exception.getMessage());
            }
        });
    }
}
