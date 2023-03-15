package atm;

public class Account {
	
	public static int LIMIT = 3;
	
	private String userId, accountNumber;
	private int money;
	
	
	public Account(String id) {
		this.userId = id;
	}
	
	public Account(String id, String accNum, int money) {
		this.userId = id;
		this.accountNumber = accNum;
		this.money = money;
	}
	
	public String getAccId() {
		return this.userId;
	}
	
	public String getAccNumber() {
		return this.accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int getMoney() {
		return this.money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
}
