package Terebo;
import org.bukkit.plugin.java.JavaPlugin;


public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Hej hej!");
        this.getCommand("welcome").setExecutor(new commandwelcome());
        getServer().getPluginManager().registerEvents(new entermessage(), this);
    }
    @Override
    public void onDisable() {
        getLogger().info("Bye bye!");
    }

}
