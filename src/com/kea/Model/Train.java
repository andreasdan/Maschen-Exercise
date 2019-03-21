package com.kea.Model;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private int wagonLimit = 10;
    private List<Wagon> wagons;
    private Route route;

    public Train() {
        wagons = new ArrayList<>();
        route = new Route();
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    /**
     *
     * @param train
     */
    public boolean equals(Train train) {
        if (train.getWagons().size() != wagons.size())
        {
            return false;
        }

        for (int i = 0; i < wagons.size(); i++)
        {
            if (wagons.get(i).getWagonId() != train.getWagons().get(i).getWagonId())
            {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        String trainString = "";

        for (Wagon wagon : wagons)
        {
            trainString += wagon.toString() + "\n";
        }

        return trainString;
    }

    /**
     *
     * @param wagon
     */
    public void add(Wagon wagon) {
        if (wagons.size() < wagonLimit) {
            wagons.add(wagon);
        }
    }

}