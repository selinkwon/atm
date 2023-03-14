package atm;

import java.util.Scanner;

public class Bank {

	private UserManager um;
	private AccountManager am;
	private Scanner scan;
	
	public Bank(String name) {
		System.out.println(name);
		this.scan = new Scanner(System.in);
	}
	
	public void printMenu() {
		
	}
	
	public int input() {
		int number = scan.nextInt();
		return number;
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
