package com.kea.Controller;

import com.kea.Model.*;

import java.sql.*;
import java.util.*;

public class DatabaseController {

	private String jdbcConnectString;
	private String sqlUsername;
	private String sqlPassword;

	public DatabaseController() {
		jdbcConnectString = "jdbc:mysql://localhost:3306/tog";
		sqlUsername = "bot";
		sqlPassword = "P@ssw0rd";
	}

	/**
	 * 
	 * @param wagon
	 * @param status  
	 */
	public void update(Wagon wagon, WagonStatus status) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param wagon
	 */
	public void add(Wagon wagon) {
		throw new UnsupportedOperationException();
	}

	public List<String> getAllWagonStatus() {

		List<String> wagons = new ArrayList<>();


		try
		{
			String query = "";

			Connection connection = DriverManager.getConnection(jdbcConnectString, sqlUsername, sqlPassword);
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet resSet = statement.executeQuery(query);

			while(resSet.next())
			{
				resSet.beforeFirst();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}



		return wagons;
	}

	public List<String> getWagonStatus(int wagonId) {
		throw new UnsupportedOperationException();
	}

	public List<Route> getRoutesFromDatabase()
	{
		List<Route> routes = new ArrayList<>();

		Route routeOne = new Route();
		Route routeTwo = new Route();
		Route routeThree = new Route();
		Route routeFour = new Route();
		Route routeFive = new Route();

		try
		{
			String query = "SELECT routeId, StopId, StationsId FROM routes";

			Connection connection = DriverManager.getConnection(jdbcConnectString, sqlUsername, sqlPassword);
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet resSet = statement.executeQuery(query);

			while (resSet.next())
			{
				int routeId = resSet.getInt("RouteId");
				int stopId = resSet.getInt("StopId");
				int stationsId = resSet.getInt("StationsId");
				Station station = Station.values()[stationsId - 1];

				switch (routeId)
				{
					case 1:
						routeOne.addStation(stopId, station);
						break;
					case 2:
						routeTwo.addStation(stopId, station);
						break;
					case 3:
						routeThree.addStation(stopId, station);
						break;
					case 4:
						routeFour.addStation(stopId, station);
						break;
					case 5:
						routeFive.addStation(stopId, station);
						break;
				}
			}

			if (resSet!=null) { resSet.close(); }
			if (statement!=null) { statement.close(); }
			if (connection!=null) { connection.close(); }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		routes.add(routeOne);
		routes.add(routeTwo);
		routes.add(routeThree);
		routes.add(routeFour);
		routes.add(routeFive);

		return routes;
	}

	private Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(jdbcConnectString, sqlUsername, sqlPassword);
	}

}