package atm;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	private Scanner scan;
	
	private String brandName;
	
	private UserManager um;
	private AccountManager am;
	
	private int count;
	private int log;
	
	public Bank(String brandName) {
		this.brandName = brandName;
		this.scan = new Scanner(System.in);
		this.um = new UserManager();
		this.am = new AccountManager();
		this.log = -1;
	}
	
	private void printMainMenu() {
		System.out.println("===="+this.brandName+"====");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원탈퇴");
		System.out.println("3. 계좌신청");
		System.out.println("4. 계좌철회");
		System.out.println("5. 로그인");
		System.out.println("0. 종료");
	}
	
	public int input() {
		int number = -1;
		System.out.print("메뉴 입력 : ");
		String input = this.scan.next();
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
//		if(this.um.addUser(user) != null){
			this.um.addUser(user);
			this.count ++;
			System.out.println("가입 완료!");
//		}
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
	
	private void leave() {
		System.out.print("삭제할 ID : ");
		String id = this.scan.next();
		System.out.printf("%s의 PW : ",id);
		String password = this.scan.next();
		if(checkDupl(id)) {
			for(int i=0;i<count;i++) {
				if(password.equals(this.um.getUser(i).getPassword())&&id.equals(this.um.getUser(i).getUserId())) {
					this.um.deleteUserById(id);	
					this.count --;
					System.out.println("탈퇴완료!");
				}
			}
			System.out.println("회원정보를 확인해주세요.");
		}
		else {
			System.out.println("등록된 ID가 없습니다.");
		}
	}
	
	private void createAccount() {
		if(isLogedIn()) {
			// 복제본 반환 받음
			User user = this.um.getUserById(id);
			
			if(user != null) {
				if(user.getPassword().equals(password)) {
					if(user.getAccountSize() < Account.LIMIT) {
						Account account = this.am.createAccount(new Account(id));
						this.um.setUser(user, account);						
					}
				}
				else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}
			else {
				System.out.println("회원정보를 확인하세요");
			}			
		}
		else {
			System.out.println("로그인 후 이용해주세요.");
		}
	}
	
	private void deleteAccount() {
		if (isLogedIn()) {
			
		} else {
			System.out.println("로그인 후 이용해주세요.");
		}
	}
	
	private void logIn() {
		System.out.print("로그인할 ID : ");
		String id = this.scan.next();		
		if(checkDupl(id)) {
			System.out.print("PW : ");
			String password = this.scan.next(); 
			
			if(this.um.getUserById(id).getPassword().equals(password)) {
				System.out.println("로그인 되었습니다.");
				this.log = this.um.indexOfById(id);
			}
			else {
				System.out.println("회원정보가 일치하지 않습니다.");
			}
		}
		else {
			System.out.println("등록되지 않은 ID입니다.");
		}
		if(this.log != -1) {
			System.out.println(this.um.getUserById(id).getName()+"님 환영합니다.");
			subMenuRun();
		}
	}
	
	private boolean isLogedIn() {
		boolean result = false;		
		if(log != -1) {
			result = true;
		}
		return result;
	}
	
	
	private void printSubMenu() {
		System.out.println("===="+this.brandName+"====");
		System.out.println("1. 입금");
		System.out.println("2. 출금");
		System.out.println("3. 조회");
		System.out.println("4. 이체");
		System.out.println("5. 계좌생성");
		System.out.println("6. 계좌철회");
		System.out.println("0. 로그아웃");
	}

	private void logOut() {
		this.log = -1;
		System.out.println("로그아웃 되었습니다.");
	}
	
	private void moveMoney() {
		// TODO Auto-generated method stub
		
	}
	
	private void info() {
		// TODO Auto-generated method stub
		
	}
	
	private void outMoney() {
		// TODO Auto-generated method stub
		
	}
	
	private void addMoney() {
		// TODO Auto-generated method stub
		
	}
	
	public void subMenuRun() {
		while(isLogedIn()) {
			printSubMenu();
			int sel = input();
			if(sel == 1)addMoney();
			else if(sel == 2)outMoney();
			else if(sel == 3)info();
			else if(sel == 4)moveMoney();
			else if(sel == 5)createAccount();
			else if(sel == 6)deleteAccount();
			else if(sel == 0)logOut();
			
		}
	}
	

	// Banking 관련 메소드
	public void run() {
		while(true) {
			printMainMenu();
			int select = input();
			if(select == 1)join();
			else if(select == 2)leave();
			else if(select == 3)createAccount();
			else if(select == 4)deleteAccount();
			else if(select == 5)logIn();			
			else if(select == 0)break;			
		}
		System.out.println("시스템이 종료되었습니다.");
	}
}
