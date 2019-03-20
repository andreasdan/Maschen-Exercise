package com.kea.Controller;

import com.kea.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WagonGenerator {

	private List<Wagon> wagons;

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
			Wagon newWagon = new Wagon();
			newWagon.setCargoType(CargoType.values()[random.nextInt(7)+2]);
			newWagon.setWeightType(WeightType.values()[random.nextInt(3)+2]);
			newWagon.setDestination(Station.values()[random.nextInt(12)+2]);
			newWagon.setWagonStatus(WagonStatus.TO_BE_SORTED);
			wagons.add(newWagon);
		}
	}
}