package com.kea.test.sort;

import com.kea.Model.Wagon;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int port = 9090;
        ServerSocket serverSocket;
        Socket socket;
        InputStream inputStream;
        ObjectInputStream objectInputStream;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Listening on port " + port);
            socket = serverSocket.accept();
            System.out.println("Accepted new connection");

            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

            List<Wagon> arrivedWagons = (List<Wagon>)objectInputStream.readObject();
            System.out.println("Received " + arrivedWagons.size() + " new wagons to be sorted.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
