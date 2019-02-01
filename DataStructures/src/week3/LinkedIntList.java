package week3;

public class LinkedIntList {
	private ListNode front;

	public LinkedIntList() {
		// TODO
	}

	public void add(int data) {
		if (front == null) {
			front = new ListNode(data, null);
		} else {
			ListNode current = front;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(data, null);
		}
	}

	public void add(int index, int data) {
		if (index == 0) {
			front = new ListNode(data, front);
		} else if (index < size()) {
			ListNode current = goToListNode(index - 1);
			current.next = new ListNode(data, current.next);
		} else if (index == size()) {
			add(data);
		} else {
			throw new IndexOutOfBoundsException("You done goofed");
		}
	}
	
	public int remove(int index) {
		int result = goToListNode(index).data;
		goToListNode(index - 1).next = goToListNode(index).next;
		return result;
	}
	
	public void clear() {
		front = null;
	}
	
	public int get(int index) {
		return goToListNode(index).data;
	}
	
	public int set(int index, int data) {
		int result = goToListNode(index).data;
		goToListNode(index).data = data;
		return result;
	}

	public int size() {
		int size = 0;
		ListNode current = front;
		while (current.next != null) {
			current = current.next;
			size++;
		}
		return size;
	}

	private ListNode goToListNode(int index) {
		if (index >= size() || index < 0) {
			throw new IndexOutOfBoundsException("moron");
		}
		ListNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	// Utility inner class that only LinkedList can see
	private class ListNode {
		public int data;
		public ListNode next;

		public ListNode(int data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
}
