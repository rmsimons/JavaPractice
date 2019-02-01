//This program expands a specified array by a specified element amount
import java.util.Arrays;

public class ExpandArray {

	public static void main(String[] args) {
		int[] regularArray = { 1, 2, 3, 4, 5 };

		int[] newArray = expandArray(regularArray, 10);

		System.out.println(Arrays.toString(newArray));

	}

	//Copies the old array to a new array with the increased element amount
	//pre: list != null && n > 0
	//post: newArray has regularArray inside it with added elements
	public static int[] expandArray(int[] list, int n) {

		if (list == null || n <= 0) {
			throw new IllegalArgumentException();
		}
		int[] expandedArray = new int[list.length + n];
		System.arraycopy(list, 0, expandedArray, 0, list.length);
		list = expandedArray;
		return list;

	}

}
