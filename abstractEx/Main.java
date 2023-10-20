package abstractEx;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Database.initDB();

		System.out.println("input id");
		String id = scanner.nextLine();
		System.out.println("input password");
		String pass = scanner.nextLine();

		String membership = Emirates.dologin(id, pass);

		Emirates memberService = Emirates.getServiceBaseOnMembership(membership);
		int amount = 0;
		memberService.extraLugguage(id, amount);
		int percent = 0;
		memberService.bonusMiles(id, percent);

		scanner.close();
	}

}
