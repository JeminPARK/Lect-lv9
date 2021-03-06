package models;

import controller.Bank;

public class BankManager {
	
	private FileManager fm = FileManager.instance;
	private AccountManager am = AccountManager.instance;
	private UserManager um = UserManager.instance;
	public static BankManager instance = new BankManager();

	private BankManager() {}
	
	public void run() {
		
		fm.load();
		System.out.println(Bank.getName());
		
		
		boolean isRun = true;
		while(isRun) {
			
			printMainMenu();
			isRun = selectMenu();
		}
		fm.save();
	}
	public void printMainMenu() {
		if(Bank.log == -1) {
			System.out.println("1.로그인\n2.회원가입\n3.종료");
		}
		else {
			System.out.println("1.입금\n2.출금\n3.이체\n4.조회\n5.계좌개설\n6.계좌철회\n7.로그아웃\n8.회원탈퇴\n");
		}
		if(Bank.log == 0) {
			System.out.println("9.관리자모드");
		}
	}
	public boolean selectMenu() {
		String input = Bank.scan.next();
		int sel = Integer.parseInt(input);
		if(Bank.log == -1) {
			if(sel == 1) {
				Bank.log = um.login();
			}
			else if(sel == 2) {
				um.addUser();
			}
			else if(sel == 3) {
				System.out.println("종료합니다.");
				return false;
			}
		}
		
		else {
			if(sel == 1) {
				am.inputCash();
			}
			else if(sel == 2) {
				am.withdraw();
			}
			else if(sel == 3) {
				am.sendMoney();
			}
			else if(sel == 4) {
				am.printAccs();
			}
			else if(sel == 5) {
				am.createAcc();
			}
			else if(sel == 6) {
				am.deleteAcc();
			}
			else if(sel == 7) {
				Bank.log = -1;
			}
			else if(sel == 8) {
				um.deleteUser();
			}
			
		}
		if(Bank.log == 0 && sel == 9) {
			System.out.println("1.전체유저조회\n2.전체계좌조회\n3.뒤로가기");
			selectAdmin();
		}
		
		return true;
	}
	private void selectAdmin() {
		int sel = Bank.scan.nextInt();
		if(sel == 1) {
			um.printAllUser();
		}
		else if(sel == 2) {
			am.printAllData();
		}
		else if(sel == 3) {
			printMainMenu();
		}
	}
}
