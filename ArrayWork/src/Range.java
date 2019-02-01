//This program computes the range of digits in an integer
public class Range {

	public static void main(String[] args) {
		digitRange(0);
		digitRange(26);
		digitRange(42);
		digitRange(888);
		digitRange(1234);
		digitRange(24680);
		digitRange(857492);

	}

	//Converts the number of type int to type String to
	//pass through an array and separate the digits
	public static void digitRange(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}

		String n_AsString = Integer.toString(n);
		int[] n_Array = new int[n_AsString.length()];
		for (int i = 0; i < n_AsString.length(); i++) {
			n_Array[i] = n_AsString.charAt(i) - '0';

		}
		int r = rangeCalc(n_Array);
		System.out.println("digitRange(" + n + ") :" + r);

	}

	//Looks at each element(digit) in the array and determines 
	//the range
	public static int rangeCalc(int[] list) {
		if (list.length == 1) {
			return 0;
		} else {

			int max = list[0];
			int min = list[0];
			for (int i : list) {
				if (i > max) {
					max = i;

				} else if (i < min) {
					min = i;
				}
			}

			return max - min;

		}

	}

}
