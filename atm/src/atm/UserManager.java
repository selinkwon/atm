package atm;

import java.util.ArrayList;

public class UserManager {

	private static ArrayList<User> list = new ArrayList<User>();
	
	// User 메 대한
	
	// C reate
	public void addUser(User user) {
		this.list.add(user);
	}
	
	// R ead
	public User getUser(int index) {
		User user = this.list.get(index);
		
		// 사본 제공
		User reqObj = new User();
		return reqObj;
	}
	
	public User getUserById(String id) {
		int index = -1; 
		return getUser(index);
	}
	
	// U pdate
	public void setUser(int index, User user) {
		this.list.set(index, user);
	}
	
	// D elete
	public void deleteUser(int index) {
		this.list.remove(index);
	}
	
	public void deleteUserById(String id) {
		
	}	
}
