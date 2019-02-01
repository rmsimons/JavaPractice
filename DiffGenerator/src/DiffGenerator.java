//Robert Simons

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DiffGenerator {
	private String s1;
	private String s2;
	private String result;
	private Queue q1;
	private Queue q2;

	public DiffGenerator(String s1, String s2) {
		if (s1.isEmpty() || s2.isEmpty()) {
			throw new IllegalArgumentException("Not a valid String");
		}
		this.s1 = s1;
		this.s2 = s2;
	}

	public String diff(String str1, String str2) {
		if (str1.isEmpty() || str2.isEmpty()) {
			throw new IllegalArgumentException("Not a valid String");
		}
		String r = "";
		Stack<Character> debugStack = new Stack<>();
		// puts first string into first queue
		Queue<Character> q1 = new LinkedList<>();
		for (char c : str1.toCharArray()) {
			q1.offer(c);
		}
		this.q1 = q1;
		// puts second string into second queue
		Queue<Character> q2 = new LinkedList<>();
		for (char c : str2.toCharArray()) {
			q2.offer(c);
		}
		this.q2 = q2;

		while (!this.q2.isEmpty()) {
			if (this.q1.isEmpty()) {
				q2.remove();
				r = r + "+";
			} else {
				char temp1 = q1.peek();
				char temp2 = q2.peek();
				if (temp1 == temp2 && debugStack.isEmpty()) {
					this.q1.remove();
					this.q2.remove();
					r = r + "0";
				} else {
					if (temp1 == temp2) {
						while (!debugStack.isEmpty()) {
							debugStack.pop();
							r = r + "+";
						}
					} else {
						debugStack.push(temp2);
						this.q2.remove();
						this.q1.remove();
						r = r + "-";
					}
				}
			}
		}

		while (!debugStack.isEmpty()) {
			debugStack.pop();
			r = r + "+";
		}

		this.result = r;
		return "First String: " + s1 + '\n' + "Second String: " + s2 + '\n' + "Result: " + result;
	}
}
