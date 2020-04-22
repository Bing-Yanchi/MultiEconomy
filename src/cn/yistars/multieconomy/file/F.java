package cn.yistars.multieconomy.file;

import cn.yistars.multieconomy.MultiEconomy;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class F {
    private static MultiEconomy plugin = MultiEconomy.getInstance();
    private static FileConfiguration cfg = plugin.getConfig();

    private static String get(String path){
        return colorize(cfg.getString(path));
    }

    private static List<String> getList(String path){
        List<String> str = new ArrayList<>();
        for(String s : cfg.getStringList(path)){
            str.add(colorize(s));
        }
        return str;
    }
    
    private static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    
    
}