package cn.yistars.multieconomy.file;

import cn.yistars.multieconomy.MultiEconomy;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Arrays;

public class Configuration {
    private MultiEconomy plugin;

    public Configuration(MultiEconomy plugin) {
        this.plugin = plugin;
    }

    public void loadDefaultConfig() {

        FileConfiguration config = plugin.getConfig();

        config.options().header(plugin.getDescription().getName()
                + "\n"
                + "Version: " + plugin.getDescription().getVersion()
                + "\nGemsEconomy Main Configuration file."
                + "\n"
                + "Developer(s): " + plugin.getDescription().getAuthors()
                + "\n\n"
                + "You have three valid storage methods, yaml, mysql or sqlite. If you choose mysql you would have to enter the database credentials down below."
                + "\n"
                + "All messages below are configurable, I hope you use them because it took 1 hour to make all of them into the plugin and configurable.");

        String path = "Messages.";

}
