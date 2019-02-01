
public class Problem3 {

	public static void main(String[] args) {
		int[] list = { 14, 1, 22, 17, 36, 7, -43, 5 };
		int min = 4;
		int max = 17;
		countInRange(list, min, max);

	}

	public static int countInRange(int[] list, int min, int max) {
		int count = 0;

		for (int i = 0; i < list.length; i++) {
			if (list[i] >= min && list[i] <= max) {
				count++;

			}
		}

		return count;

	}

}
