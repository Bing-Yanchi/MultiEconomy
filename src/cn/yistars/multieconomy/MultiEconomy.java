package cn.yistars.multieconomy;

import org.bukkit.plugin.java.JavaPlugin;
import cn.yistars.multieconomy.file.Configuration;

public class MultiEconomy extends JavaPlugin {
	
	private static MultiEconomy instance;
	
	@Override
	public void onLoad() {
		Configuration configuration = new Configuration(this);
		configuration.loadDefaultConfig();
	}
	
	public static MultiEconomy getInstance() {
		return instance;
	}

}
