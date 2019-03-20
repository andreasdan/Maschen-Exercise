package com.kea.Controller;

import com.kea.Model.*;

import java.util.ArrayList;
import java.util.List;

public class SortementController {


	private List<Wagon> wagons;
	private List<Route> routes;

	public SortementController() {
		wagons = new ArrayList<>();
		routes = new ArrayList<>();
	}

	public List<Wagon> getWagons() {
		return wagons;
	}

	public void setWagons(List<Wagon> wagons) {
		this.wagons = wagons;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public void sortWagons() {
		for (Wagon wagon : wagons)
		{

		}
	}

}