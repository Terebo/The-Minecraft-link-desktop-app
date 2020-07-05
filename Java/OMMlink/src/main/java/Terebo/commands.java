package Terebo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.net.URL;

import java.io.InputStreamReader;
import java.lang.System;
import java.net.URLConnection;
import java.io.BufferedReader;

public class commands implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            System.out.println(player.getName() + ", reset the database");
            try {
                Databasereset();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
    public void Databasereset() throws Exception{
        URL Url = new URL("https://www.yourPath.here/reset.php");
        URLConnection yc = Url.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}