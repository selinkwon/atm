package atm;

public class Account {
	
	public static int LIMIT = 3;
	
	private String userId, accountNumber;
	private int money;
	
	
	public Account(String id, String accountNumber, int money) {
		this.userId = id;
		this.accountNumber = accountNumber;
		this.money = money;
	}
	
	public Account() {
		
	}
	
	public String getAccId() {
		return this.userId;
	}
	
	public String getAccNumber() {
		return this.accountNumber;
	}
	
	public int getMoney() {
		return this.money;
	}
}
