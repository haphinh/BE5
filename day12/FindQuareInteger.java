package day12;

public class FindQuareInteger {
	public static void main(String[] args) {

		int a = 1;
		int b = 100;
		int numberOfSquareInteger = countSquaresInteger(a, b);
		System.out.println("the number of square integer in the range is : " + numberOfSquareInteger);
	}

	public static int countSquaresInteger(int a, int b) {

		int count = 0;
		int num = 1;

		while (num * num < a) {
			num++;
		}

		while (a <= num * num && num * num <= b) {
			count++;
			num++;
		}
		return count;
	}
}
