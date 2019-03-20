package com.kea.Controller;

import com.kea.Model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortementController {


	private List<Route> routes;

	public SortementController() {
		routes = new ArrayList<>();
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public Set<List<Wagon>> sortWagons(List<Wagon> wagons) {
		Set<List<Wagon>> allWagons = new HashSet<>();

		for (Wagon wagon : wagons)
		{

		}
	}

}