package atm;

import java.util.ArrayList;

public class User {
	private String id, password, name;
	private ArrayList<Account> accs;
	
	public User(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	public User() {
		
	}
	
	private String getUserId() {
		return this.id;
	}
	
	private String getPassword() {
		return this.password;
	}
	
	private String getName() {
		return this.name;
	}
	
}
