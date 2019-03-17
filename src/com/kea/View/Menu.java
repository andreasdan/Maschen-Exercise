package com.kea.View;

import com.kea.Controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

	private Log log;
	private Scanner scanner;

	public Menu() {
		log = new Log();
		scanner = new Scanner(System.in);
	}

	public void showMenu() {
		System.out.println("Train menu");
		System.out.println("1: Check wagon status");
		System.out.println("2: Close");
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