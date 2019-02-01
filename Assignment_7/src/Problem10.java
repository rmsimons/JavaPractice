
public class Problem10 {

	public static void main(String[] args) {

		int[] list = { 6, 2, 9, 11, 3 };
		percentEven(list);

	}

	public static double percentEven(int[] list) {

		if (list.length == 0) {
			return 0.0;
		}

		double count = 0.0;

		for (int i = 0; i < list.length; i++) {
			if (list[i] % 2 == 0) {
				count++;

			}
		}

		return (count / list.length) * 100;

	}

}
