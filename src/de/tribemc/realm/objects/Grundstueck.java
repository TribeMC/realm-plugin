package de.tribemc.realm.objects;

import java.util.LinkedList;
import java.util.List;

public class Grundstueck {

	List<GSMember> members;

	public List<GSMember> getMembers() {
		return members;
	}

	public GSMember getOwner() {
		for (GSMember m : getMembers())
			if (m.getType() == GSMemberType.OWNER)
				return m;
		return null;
	}

	public List<GSMember> getBannedMembers() {
		LinkedList<GSMember> temp = new LinkedList<>();
		for (GSMember m : getMembers())
			if (m.getType() == GSMemberType.BANNED)
				temp.add(m);
		return temp;
	}
}
