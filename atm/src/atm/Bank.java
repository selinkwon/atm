package atm;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	private UserManager um;
	private AccountManager am;
	private Scanner scan;
	private int count;
	
	public Bank(String name) {
		System.out.println(name);
		this.scan = new Scanner(System.in);
		this.um = new UserManager();
		this.am = new AccountManager();
	}
	
	public void printMenu() {
		System.out.println("1. 회원가입");
		System.out.println("2. 회원탈퇴");
		System.out.println("3. 계좌생성");
		System.out.println("4. 계좌해지");
		System.out.println("5. 로그인");
	}
	
	public int input() {
		System.out.print("메뉴 입력 : ");
		int number = this.scan.nextInt();
		return number;
	}
	
	private void join() {
		System.out.print("가입할 ID : ");
		String id = this.scan.next();
		
		if(!checkDupl(id)) {
			System.out.println("이름 : ");
			String name = this.scan.next();
			System.out.print("PW : ");
			String pw = this.scan.next();
			
			User user = new User(id,pw,name);
			this.um.addUser(user);
			this.count ++;
			System.out.println("가입 완료!");
		}
		else {
			System.err.println("이미 등록된 ID입니다.");
		}
	}
	
	private boolean checkDupl(String id) {
		boolean result = true;
		User user = this.um.getUserById(id);
		
		if(user == null) 
			result = false;
		
		return result;
	}
	
	private void leave(String id) {
		this.um.deleteUserById(id);
	}
	
	private void addAcc() {
		
	}
	
	private void deleteAcc() {
		
	}
	
	private void logIn() {
		
	}
	
	// Banking 관련 메소드
	public void run() {
		while(true) {
			printMenu();
			int select = input();
			if(select == 1)join();
			else if(select == 2)leave();
			else if(select == 3)addAcc();
			else if(select == 4)deleteAcc();
			else if(select == 5)logIn();
			
			
		}
	}
}
