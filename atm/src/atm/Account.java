package atm;

public class Account {
	private String id, accountNumber;
	private int money;
	
	public static int LIMIT = 3;
	
	public Account(String id, String accountNumber, int money) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.money = money;
	}
	
	public String getAccId() {
		return this.id;
	}
	
	public String getAccNumber() {
		return this.accountNumber;
	}
	
	public int getMoney() {
		return this.money;
	}
}
