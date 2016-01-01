package de.tribemc.realm.manager;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.World.Environment;

import de.tribemc.realm.main.Main;
import de.tribemc.realm.main.StadtGenerator;

public class StadtManager {

	World stadt;
	Main main;

	public StadtManager(Main m) {
		this.main = m;
		this.stadt = Bukkit.getWorld("Stadt");
		if (this.stadt == null) {
			this.stadt = Bukkit.createWorld(new WorldCreator("Stadt")
					.environment(Environment.NORMAL).generateStructures(false)
					.generator(new StadtGenerator()));
		}
	}

	public World getStadt() {
		return stadt;
	}

}
