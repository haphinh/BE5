package abstractEx;

public class GoldMembership extends Emirates {

	@Override
	public boolean login(String id, String password) {
		System.out.println("Silver id : " + id);
		System.out.println("Silver password : " + password);
		return true;
	}

	@Override
	public int extraLugguage(String id, int amount) {

		for (int i = 0; i < Database.MEMBER_DB.size(); i++) {

			if (Database.MEMBER_DB.get(i).getId().equals(id)) {

				System.out.println("You have " + Database.MEMBER_DB.get(i).getAmount() + " extra luggage");

				return Database.MEMBER_DB.get(i).getAmount();
			}

		}
		return amount;
	}

	@Override
	public int bonusMiles(String id, int amount) {

		for (int i = 0; i < Database.MEMBER_DB.size(); i++) {

			if (Database.MEMBER_DB.get(i).getId().equals(id)) {

				System.out.println("You have " + Database.MEMBER_DB.get(i).getPercent() + " % bonus miles");

				return Database.MEMBER_DB.get(i).getPercent();
			}

		}
		return amount;
	}
}
