package atm;

import java.util.ArrayList;

public class User {
	private String id, password, name;
	
	// new 객체가 아님 -> AccountManager.list 안에 있는 인스턴스
	private ArrayList<Account> accs;
	
	public User(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.accs = new ArrayList<Account>();
	}
	
	public User(String id, String password, String name, ArrayList<Account> accs) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.accs = accs;
	}
	
	public String getUserId() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAccountSize() {
		return this.accs.size();
	}
	
	public void addAccount(Account account) {
		this.accs.add(account);
	}
	
	public Account getAccount(int index) {
		return this.accs.get(index);
	}
	
	public ArrayList<Account> getAccountList(){
		return (ArrayList<Account>) this.accs.clone();
	}

	public void deleteAccount(Account account) {
		this.accs.remove(account);
	}
	
	private int indexOfAccById(String id) {
		int index = -1;
		for(Account acc : this.accs) {
			if(acc.getAccId().equals(id)) {
				index = this.accs.indexOf(acc);
			}
		}
		return index;
	}
	
	public void setAccount(Account account) {
		int index = indexOfAccById(account.getAccId());
		this.accs.set(index, account);
	}
	
	@Override
	public String toString() {
		return String.format("\nID : %s\nPW : %s\nNAME : %s", this.getUserId(), this.getPassword(), this.getName());
	}
	
}
