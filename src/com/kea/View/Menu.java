package com.kea.View;

import com.kea.Controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private DatabaseController dbController;
	private Scanner scanner;
	private boolean runMenu;

	public Menu() {
		scanner = new Scanner(System.in);
	}

	public void showMenu()
	{
		runMenu = true;
		while (runMenu) {
			System.out.println("Train menu");
			System.out.println("1: Check wagon status from Id");
			System.out.println("2: See all wagon entries");
			System.out.println("3: Close");
			int valg = readInput();

			switch (valg) {
				case 1:
					System.out.println("Insert wagon Id");
					int id = readInput();
					List<String> entries = dbController.getWagonStatus(id);
					for (String entry : entries) {
						System.out.println(entry);
					}
				case 2:
					List<String> allEntries = dbController.getAllWagonStatus();
					for (String entry : allEntries) {
						System.out.println(entry);
					}
					break;
				case 3:
					runMenu = false;
					break;
				default:
					System.out.println("Invalid menu option..");
					break;
			}
		}

	}

	private int readInput() {
		System.out.print(" >");
		while(!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("Wrong input..");
			System.out.print(" >");
		}
		return scanner.nextInt();
	}
}