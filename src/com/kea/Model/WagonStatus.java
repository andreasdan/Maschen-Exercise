package com.kea.Model;

public enum WagonStatus {
	ARRIVED(1),
	SORTED(1),
	DEPLOYED(3);

	private int id;

	WagonStatus(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}