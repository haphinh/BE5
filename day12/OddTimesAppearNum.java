package day12;

public class OddTimesAppearNum {
	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 1, 1, 2, 3, 2 };

		int[] resultArr = new int[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			int valueOfIndexI = arr[i];
			resultArr[valueOfIndexI] = resultArr[valueOfIndexI] + 1;
		}

		for (int i = 0; i < resultArr.length; i++) {
			if (resultArr[i] % 2 == 1) {
				System.out.println("The odd appearing number is : " + i);

			}
		}

	}

}
