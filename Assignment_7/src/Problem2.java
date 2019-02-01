
public class Problem2 {

	public static void main(String[] args) {
		int[] list = { 36, 12, 25, 19, 46, 31, 22 };
		range(list);

	}

	public static int range(int[] list) {
		int max = list[0];
		int min = list[0];

		for (int i = 1; i < list.length; i++) {
			if (list[i] > max) {
				max = list[i];

			}
		}
		for (int i = 1; i < list.length; i++) {
			if (list[i] < min) {
				min = list[i];

			}
		}

		return max - min + 1;

	}

}
