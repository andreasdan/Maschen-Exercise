package com.company;

import java.util.ArrayList;
import java.util.Random;

public class WagonGenerator {

    ArrayList<Wagon> wagons = new ArrayList<Wagon>();
    Random random;


    public WagonGenerator()
    {

    }


    public void generateWagons()
    {
        int antal = random.nextInt(10-1+1)+1;
        Wagon wagon;
        for(int i = 0; i<=antal; i++)
        {
            wagons.add(new Wagon());
        }

    }
}
