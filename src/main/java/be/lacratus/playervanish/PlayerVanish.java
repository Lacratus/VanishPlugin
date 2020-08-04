package be.lacratus.playervanish;

import be.lacratus.playervanish.commands.VanishCommand;
import be.lacratus.playervanish.listeners.PlayerJoinListener;
import be.lacratus.playervanish.listeners.PlayerQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class PlayerVanish extends JavaPlugin {
    public List<Player> vanished = new ArrayList<>();
    public BossBar vanishBar = Bukkit.createBossBar("Vanished", BarColor.BLUE, BarStyle.SEGMENTED_6);

    @Override
    public void onEnable() {
        System.out.println("Vanishplugin Enabled");

        //commands
        getCommand("vanish").setExecutor(new VanishCommand(this));
        //listeners
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(this), this);

    }

    @Override
    public void onDisable() {
        System.out.println("Vanishplugin Disabled");}

}
