package com.kea.Model;

public class Wagon {

	private WeightType weightType = null;
	private CargoType cargoType = null;
	private WagonStatus wagonStatus = null;
	private int wagonId = this.hashCode();
	private Station destination = null;

	public Wagon() {}

	public WeightType getWeightType() {
		return weightType;
	}

	public void setWeightType(WeightType weightType) {
		this.weightType = weightType;
	}

	public CargoType getCargoType() {
		return cargoType;
	}

	public void setCargoType(CargoType cargoType) {
		this.cargoType = cargoType;
	}

	public WagonStatus getWagonStatus() {
		return wagonStatus;
	}

	public void setWagonStatus(WagonStatus wagonStatus) {
		this.wagonStatus = wagonStatus;
	}

	public int getWagonId() {
		return wagonId;
	}

	public Station getDestination() {
		return destination;
	}

	public void setDestination(Station destination) {
		this.destination = destination;
	}

	/**
	 * 
	 * @param wagon
	 */
	public boolean equals(Wagon wagon) {
		return this.wagonId == wagon.wagonId;
	}

	public String toString() {
		return "wagonId: '" + wagonId + "'\n" +
				"weightType: '" + weightType + "'\n" +
				"cargoType: '" + cargoType + "'\n" +
				"wagonStatus: '" + wagonStatus + "'\n" +
				"destination: '" + destination + "'\n";
	}
}