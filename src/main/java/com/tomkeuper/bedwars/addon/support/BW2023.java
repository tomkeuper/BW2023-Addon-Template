package com.tomkeuper.bedwars.addon.support;

import com.tomkeuper.bedwars.addon.ShopCommands;
import com.tomkeuper.bedwars.api.addon.Addon;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class BW2023 extends Addon {

    public static BW2023 instance;

    public BW2023() {
        instance = this;
    }

    @Override
    public String getAuthor() {
        return ShopCommands.getInstance().getDescription().getAuthors().get(0);
    }

    @Override
    public Plugin getPlugin() {
        return ShopCommands.getInstance();
    }

    @Override
    public String getVersion() {
        return ShopCommands.getInstance().getDescription().getVersion();
    }

    @Override
    public String getDescription() {
        return ShopCommands.getInstance().getDescription().getDescription();
    }

    @Override
    public String getName() {
        return ShopCommands.getInstance().getDescription().getName();
    }

    @Override
    public void load() {
        Bukkit.getPluginManager().enablePlugin(ShopCommands.getInstance());
    }

    @Override
    public void unload() {
        Bukkit.getPluginManager().disablePlugin(ShopCommands.getInstance());
    }

}
