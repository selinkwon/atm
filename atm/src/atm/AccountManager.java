package atm;

import java.util.ArrayList;
import java.util.Random;

public class AccountManager {
	
	private static ArrayList<Account> list = new ArrayList<Account>();
	
	// Account 메 대한
	
	// C reate
	public Account createAccount(Account account) {
		String accountNum = accNumGenerator();
		account.setAccountNumber(accountNum);
		list.add(account);
		return account;
	}
	
	// R ead
	public Account getAccount(int index) {
		Account account = list.get(index);
		
		Account reqObj = new Account(account.getAccId(),account.getAccNumber(),account.getMoney());
		return reqObj;
	}
	
	public Account getAccountByNum(String accountNum) {
		Account account = null;
		
		for(Account object : list) {
			if(object.getAccNumber().equals(accountNum))
				account = object;
		}
		return account;
	}
	
	// U pdate
	public void setAccount(int index, Account account) {
		list.set(index, account);
	}
	
	// D elete
	public void deleteAccount(int index) {
		list.remove(index);
	}
	
	private String accNumGenerator() {
		// ####-####
		String num = "";
		
		Random ran = new Random();
		
		while(true) {
			int first = ran.nextInt(8999)+1000;
			int second = ran.nextInt(8999)+1000;
			
			num = first + "-" + second;	
			
			Account account = getAccountByNum(num);
			
			if(account == null)
				break;
		}
		
		return num;
	}
	
	public int getAccListSize() {
		return list.size(); 
	} 
	
}