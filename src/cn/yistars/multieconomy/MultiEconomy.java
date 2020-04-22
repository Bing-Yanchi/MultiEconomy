package cn.yistars.multieconomy;

import org.bukkit.plugin.java.JavaPlugin;

public class MultiEconomy extends JavaPlugin {
	
	@Override
	public void onLoad() {
		Configuration configuration = new Configuration(this);
		configuration.loadDefaultConfig();
	}

}
