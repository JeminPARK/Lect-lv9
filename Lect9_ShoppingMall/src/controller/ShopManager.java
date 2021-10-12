package controller;

import models.Shop;

public class ShopManager {

	private static ItemManager im = ItemManager.instance;
	private static UserManager um = UserManager.instance;
	public static ShopManager instance = new ShopManager();
	private ShopManager() {}
	
	public void run() {
		
		System.out.println(Shop.getName());
		boolean isRun = true;
		while(isRun) {
			printMenu();		
			isRun = selectMenu();
		}
	}
	private void printMenu() {
		
		if(Shop.log == -1) {
			System.out.println("1.ȸ������\n2.�α���\n3.����");
		}
		else {
			System.out.println("1.����\n2.��ٱ���\n3.�α׾ƿ�\n4.ȸ��Ż��");
		}
		if(Shop.log == 0) {
			System.out.println("5.�����ڸ��");
		}
			
			
	}
	
	private boolean selectMenu() {
		String input = Shop.scan.next();
		try {
			int sel = Integer.parseInt(input);
			
			if(Shop.log == -1) {
				if(sel == 1) {
					um.joinUser();
				}
				else if(sel == 2) {
					um.login();
				}
				else if(sel == 3) {
					System.out.println("�����մϴ�.");
					return false;
				}
			}
			else {
				if(sel == 1) {
					im.run();
				}
				else if(sel == 2) {
					
				}
				else if(sel == 3) {
					Shop.log= -1;
				}
				else if(sel == 4) {
					
				}
			}
			if(sel == 5 && Shop.log == 0) {
				
			}
		}
		catch(Exception e) {
			
		}
		return true;
		
	}
}
