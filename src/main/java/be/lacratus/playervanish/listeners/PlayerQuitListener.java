package be.lacratus.playervanish.listeners;

import be.lacratus.playervanish.PlayerVanish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private PlayerVanish plugin;

    public PlayerQuitListener(PlayerVanish playerVanish) {
        this.plugin = playerVanish;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        //Wanneer een speler disconnect of crashed zal hij niet meer vanished zijn bij het terugjoinen.
        if(plugin.isVanished(player)) {
            plugin.removeVanishedPlayer(player);
            plugin.removeVanishedPlayer(player);
        }



    }
}