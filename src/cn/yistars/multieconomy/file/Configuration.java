package cn.yistars.multieconomy.file;

import cn.yistars.multieconomy.MultiEconomy;

import org.bukkit.configuration.file.FileConfiguration;

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
                + "\nMultiEconomy Main Configuration file."
                + "\n"
                + "Developer: " + plugin.getDescription().getAuthors()
                + "\n");

        config.addDefault("server", "none");

        config.addDefault("mysql.database", "minecraft");
        config.addDefault("mysql.tableprefix", "gemseconomy");
        config.addDefault("mysql.host", "localhost");
        config.addDefault("mysql.port", 3306);
        config.addDefault("mysql.username", "root");
        config.addDefault("mysql.password", "password");

        
        config.options().copyDefaults(true);
        plugin.saveConfig();
        plugin.reloadConfig();
    }
}
