package de.tribemc.realm.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	static Main instance;

	public static Main getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;

		super.onEnable();
	}
}
