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
        //Werkt niet bij uitvoerding door console
        if (!(sender instanceof Player)) {
            sender.sendMessage("U bent geen speler!");
            return false;
        }
        Player player = (Player) sender;
        //Persoon in vanish zal tevoorschijn komen
        if(plugin.isVanished(player)){
            plugin.removeVanishedPlayer(player);
            for (Player unvanishedPlayer : Bukkit.getOnlinePlayers()) {
                unvanishedPlayer.showPlayer(plugin, player);
            }
            player.sendMessage("Je bent terug zichtbaar");

        } else {
            //Persoon zal in vanish terechtkomen
            plugin.addVanishedPlayer(player);
            for (Player vanishedPlayer : Bukkit.getOnlinePlayers()) {
                vanishedPlayer.hidePlayer(plugin, player);
            }
            player.sendMessage("Je bent nu onzichtbaar");
        }
        return true;
    }
}
