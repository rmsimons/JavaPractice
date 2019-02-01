
public class Problem15 {

	public static void main(String[] args) {
		int[] list1 = { 7, 2, 8, 9, 4, 13, 7, 1, 9, 10 };
		int[] list2 = { 1, 2, 3, 4, 5 };

		collapse(list1);
		collapse(list2);

	}

	public static int[] collapse(int[] list) {

		int[] collapse = new int[list.length / 2 + list.length % 2];
		for (int i = 0, j = 0; i < list.length - 1; i += 2, j++) {
			collapse[j] = list[i] + list[i + 1];

		}
		if (list.length % 2 == 1) {
			collapse[collapse.length - 1] = list[list.length - 1];

		}
		return collapse;

	}

}
