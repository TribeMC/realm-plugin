package de.tribemc.realm.objects;

import org.bukkit.Location;

public class Home implements Comparable<Home> {

	private Location loc;
	private String name;

	public Home(String name, Location loc) {
		this.loc = loc;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Location getLoc() {
		return loc;
	}

	@Override
	public int compareTo(Home h) {

		return getName().compareTo(h.getName());
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Location) {
			return getLoc().getBlock().equals(((Location) arg0).getBlock());
		} else if (arg0 instanceof String) {
			return getName().equalsIgnoreCase((String) arg0);
		}
		return super.equals(arg0);
	}
}
