package day12;

public class FindQuareInteger {
	public static void main(String[] args) {

		int a = 1;
		int b = 25;
		int numberOfSquareInteger = findSquareInteger(a, b);
		System.out.println("the number of square integer in the range is : " + numberOfSquareInteger);
	}

	public static int findSquareInteger(int a, int b) {
		
		int numberOfSquareInteger = (int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
		return numberOfSquareInteger;
	}
}
