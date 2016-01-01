package de.tribemc.realm.objects;

public enum GSMemberType {
	OWNER(1), MODERATOR(2), MEMBER(3), BANNED(4);
	private int rank;

	GSMemberType(int i) {
		rank = i;
	}

	public int getRank() {
		return rank;
	}

	public boolean canInteract(GSMemberType type) {
		return canInteract(type.getRank());
	}

	private boolean canInteract(int rank) {
		return getRank() > rank;
	}
}
