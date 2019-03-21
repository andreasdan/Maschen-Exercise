package com.kea.View;

import com.kea.Controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

	private DatabaseController dbController;
	private Scanner scanner;
	private boolean runMenu;

	public Menu() {
		scanner = new Scanner(System.in);
	}

	public void showMenu() {
		System.out.println("Train menu");
		System.out.println("1: Check wagon status");
		System.out.println("0: Close");
		int valg = readInput();
		while(runMenu)
			{
				if(valg == 0)
				{
					runMenu = false;
				}
				if(valg == 1)
				{
					for{
						int id;
						dbController.getWagonStatus(id);
				}

				}
				}
			}
	}

	public int readInput() {
		while(!scanner.hasNextInt()) {
			scanner.next();
		}
		return scanner.nextInt();
	}

	/**
	 * 
	 * @param resultSet
	 */
	public void printResultSet(ResultSet resultSet) {
		try{
			resultSet.beforeFirst();
			while(resultSet.next())
			{
			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		}
	}

}