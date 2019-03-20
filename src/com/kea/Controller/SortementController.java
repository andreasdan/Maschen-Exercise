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
		sqlUsername = "autologbot";
		sqlPassword = "";
		routes = getRoutesFromDatabase();
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public List<Train> sortWagons(List<Wagon> wagons) {
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
			String query = "SELECT * FROM routes";

			Connection connection = DriverManager.getConnection(jdbcConnectString, sqlUsername, sqlPassword);
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet res = stmt.executeQuery(query);

			while (res.next())
			{
				int routeId = res.getInt("RouteId");
				int stopId = res.getInt("StopId");
				int stationsId = res.getInt("StationsId");

				switch (routeId)
				{
					case 1:
						routeOne.addStation(stopId, Station.values()[stationsId + 1]);
						break;
					case 2:
						routeTwo.addStation(stopId, Station.values()[stationsId + 1]);
						break;
					case 3:
						routeThree.addStation(stopId, Station.values()[stationsId + 1]);
						break;
					case 4:
						routeFour.addStation(stopId, Station.values()[stationsId + 1]);
						break;
					case 5:
						routeFive.addStation(stopId, Station.values()[stationsId + 1]);
						break;
				}
			}
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