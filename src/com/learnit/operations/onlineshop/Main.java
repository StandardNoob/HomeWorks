package com.learnit.operations.onlineshop;

import com.learnit.operations.onlineshop.menu.Menu;
import com.learnit.operations.onlineshop.menu.impl.MainMenu;

public class Main {

	public static final String EXIT_COMMAND = "exit";

	public static void main(String[] args) {
		Menu mainMenu = new MainMenu();
		mainMenu.start();
	}

}
