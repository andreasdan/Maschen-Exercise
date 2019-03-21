package com.kea.Controller;

import com.kea.Model.*;

import java.util.ArrayList;
import java.util.List;

public class SortementController {

    private DatabaseController dbController;
	private List<Route> routes;

	public SortementController()
	{
	    dbController = new DatabaseController();
		routes = dbController.getRoutesFromDatabase();
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

			dbController.update(wagon, WagonStatus.SORTED);
		}

		return trains;
	}

	public void deployTrains(List<Train> trains)
	{
		for (Train train : trains)
		{
			for (Wagon wagon : train.getWagons())
			{
				dbController.update(wagon, WagonStatus.DEPLOYED);
				dbController.update(wagon, WagonStatus.ARRIVED);
			}
		}
	}
}