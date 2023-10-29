package day13;

import java.util.Scanner;

public class TheFeast {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int c = scanner.nextInt();
			int m = scanner.nextInt();
			System.out.println(findTheFeast(n, c, m));
			scanner.close();
		}
	}

	public static int findTheFeast(int n, int c, int m) {
		// n = 6, c = 2, m = 2
		int chocolateBars = n / c; // 3
		int wrappers = chocolateBars; // 3

		while (wrappers >= m) { // 3 > 2 | 2 = 2
			int freeBars = wrappers / m; // 1 | 1
			chocolateBars += freeBars; // 3 + 1 = 4 | 4 + 1 = 5 ./.
			wrappers = freeBars + (wrappers % m); // 1 + 1 = 2 loop tiep
		}
		return chocolateBars;
	}
}
