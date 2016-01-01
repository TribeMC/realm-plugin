package de.tribemc.realm.manager;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import de.tribemc.realm.main.Main;

public class FarmManager {

	private World farm;
	private Main main;
	private Vector loc;

	public FarmManager(Main m) {
		this.main = m;
		this.farm = Bukkit.getWorld("Farm");
		if (this.farm == null) {
			this.farm = Bukkit.createWorld(new WorldCreator("Farm")
					.environment(Environment.NORMAL).generateStructures(false));
		}
		this.loc = m.getConfig().getVector("Farm.Spawn");
		if (this.loc == null)
			this.loc = this.farm.getSpawnLocation().toVector();
	}

	public Main getMain() {
		return main;
	}

	public Vector getCurrentSpawn() {
		return this.loc;
	}

	public Vector getNextSpawn() {
		return updateLocation();
	}

	private Vector updateLocation() {
		if (this.loc.getBlockX() < this.loc.getBlockZ()) {
			if (-1 * this.loc.getBlockX() < this.loc.getBlockZ()) {
				this.loc.setX(this.loc.getBlockX() + 1024);
			} else {
				this.loc.setZ(this.loc.getBlockZ() + 1024);
			}
		} else if (this.loc.getBlockX() > this.loc.getBlockZ()) {
			if (-1 * this.loc.getBlockX() >= this.loc.getBlockZ()) {
				this.loc.setX(this.loc.getBlockX() - 1024);
			} else {
				this.loc.setZ(this.loc.getBlockZ() - 1024);
			}
		} else if (this.loc.getBlockX() <= 0) {
			this.loc.setZ(this.loc.getBlockZ() + 1024);
		} else {
			this.loc.setZ(this.loc.getBlockZ() - 1024);
		}
		this.loc.setY(this.farm.getHighestBlockAt(this.loc.getBlockX(),
				this.loc.getBlockZ()).getY() + 1);
		loadChunks(getCurrentSpawn());
		return this.loc.clone();
	}

	private void loadChunks(Vector loc) {
		Chunk c = this.farm.getChunkAt(loc.getBlockX(), loc.getBlockZ());
		c.load();
	}

	public World getFarm() {
		return farm;
	}

	public void unloadUnused() {
		Chunk[] cc = this.farm.getLoadedChunks();
		List<Player> player = this.farm.getPlayers();
		for (Chunk c : cc) {
			boolean needed = false;
			for (Player p : player) {
				if (p.getLocation().getChunk().equals(c))
					needed = true;
			}
			if (!needed)
				c.unload();
		}
	}
}
