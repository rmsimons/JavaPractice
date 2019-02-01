package week1;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(13);
		nums.add(6);
		nums.add(26);
		nums.add(0,5);
		
		nums.add(nums.remove(0));
		nums.set(1,  7);
		
		System.out.println(Arrays.toString(nums.toArray()));
		System.out.println("element at 0: " + nums.get(0));
		System.out.println("element at 1: " + nums.get(1));
		

	}

}
