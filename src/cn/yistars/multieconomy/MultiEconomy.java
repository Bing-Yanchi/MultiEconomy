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
	
    @Override
    public void onEnable(){
        instance = this;

        nmsVersion = new NMSVersion();
        chequeManager = new ChequeManager(this);
        economyLogger = new EcoLogger(this);
        metrics = new Metrics(this);
        updateForwarder = new UpdateForwarder();

        initializeDataStore(getConfig().getString("storage"), true);

        getServer().getPluginManager().registerEvents(new EconomyListener(), this);
        getCommand("balance").setExecutor(new BalanceCommand());
        getCommand("baltop").setExecutor(new BalanceTopCommand());
        getCommand("economy").setExecutor(new EconomyCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("currency").setExecutor(new CurrencyCommand());
        getCommand("cheque").setExecutor(new ChequeCommand());
        getCommand("exchange").setExecutor(new ExchangeCommand());

        vaultHandler = new VaultHandler(this);
        vaultHandler.hook();
        UtilServer.consoleLog("Vault compatibility enabled.");

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", updateForwarder);

        if(isLogging()) {
            getEconomyLogger().save();
        }

        doAsync(() -> checkForUpdate());
    }

    @Override
    public void onDisable() {
        disabling = true;

        if(isVault()) getVaultHandler().unhook();
        if(isLogging()) EconomyLogger.closeLog();

        if (GemsEconomy.getDataStore() != null) {
            GemsEconomy.getDataStore().close();
        }
    }

}
