
public class Problem6 {

	public static void main(String[] args) {
		int[] list = { 1, -2, 4, -4, 9, -6, 16, -8, 25, -10 };
		stdev(list);

	}

	public static double stdev(int[] list) {
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i];

		}
		double avg = sum / list.length;

		int equationSum = 0;
		for (int i = 0; i < list.length; i++) {
			equationSum += Math.pow((list[i] - avg), 2);

		}
		double stdev = equationSum / (list.length - 1);

		return Math.sqrt(stdev);

	}

}
