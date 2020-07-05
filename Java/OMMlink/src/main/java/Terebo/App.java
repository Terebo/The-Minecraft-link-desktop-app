package Terebo;

import org.bukkit.plugin.java.JavaPlugin;
import java.net.URL;

import java.io.InputStreamReader;
import java.lang.System;
import java.net.URLConnection;
import java.io.BufferedReader;

public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        try {
            Databasereset();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getLogger().info("Hej hej!");
        getServer().getPluginManager().registerEvents(new messages(), this);
        this.getCommand("reset").setExecutor(new commands());
        try {
            database("The server is online again!", "");;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onDisable() {
        try {
            database("the server went offline!!", "");;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Databasereset();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getLogger().info("Bye bye!");
        try {
            database("It looks like the server is offline", "");;
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void database(String message, String player) throws Exception{
        //invokes a php script on the server you have your database on (can be the same server)
        URL Url = new URL("https://www.yourPath.here/script.php?player=" + player + "&message=" + message.replace(" ", "+").replace("&", "%26").replace("=", "%3D"));
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
