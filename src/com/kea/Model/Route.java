package com.kea.Model;

import java.util.TreeMap;

public class Route {

	private TreeMap<Integer, Station> route;

	public Route() {
		route = new TreeMap<>();
	}

	public TreeMap<Integer, Station> getRoute() {
		return route;
	}

	/**
	 * 
	 * @param stopId
	 * @param station
	 */
	public void addStation(int stopId, Station station) {
		route.put(stopId, station);
	}

}