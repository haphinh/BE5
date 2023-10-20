package abstractEx;

public abstract class Emirates {

	public abstract boolean login(String id, String password);

	public abstract int extraLugguage(String id, int amount);

	public abstract int bonusMiles(String id, int percent);

	public void welcomeMessage() {

		System.out.println("Welcome to Emirates!");
	}

	public static Emirates getServiceBaseOnMembership(String membership) {

		switch (membership) {
		
		case "Silver":

			return new SilverMembership();

		case "Gold":

			return new GoldMembership();

		default:
			break;
		}
		return null;

	}

	public static String dologin(String id, String password) {

		for (int i = 0; i < Database.MEMBER_DB.size(); i++) {

			if (Database.MEMBER_DB.get(i).getId().equals(id)

					&& Database.MEMBER_DB.get(i).getPassword().equals(password)) {

				System.out.print("Login successfully! Welcome " + Database.MEMBER_DB.get(i).getName() + "!");
				System.out.print("You are " + Database.MEMBER_DB.get(i).getTier() + "Membership");
				System.out.println();

				return Database.MEMBER_DB.get(i).getTier();

			}
		}
		return null;

	}

}
