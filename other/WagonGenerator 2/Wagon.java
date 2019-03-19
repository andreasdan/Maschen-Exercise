package com.company;

import java.util.Random;

public class Wagon {

    static int instanceWagonID = 0;
    int wagonID = 0;
    Random random = new Random();

    public Wagon(){

        instanceWagonID++;
        wagonID = instanceWagonID;
        String cargo = "";
        String weight = "";
        String station = "";


        int cargoID = random.nextInt(7-1+1)+1;
        int weightID = random.nextInt(3-1+1)+1;
        int stationID = random.nextInt(12-1+1)+1;

        if(stationID==1)
        {
            station = "HAMBOURG_HARBOUR";
        }
        else if(stationID==2)
        {
            station = "SCANDINAVIA";
        }
        else if(stationID==3)
        {
            station = "DUISBURG";
        }
        else if(stationID==4)
        {
            station = "KÖLN";
        }
        else if(stationID==5)
        {
            station = "STUTTGART";
        }
        else if(stationID==6)
        {
            station = "HANNOVER";
        }
        else if(stationID==7)
        {
            station = "KASSEL";
        }
        else if(stationID==8)
        {
            station = "FRANKFURT";
        }
        else if(stationID==9)
        {
            station = "BERLIN";
        }
        else if(stationID==10)
        {
            station = "LEIPZIG";
        }
        else if(stationID==11)
        {
            station = "NÜRNBERG";
        }
        else if(stationID==12)
        {
            station = "MUNICH";
        }




        if(weightID == 1)
        {
            weight = "HEAVY";
        }
        else if(weightID==2)
        {
            weight = "MEDIUM";
        }
        else if(weightID==3)
        {
            weight = "LIGHT";
        }

        if(cargoID==1)
        {
            cargo = "WOOD";
        }
        else if (cargoID==2)
        {
            cargo = "STEEL";
        }
        else if(cargoID==3)
        {
            cargo = "OIL";
        }
        else if(cargoID==4)
        {
            cargo = "GASOLINE";
        }
        else if(cargoID==5)
        {
            cargo = "FOOD";
        }
        else if(cargoID==6)
        {
            cargo = "CARS";
        }
        else if(cargoID==7)
        {
            cargo = "GENERAL_GOODS";
        }


    }
}
