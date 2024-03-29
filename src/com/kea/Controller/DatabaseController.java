package com.kea.Controller;

import com.kea.Model.*;

import java.sql.*;
import java.time.LocalDateTime;
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

	public void add(Wagon wagon) {
		try {
			String query = "INSERT INTO " +
					"wagons(Id, StationsId, WeightTypeId, CargoTypeId)" +
					"VALUES(" + wagon.getWagonId() + "," + wagon.getDestination().getId() + ", " + wagon.getWeightType().getId() + "," + wagon.getCargoType().getId() + ")";

			Connection connection = DriverManager.getConnection(jdbcConnectString, sqlUsername, sqlPassword);
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			statement.execute(query);

			if (statement!=null) { statement.close(); }
			if (connection!=null) { connection.close(); }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void update(Wagon wagon, WagonStatus wagonStatus) {

		try {
			String query = "INSERT INTO " +
					"log (Timestamp, WagonsId, WagonStatusId)" +
					"VALUES ('" + Timestamp.valueOf(LocalDateTime.now()) + "', " + wagon.getWagonId() + ", " + wagonStatus.getId() + ")";

			Connection connection = DriverManager.getConnection(jdbcConnectString, sqlUsername, sqlPassword);
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			statement.execute(query);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<String> getWagonStatus(int wagonId) {

		List<String> wagonStatusList = new ArrayList<>();

		try
		{
			String query = "SELECT log.Id,\n" +
					"    log.Timestamp AS Timestamp,\n" +
					"    wagons.Id AS WagonId,\n" +
					"    wagonstatus.Description AS WagonStatus,\n" +
					"    weighttype.Description AS WeightType,\n" +
					"    cargotype.Description AS CargoType,\n" +
					"    stations.Name AS Station\n" +
					"FROM log\n" +
					"INNER JOIN wagons ON wagons.Id = log.WagonsId\n" +
					"INNER JOIN wagonstatus ON log.WagonStatusId = wagonstatus.Id\n" +
					"INNER JOIN weighttype ON wagons.WeightTypeId = weighttype.Id\n" +
					"INNER JOIN cargotype ON wagons.CargoTypeId = cargotype.Id\n" +
					"INNER JOIN stations ON wagons.StationsId = stations.Id\n" +
					"WHERE log.WagonsId = " + wagonId + ";";

			Connection connection = DriverManager.getConnection(jdbcConnectString, sqlUsername, sqlPassword);
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet res = statement.executeQuery(query);

			while(res.next())
			{
				Timestamp timestamp = res.getTimestamp("Timestamp");
				String stationName = res.getString("Station");
				int wagonID = res.getInt("WagonId");
				String cargoType = res.getString("CargoType");
				String wagonStatus = res.getString("WagonStatus");
				String weightType = res.getString("WeightType");

				String wagonInfo = "Timestamp = " + timestamp.toString() + " Wagon ID = " + wagonID + " Destination = " + stationName + " Cargotype = " + cargoType + " Wagonstatus = "
						+ wagonStatus + " Weighttype = " + weightType;

				wagonStatusList.add(wagonInfo);

			}
			if (res!=null) { res.close(); }
			if (statement!=null) { statement.close(); }
			if (connection!=null) { connection.close(); }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return wagonStatusList;
	}

	public List<String> getAllWagonStatus() {

		List<String> wagons = new ArrayList<>();

		try
		{
			String query = "SELECT log.Id,\n" +
					"    log.Timestamp AS Timestamp,\n" +
					"    wagons.Id AS WagonId,\n" +
					"    wagonstatus.Description AS WagonStatus,\n" +
					"    weighttype.Description AS WeightType,\n" +
					"    cargotype.Description AS CargoType,\n" +
					"    stations.Name AS Station\n" +
					"FROM log\n" +
					"INNER JOIN wagons ON wagons.Id = log.WagonsId\n" +
					"INNER JOIN wagonstatus ON log.WagonStatusId = wagonstatus.Id\n" +
					"INNER JOIN weighttype ON wagons.WeightTypeId = weighttype.Id\n" +
					"INNER JOIN cargotype ON wagons.CargoTypeId = cargotype.Id\n" +
					"INNER JOIN stations ON wagons.StationsId = stations.Id\n";

			Connection connection = DriverManager.getConnection(jdbcConnectString, sqlUsername, sqlPassword);
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet resSet = statement.executeQuery(query);

			while(resSet.next())
			{
				Timestamp timestamp = resSet.getTimestamp("Timestamp");
				String stationName = resSet.getString("Station");
				int wagonID = resSet.getInt("WagonId");
				String cargoType = resSet.getString("CargoType");
				String wagonStatus = resSet.getString("WagonStatus");
				String weightType = resSet.getString("WeightType");

				String cargoAll ="Timestamp = " + timestamp.toString() + " Wagon ID = " + wagonID + " Destination = " + stationName + " Cargotype = " + cargoType + " Wagonstatus = "
						+ wagonStatus + " Weighttype = " + weightType;

				wagons.add(cargoAll);

			}
			if (resSet!=null) { resSet.close(); }
			if (statement!=null) { statement.close(); }
			if (connection!=null) { connection.close(); }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return wagons;
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