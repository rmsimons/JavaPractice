package week4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import AssassinManager.AssassinNode;

public class practice {

	public static void main(String[] args) {
		
		
		List<Integer> list1 = new LinkedList<>();
		
		list1.add(10);
		list1.add(11);
		list1.add(12);
		list1.add(13);
		list1.add(14);
		list1.add(15);
		
		System.out.println("old list:" + list1);
		
		
		List<Integer> list2 = new LinkedList<>(list1);
		
		System.out.println("new list" + list2);
		
		int n = list2.get(0);
		
		System.out.println(n);
		
		List<Integer> list3 = new LinkedList<>();
		list3.add(n);
		System.out.println(list3);
	
	
	int i = 0;
	  while (i++ < 10) {
	    if (i == 5) break;
	  }
	  System.out.println(i); //prints 5
	}

}


//++++++++++++++++++++  AssassinManager ++++++++++++++++++++++++++


public void kill(String name) {
	if (isGameOver()) {
		throw new IllegalStateException("Cannot kill " + name + "because the game is over");
	}
	if (!checkList(name, this.killRing)) {
		throw new IllegalArgumentException(name + " is not in the Kill Ring");
	}
	AssassinNode itr = this.killRing;
	AssassinNode graveyardTemp = this.graveyard;

	// Checks to see if the given name to kill is the first in the list
	if (itr.name.equalsIgnoreCase(name)) {
		this.graveyard = this.killRing;
		this.graveyard.next = graveyardTemp;
		this.killRing = this.killRing.next;
	}
	

	// Checks to see if the given name to kill is the first in the list
	if (itr.name.equalsIgnoreCase(name)) {
		this.graveyard = new AssassinNode(this.killRing.name, this.graveyard.next);
		this.killRing = this.killRing.next;
	}

	// determines the person to kill and the corresponding killer
	while (itr.next != null) {
		if (itr.next.name.equalsIgnoreCase(name)) {
			this.graveyard = itr.next;
			this.graveyard.next = graveyardTemp;
			itr.next = itr.next.next;
			graveyard.killer = itr.name;
		}
		itr = itr.next;
	}
	if (graveyard.killer.equals(null)) {
		graveyard.killer = itr.name;
	}

}

