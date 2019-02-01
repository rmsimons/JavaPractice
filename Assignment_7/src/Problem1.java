
public class Problem1 {

	public static void main(String[] args) {
		int[] numberList = { 74, 85, 102, 99, 101, 85, 56 };
		int value = 85;
		lastIndexOf(numberList, value);

	}

	public static int lastIndexOf(int[] list, int value) {

		int lastIndex = -1;

		for (int i = 0; i < list.length; i++) {
			if (list[i] == value) {
				lastIndex = i;

			}

		}

		return lastIndex;

	}

}
