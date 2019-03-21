package com.kea.test.generate;

import com.kea.Controller.WagonGenerator;
import com.kea.Model.Wagon;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        Socket socket;
        OutputStream output;
        ObjectOutputStream objectOutputStream;

        try
        {
            socket = new Socket("localhost", 9090);
            output = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(output);

            WagonGenerator generator = new WagonGenerator();
            generator.generateWagons();

            for (Wagon wagon : generator.getWagons()) {
                System.out.println(wagon.toString());
            }

            objectOutputStream.writeObject(generator.getWagons());
            objectOutputStream.flush();
            objectOutputStream.close();
            output.close();
            socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
