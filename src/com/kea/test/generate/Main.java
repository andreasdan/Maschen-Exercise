package com.kea.test.generate;

import com.kea.Controller.WagonGenerator;
import com.kea.Model.Wagon;

public class Main {
    public static void main(String[] args) {
        WagonGenerator generator = new WagonGenerator();
        generator.generateWagons();

        for (Wagon wagon : generator.getWagons())
        {
            System.out.println(wagon.toString());
        }
    }
}
