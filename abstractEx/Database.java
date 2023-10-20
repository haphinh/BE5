package abstractEx;

import java.util.ArrayList;

public class Database {

	public static ArrayList<Member> MEMBER_DB = new ArrayList<>();

	public static void initDB() {

		MEMBER_DB.add(new Member("abc", "123", "A", "Silver", 1, 20));
		MEMBER_DB.add(new Member("xyz", "456", "B", "Gold", 2, 50));

	}

}
