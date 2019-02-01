import java.util.Arrays;

public class DividableArray {
	private int[] inputArray;
	private int divisionPoint;
	private int[] lowerArray;
	private int[] upperArray;

	public DividableArray(int[] theInputArray) {
		if (theInputArray == null || theInputArray.length < 2) {
			throw new IllegalArgumentException();
		}
		inputArray = theInputArray;
		divisionPoint = theInputArray.length / 2;
		divide();

	}

	public int[] getLowerArray() {
		return lowerArray;
	}

	public int[] getUpperArray() {
		return upperArray;
	}

	public String divide(int divisionPoint) {
		if (divisionPoint < 2 || divisionPoint > inputArray.length) {
			throw new IllegalArgumentException();

		}
		this.divisionPoint = divisionPoint;

		return toString();

	}

	private void divide() {
		lowerArray = Arrays.copyOfRange(inputArray, 0, divisionPoint);
		upperArray = Arrays.copyOfRange(inputArray, divisionPoint, inputArray.length);

	}

	public String toString() {
		return Arrays.toString(lowerArray) + ":" + Arrays.toString(upperArray);

	}

	public String setArray(int[] theInputArray) {
		if (theInputArray == null || theInputArray.length < 2) {
			throw new IllegalArgumentException();
		}

		this.inputArray = theInputArray;
		this.divisionPoint = inputArray.length / 2;
		lowerArray = Arrays.copyOfRange(inputArray, 0, divisionPoint);
		upperArray = Arrays.copyOfRange(inputArray, divisionPoint, inputArray.length);
		return toString();

	}

}
