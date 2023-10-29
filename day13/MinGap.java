package day13;

public class MinGap {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 1, 1, 4, 1 };
		int minGap = findMinGap(arr);

		System.out.println("Minimum gap is : " + minGap);

	}

	public static int findMinGap(int[] arr) {
		int minGap = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					minGap = Math.min(minGap, j - i);

				}
			}
		}

		if (minGap == Integer.MAX_VALUE) {
			return 0;
		}
		return minGap;
	}
}
// Time complexity O(n^2)
// Space complexity O1