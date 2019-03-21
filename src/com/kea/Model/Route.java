package com.kea.Model;

import java.util.TreeMap;

public class Route {

	private int id;
	private TreeMap<Integer, Station> route;

	public Route() {
		route = new TreeMap<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean hasStation(Station station)
	{
		return route.containsValue(station);
	}

}