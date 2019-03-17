package com.kea.Model;

public enum CargoType {
	WOOD(1),
	STEEL(2),
	OIL(3),
	GASOLINE(4),
	FOOD(5),
	CARS(6),
	GENERAL_GOODS(7);

	private int id;

	CargoType(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}