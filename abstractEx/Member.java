package abstractEx;

public class Member {

	private String id;
	private String password;
	private String name;
	private String tier;
	private int amount;
	private int percent;

	public Member() {

	}

	public Member(String id, String password, String name, String tier, int amount, int percent) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.tier = tier;
		this.amount = amount;
		this.percent = percent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

}
