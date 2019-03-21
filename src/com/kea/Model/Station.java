package com.kea.Model;

public enum Station {
	HAMBURG_HARBOUR(1),
	SCANDINAVIA(2),
	DUISBURG(3),
	KÖLN(4),
	STUTTGART(5),
	HANNOVER(6),
	KASSEL(7),
	FRANKFURT(8),
	BERLIN(9),
	LEIPZIG(10),
	NÜRNBERG(11),
	MUNICH(12);

	private int id;

	Station(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}