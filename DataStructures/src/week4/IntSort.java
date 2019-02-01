package week4;

import java.util.Arrays;

public class IntSort {

	public static void main(String[] args) {
		int[] arr = {5, 3, 1, 4, 2};
		System.out.print(Arrays.toString(arr));
	}

	public int[] merge(int[] nums) {

		if (nums.length <= 1)
			return nums;
		int i = 0;
		int[] front = new int[nums.length / 2];
		while (i < front.length) {
			front[i] = nums[i];
			i++;
		}
		int[] back = new int[nums.length - front.length];
		while (i < nums.length) {
			back[i - front.length] = nums[i];
			i++;
		}
		front = merge(front);
		back = merge(back);

		int frontNdx = 0;
		int backNdx = 0;
		int ndx = 0;
		int[] combined = new int[front.length + back.length];
		while (frontNdx < front.length && backNdx < back.length) {
			if (front[frontNdx] < back[backNdx]) {
				combined[ndx] = front[frontNdx];
				frontNdx++;
			} else {
				combined[ndx] = back[backNdx];
				backNdx++;
			}
			ndx++;
		}
		if (frontNdx < front.length) {
			while (frontNdx < front.length) {
				combined[ndx] = num;
				ndx++;
			}
		} else {
			while (backNdx < back.length) {
				combined[ndx] = num;
				ndx++;
			}
		}
		return combined;

	}
}