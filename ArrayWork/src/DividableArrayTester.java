import java.util.Random;

public class DividableArrayTester {

	public static void main(String[] args) {

		// Test Case 1
		int[] tst1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		DividableArray tst_1 = new DividableArray(tst1);
		System.out.println(tst_1);

		// Test Case 2
		int[] tst2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		DividableArray tst_2 = new DividableArray(tst2);
		System.out.println(tst_2.setArray(tst2));

		// Test Case 3
		Random r = new Random();
		System.out.println(tst_1.divide(r.nextInt(10) + 2));

		// Test Case 4
		int[] tst4 = null;
		DividableArray tst_4 = new DividableArray(tst4);
		System.out.println(tst_4);

		// Test Case 5
		System.out.println(tst_1.divide(30));

	}

}
