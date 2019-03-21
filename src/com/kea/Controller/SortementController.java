package com.kea.Controller;

import com.kea.Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SortementController {

	private List<Route> routes;
	private String jdbcConnectString;
	private String sqlUsername;
	private String sqlPassword;

	public SortementController()
	{
		jdbcConnectString = "jdbc:mysql://localhost:3306/maschen";
		sqlUsername = "autosortbot";
		sqlPassword = "";
		routes = getRoutesFromDatabase();
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public List<Train> sortWagons(List<Wagon> wagons)
	{
		List<Train> trains = new ArrayList<>();

		for (Wagon wagon : wagons)
		{
			Route correctRoute = null;
			for (Route route : routes)
			{
				if (route.hasStation(wagon.getDestination()))
				{
					correctRoute = route;
				}
			}

			boolean hasTrain = false;
			for (Train train : trains)
			{
				if (train.getRoute().hasStation(wagon.getDestination()))
				{
					train.add(wagon);
					hasTrain = true;
					break;
				}
			}

			if (!hasTrain)
			{
				Train train = new Train();
				train.setRoute(correctRoute);
				train.add(wagon);
				trains.add(train);
			}
		}

		return trains;
	}

	private List<Route> getRoutesFromDatabase()
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
				Station station = Station.values()[stationsId + 1];

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

}