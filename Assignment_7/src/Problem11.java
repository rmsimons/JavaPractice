
public class Problem11 {

	public static void main(String[] args) {
		int[] list1 = { 3, 8, 12, 2, 9, 17, 43, -8, 46 };
		int[] list2 = { 4, 7, 3, 9, 12, -47, 3, 74 };
		isUnique(list1);
		isUnique(list2);

	}

	public static boolean isUnique(int[] list) {

		for (int i = 0; i < list.length - 1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				if ((list[i] == (list[j])) && (i != j)) {
					return false;

				}

			}

		}
		return true;
	}

}
