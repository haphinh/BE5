package dsa;

public class Sort {

	public static void main(String[] args) {

		int arr[] = { 1, 1, 0, 1, 2, 2, 0, 0, 0, 1, 2 };
		int length = arr.length;
		sortArr(arr, length);
		printArr(arr, length);

	}

	public static void sortArr(int arr[], int length) {
		int i, count0 = 0, count1 = 0, count2 = 0;

		for (i = 0; i < length; i++) {

			switch (arr[i]) {
			case 0:
				count0++;
				break;
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			}
		}

		i = 0;

		while (count0 > 0) {
			arr[i++] = 0;
			count0--;
		}

		while (count1 > 0) {
			arr[i++] = 1;
			count1--;
		}

		while (count2 > 0) {
			arr[i++] = 2;
			count2--;
		}
	}

	public static void printArr(int arr[], int length) {

		for (int i = 0; i < length; i++)
			System.out.print(arr[i] + " ");
	}
}
// Time complexity 0(n)