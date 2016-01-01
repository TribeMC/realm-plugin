package de.tribemc.realm.objects;

import java.util.List;

import org.bukkit.util.Vector;

import de.tribemc.tribeessentials.objects.server.Spieler;

public class RealmData {

	List<Home> homes;
	Vector farm;

	public RealmData(Spieler sp) {

	}

	public List<Home> getHomes() {
		return homes;
	}

	public Home getHome(Object o) {
		for (Home h : getHomes())
			if (h.equals(o))
				return h;
		return null;
	}

	public boolean deleteHome(Home h) {
		return this.homes.remove(h);
	}

	public boolean addHome(Home h) {
		return this.homes.add(h);
	}

	public Vector getFarm() {
		return farm;
	}

	public void setFarm(Vector farm) {
		this.farm = farm;
	}
}
