package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public Menu(){

    }


    public void showMenu(){

        System.out.println("Train menu");
        System.out.println("1: Se status for vogne");
        int valg = InputHandler.readInt();

        if(valg==1)
        {
            printResultSet();
        }

    }

    public void printResultSet(ResultSet rs)
    {
        try{
            rs.beforeFirst();
            while(rs.next())
            {

            }

        }

        catch (SQLException e) {
            e.printStackTrace();

        }

    }



}
