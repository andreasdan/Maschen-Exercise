package com.kea.Controller;

import com.kea.Model.*;

import java.util.ArrayList;
import java.util.List;

public class SortementController {

	private List<Train> trains;
	private List<Route> routes;

	public SortementController() {
		trains = new ArrayList<>();
		routes = new ArrayList<>();
	}

	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	/**
	 * 
	 * @param wagons
	 */
	public void sortWagons(List<Wagon> wagons) {
		for (Wagon wagon : wagons)
		{

		}
	}

}