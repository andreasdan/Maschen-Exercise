package com.kea.Controller;

import com.kea.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WagonGenerator {

	private List<Wagon> wagons;
	private int nextWagonId = 0;

	public WagonGenerator() {
		wagons = new ArrayList<>();
	}

	public List<Wagon> getWagons() {
		return wagons;
	}

	public void setWagons(List<Wagon> wagons) {
		this.wagons = wagons;
	}

	public void generateWagons() {
		Random random = new Random();
		int count = random.nextInt(10)+1;

		for(int i = 0; i <= count; i++)
		{
			nextWagonId++;

			Wagon newWagon = new Wagon();

			int cargoType = random.nextInt(7)+1;
			int weightType = random.nextInt(3)+1;
			int station = random.nextInt(12)+1;

			newWagon.setCargoType(CargoType.values()[cargoType]);
			newWagon.setWeightType(WeightType.values()[weightType]);
			newWagon.setDestination(Station.values()[station]);

			newWagon.setWagonStatus(WagonStatus.TO_BE_SORTED);
			newWagon.setWagonId(nextWagonId);

			wagons.add(newWagon);
		}
	}
}