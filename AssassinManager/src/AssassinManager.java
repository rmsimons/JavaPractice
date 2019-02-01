// Robert Simons
//This program executes a game called Assassin
import java.util.List;

public class AssassinManager {
	private AssassinNode killRing;
	private AssassinNode graveyard;

	// Initializes a new Assassin Manager over a list of people
	// and builds a kill ring of nodes in the same order
	public AssassinManager(List<String> names) {
		if (names.size() == 0 || names == null) {
			throw new IllegalArgumentException("Not a valid list of names");
		}
		this.killRing = null;
		this.graveyard = null;
		for (int n = names.size() - 1; n >= 0; n--) {
			this.killRing = new AssassinNode(names.get(n), this.killRing);
		}
	}

	
	// Prints the names of the people in the kill ring in the order
	// they are stalking each other
	public void printKillRing() {
		AssassinNode itr = this.killRing;
		if (itr.next == null) {
			System.out.println(this.killRing + "won the game!");
		}
		while (itr.next != null) {
			System.out.println("    " + itr.name + " is stalking " + itr.next.name);
			itr = itr.next;
		}
		System.out.println("    " + itr.name + " is stalking " + this.killRing.name);
	}

	
	// Prints the names of the people in the graveyard
	public void printGraveyard() {
		AssassinNode itr = this.graveyard;
		if (itr == null) {
			System.out.println("");
		}

		while (itr != null) {
			System.out.println("    " + itr.name + " was killed by " + itr.killer);
			itr = itr.next;
		}
	}

	// returns true if the kill ring contains the requested person
	public boolean killRingContains(String name) {
		return checkList(name, this.killRing);
	}

	// returns true if the graveyard contains the requested person
	public boolean graveyardContains(String name) {
		return checkList(name, this.graveyard);
	}

	// Algorithm for computing if the specified list contains the
	// requested person
	private boolean checkList(String name, AssassinNode contains) {
		boolean flag = false;
		AssassinNode itr = contains;
		while (itr != null) {
			if (itr.name.equalsIgnoreCase(name)) {
				flag = true;
				itr = itr.next;
			} else {
				itr = itr.next;
			}
		}
		return flag;
	}

	// returns true if the game is over
	public boolean isGameOver() {
		return this.killRing.next == null;
	}

	// returns the name of the winner
	public String winner() {
		if (isGameOver()) {
			return this.killRing.name;
		}
		return null;
	}

	// kills the specified person, removing the name from the kill ring and
	// adding it to the graveyard
	public void kill(String name) {
		if (isGameOver()) {
			throw new IllegalStateException("Cannot kill " + name + "because the game is over");
		}
		if (!checkList(name, this.killRing)) {
			throw new IllegalArgumentException(name + " is not in the Kill Ring");
		}
		AssassinNode itr = this.killRing;

		// Checks to see if the given name to kill is the first in the list
		if (itr.name.equalsIgnoreCase(name)) {
			graveyard = new AssassinNode(itr.name, graveyard);
			// goes to the last name in the list because that is who killed
			// first name
			while (itr.next != null) {
				itr = itr.next;
			}
			graveyard.killer = itr.name;
			this.killRing = this.killRing.next;
		}
		// determines the person to kill and the corresponding killer
		else {
			while (itr.next != null) {
				if (itr.next.name.equalsIgnoreCase(name)) {
					graveyard = new AssassinNode(itr.next.name, graveyard);
					graveyard.killer = itr.name;
					
					//have to determine where you are in the list so itr.next.next exists
					if (itr.next.next != null) {
						itr.next = itr.next.next;
					} else {
						itr.next = null;
					}
				} else
					itr = itr.next;
			}
		}
	}

	//////// DO NOT MODIFY AssassinNode. You will lose points if you do.
	//////// ////////
	/**
	 * Each AssassinNode object represents a single node in a linked list for a
	 * game of Assassin.
	 */
	private static class AssassinNode {
		public final String name; // this person's name
		public String killer; // name of who killed this person (null if alive)
		public AssassinNode next; // next node in the list (null if none)

		/**
		 * Constructs a new node to store the given name and no next node.
		 */
		public AssassinNode(String name) {
			this(name, null);
		}

		/**
		 * Constructs a new node to store the given name and a reference to the
		 * given next node.
		 */
		public AssassinNode(String name, AssassinNode next) {
			this.name = name;
			this.killer = null;
			this.next = next;
		}
	}
}
