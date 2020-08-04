package be.lacratus.playervanish.listeners;

import be.lacratus.playervanish.PlayerVanish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private PlayerVanish plugin;

    public PlayerJoinListener(PlayerVanish playerVanish) {
        this.plugin = playerVanish;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        //Als een speler joined zullen alle andere spelers die in vanish zitten verdwijnen
        for (Player vanishedSpeler : plugin.getVanished()) {
            player.hidePlayer(plugin,vanishedSpeler);
        }

    }
}
