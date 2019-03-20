package com.kea.Model;

public enum WagonStatus {
	TO_BE_SORTED(1),
	SORTED(2),
	DEPLOYED(3),
	ARRIVED(4);

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