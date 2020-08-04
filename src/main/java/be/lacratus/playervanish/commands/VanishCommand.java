package be.lacratus.playervanish.commands;

import be.lacratus.playervanish.PlayerVanish;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
    private PlayerVanish plugin;

    public VanishCommand(PlayerVanish playerVanish) {
        this.plugin = playerVanish;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("U bent geen speler!");
            return false;
        }
        Player player = (Player) sender;
        if(plugin.vanished.contains(player)){
            plugin.vanished.remove(player);
            plugin.vanishBar.removePlayer(player);
            for (Player x : Bukkit.getOnlinePlayers()) {
                x.showPlayer(plugin, player);
            }
            player.sendMessage("Je bent terug zichtbaar");

        } else {
            plugin.vanished.add(player);
            plugin.vanishBar.addPlayer(player);
            for (Player x : Bukkit.getOnlinePlayers()) {
                x.hidePlayer(plugin, player);
            }
            player.sendMessage("Je bent nu onzichtbaar");
        }
        return true;
    }
}
