
public class Problem4 {

	public static void main(String[] args) {
		double[] list1 = { 16.1, 12.3, 22.2, 14.4 };
		double[] list2 = { 1.5, 4.3, 7.0, 19.5, 25.1, 46.2 };

		isSorted(list1);
		isSorted(list2);

	}

	public static boolean isSorted(double[] list) {

		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] > list[i + 1]) {
				return false;

			}
		}
		return true;

	}

}
