//Robert Simons


import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class HuffmanCode {
	private HuffmanNode tree;

	public HuffmanCode(int[] frequencies) {

		PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
		for (int i = 0; i < frequencies.length; i++) {
			if (frequencies[i] != 0) {
				pq.add(new HuffmanNode((char) i, frequencies[i]));

			}
		}

		while (pq.size() > 1) {
			HuffmanNode n1 = pq.remove();
			HuffmanNode n2 = pq.remove();
			HuffmanNode parent = new HuffmanNode((char) 0, n1.frequency + n2.frequency);
			parent.left = n1;
			parent.right = n2;
			pq.add(parent);
		}
		this.tree = pq.remove();
	}

	public HuffmanCode(Scanner input) {

	}

	public void translate(BitInputStream input, PrintStream output) {
		HuffmanNode current = tree;
		while (input.hasNextBit()) {
			int temp = input.nextBit();
			
		}
	}

	public void save(PrintStream output) {
		Stack<HuffmanNode> stack = new Stack<>();
		HuffmanNode current = tree;
		stack.push(current);
		while (!stack.isEmpty()) {
			if (current.left != null) {
				stack.push(current.left);
				current = current.left;
			} else if (current.right != null) {
				stack.push(current.right);
				current = current.right;
			}
		}
	}

	private static class HuffmanNode implements Comparable<HuffmanNode> {
		public final char value;
		public final int frequency;
		public HuffmanNode right;
		public HuffmanNode left;

		public HuffmanNode(char value, int frequency) {
			this.value = value;
			this.frequency = frequency;
			this.left = null;
			this.right = null;
		}

		public int compareTo(HuffmanNode other) {
			return this.frequency - other.frequency;
		}
	}
}
