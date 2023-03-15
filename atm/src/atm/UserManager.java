package atm;

import java.util.ArrayList;

public class UserManager {

	private static ArrayList<User> list = new ArrayList<User>();
	
	// User 메 대한
	
	// C reate
	public User addUser(User user) {
		// 검증 후 add
		User check = getUserById(user.getUserId());
		if(check == null) {    // 이 아이디를 가지고 있는 id가 없으면 null반환
			list.add(user);
			return user;			
		}
		return null;
	}
	
	// R ead
	public User getUser(int index) {
		User user = this.list.get(index);
		
		// 사본 제공
		User reqObj = new User(user.getUserId(),user.getPassword(),user.getName(),user.getAccountList());
		return reqObj;
	}
	
	public User getUserById(String id) {
		User user = null;  // 이 아이디를 가지고 있는 id가 없으면 null반환
		
		int index = indexOfById(id);
		if(index != -1)
			user = getUser(index);
		
//		2)방법
//		for(User i : list) {
//			if(i.getUserId().equals(id))
//				user = i;
//		}
		
		return user;
	}
	
	public int indexOfById(String id) {
		int index = -1;
		for(User user : list) {
			if(user.getUserId().equals(id)) {
				index = list.indexOf(user);
			}
		}
		return index;
	}
	
	// U pdate
	public void setUser(int index, User user) {
		list.set(index, user);
	}
	
	public void setUser(User user, Account account) {
		int index = indexOfById(user.getUserId());		
		list.get(index).addAccount(account);
	}
	
	public void setUserAccountById(String id, Account account) {
		int index = indexOfById(id);
		list.get(index).setAccount(account);
	}
	
	// D elete
	public void deleteUser(int index) {
		list.remove(index);
	}
	
	public void deleteUserById(String id) {
		int index = indexOfById(id);
		User target = list.get(index);
		list.remove(target);
	}	
	
	public void deleteAccById(String id) {
		int index = indexOfById(id);
		
	}
	
	public void deleteAcc(User user, Account account) {
		int index = indexOfById(user.getUserId());
		list.get(index).deleteAccount(account);		
	}
	
	public int userListSize() {
		return list.size();
	}
}
