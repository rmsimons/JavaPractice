package week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StacksandQueues {

	public static void main(String[] args) {
		Queue<Integer> nums = new LinkedList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		int size = nums.size();
		for (int i = 0; i < size; i++) {
			nums.add(nums.peek());
			nums.add(nums.remove());
		}
		
		Queue<Character> chars = new LinkedList<>();
		chars.add('a');
		chars.add('b');
		chars.add('c');
		
		Stack<Character> mirror = new Stack<>();
		
		int length = chars.size();
		for (int i = 0; i < length; i++) {
			mirror.push(chars.peek());
			chars.add(chars.remove());
			
		}
		while (!mirror.isEmpty()) {
			chars.add(mirror.pop());
		}
		

	}

}
