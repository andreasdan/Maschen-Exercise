package com.kea.Model;

public enum WeightType {
	HEAVY(1),
	MEDIUM(2),
	LIGHT(3);

	private int id;

	WeightType(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}