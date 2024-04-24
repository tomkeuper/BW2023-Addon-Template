package com.tomkeuper.bedwars.addon.integrations;

import com.tomkeuper.bedwars.addon.ShopCommands;
import com.tomkeuper.bedwars.addon.support.BW2023;
import com.tomkeuper.bedwars.api.BedWars;
import org.bukkit.Bukkit;

public class BedWars2023 implements IIntegration{
    private final ShopCommands plugin;
    private BedWars bedwars;

    public BedWars2023(ShopCommands plugin, BedWars bedwars) {
        this.plugin = plugin;
        this.bedwars = bedwars;
    }

    @Override
    public boolean isRunning() {
        return enable();
    }

    @Override
    public boolean isPresent() {
        return Bukkit.getPluginManager().getPlugin("BedWars2023") != null;
    }

    @Override
    public boolean isEnabled() {
        return Bukkit.getPluginManager().isPluginEnabled("BedWars2023");

    }

    @Override
    public boolean enable() {
        if (isPresent()){
            this.bedwars = Bukkit.getServicesManager().getRegistration(BedWars.class).getProvider();
            bedwars.getAddonsUtil().registerAddon(new BW2023());
            plugin.getLogger().info("&fBedWars was found and hooked &aSuccessfully&f!");
            return true;
        } else {
            plugin.getLogger().severe("&cBedWars could not be located and is required to use this addon!");
            return false;
        }
    }

    @Override
    public void disable() {

    }
}
