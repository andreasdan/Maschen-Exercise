package com.kea.Controller;

import com.kea.Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Log {

	private String jdbcConnectString;
	private String sqlUsername;
	private String sqlPassword;
	private ResultSet resultSet;

	public Log() {
		jdbcConnectString = "jdbc:mysql://localhost:3306/maschen";
		sqlUsername = "autologbot";
		sqlPassword = "";
		resultSet = null;
	}

	/**
	 * 
	 * @param wagon
	 */
	public void update(Wagon wagon) {
		// TODO - implement Log.update
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param wagon
	 */
	public void add(Wagon wagon) {
		// TODO - implement Log.add
		throw new UnsupportedOperationException();
	}

	public ResultSet getResultSet()
	{
		return resultSet;
	}

	public ResultSet getWagonStatus(WagonStatus wagonStatus) {
		// TODO - implement Log.getWagonStatus
		throw new UnsupportedOperationException();
	}

	private Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(jdbcConnectString, sqlUsername, sqlPassword);
	}

}