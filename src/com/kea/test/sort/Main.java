package com.kea.test.sort;

import com.kea.Controller.DatabaseController;
import com.kea.Controller.SortementController;
import com.kea.Model.Train;
import com.kea.Model.Wagon;
import com.kea.Model.WagonStatus;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int port = 9090;
        ServerSocket serverSocket;
        SortementController sortementController = new SortementController();

        try
        {
            serverSocket = new ServerSocket(port);
            System.out.println("Listening on port " + port + "...");

            while (true)
            {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted new connection.");

                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                List<Wagon> arrivedWagons = (List<Wagon>) objectInputStream.readObject();
                System.out.println("Received " + arrivedWagons.size() + " new wagons to be sorted.");
                DatabaseController dbController = new DatabaseController();
                for(Wagon wagon : arrivedWagons)
                {
                    dbController.add(wagon);
                    dbController.update(wagon, WagonStatus.TO_BE_SORTED);
                }

                List<Train> trains = sortementController.sortWagons(arrivedWagons);
                sortementController.deployTrains(trains);

                System.out.println("Closing connection...");

                socket.close();
                inputStream.close();
                objectInputStream.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
