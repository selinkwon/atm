package atm;

import java.util.ArrayList;

public class AccountManager {
	
	private static ArrayList<Account> list = new ArrayList<Account>();
	
	// Account 메 대한
	
	// C reate
	public void createAccount(Account account) {
		this.list.add(account);
	}
	
	// R ead
	public Account getAccount(int index) {
		Account account = list.get(index);
		Account reqObj = new Account();
		return reqObj;
	}
	
	public ArrayList getList(ArrayList list) {
		ArrayList userlist = list;
		ArrayList reqObj = new ArrayList<>();
		return reqObj;
	}
	
	// U pdate
	public void setAccount(int index, Account account) {
		list.set(index, account);
	}
	
	// D elete
	public void deleteAccount(int index) {
		list.remove(index);
	}
}