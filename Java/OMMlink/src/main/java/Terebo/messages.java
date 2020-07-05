package Terebo;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.InputStreamReader;
import java.lang.System;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;

import org.bukkit.entity.Player;

public class messages implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String message = player.getName() + " joined the game!";
        try {
            database(message, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        String player = event.getPlayer().getName();
        String message = player + " left the game!";
        try {
            database(message, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String player = event.getPlayer().getName();
        String message = event.getMessage();
        System.out.println(player);
        try {
            database(message, player + ">");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void database(String message, String player) throws Exception{
        //invokes a php script on the server you have your database on (can be the same server)
        // TODO Change this URL before throwing onto github
        URL Url = new URL("www.yourPath.here/script.php?player=" + player + "&message=" + message.replace(" ", "+").replace("&", "%26").replace("=", "%3D"));
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