package com.tomkeuper.bedwars.addon;

import com.avaje.ebeaninternal.server.lib.util.NotFoundException;
import com.tomkeuper.bedwars.addon.integrations.BedWars2023;
import com.tomkeuper.bedwars.addon.integrations.IIntegration;
import com.tomkeuper.bedwars.api.BedWars;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class ShopCommands extends JavaPlugin {
    public static BedWars bedWars;
    public static ShopCommands plugin;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        populateIntegrations(new BedWars2023(this, bedWars = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider()));
    }

    private void populateIntegrations(IIntegration... integrations) {
        for (IIntegration integration : integrations) {
            if (!integration.enable()) {
                throw new NotFoundException("Plugin could not be enabled as on or more of the dependencies could not be hooked.");
            }
        }
    }
    public boolean isBedWarsInstalled(){
        return Bukkit.getPluginManager().getPlugin("BedWars2023") != null;
    }

    public static void registerEvents(Listener... listeners) {
        Arrays.stream(listeners).forEach(l -> plugin.getServer().getPluginManager().registerEvents(l, plugin));
    }

    public static BedWars getBedWars() {
        return bedWars;
    }

    public static ShopCommands getInstance(){
        return plugin;
    }

    public static void debug(String msg){
        plugin.getLogger().info("[DEBUG] - " + msg);
    }
}
