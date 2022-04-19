package me.dex.exs.essentials.events;
import me.dex.exs.essentials.main.Main;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class GodEvent implements Listener {
    private Main plugin;

    public GodEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        Entity entity = e.getEntity();
        if (entity instanceof Player) {
            Player player = (Player)entity;
            if (this.plugin.getGodPlayers().contains(player))
                e.setCancelled(true);
            }
        }
    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {
        HumanEntity humanEntity = e.getEntity();
        if (humanEntity instanceof Player) {
            Player p = (Player)humanEntity;
            if (this.plugin.getGodPlayers().contains(p))
                e.setCancelled(true);
        }
    }

}
