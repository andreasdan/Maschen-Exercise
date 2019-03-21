package com.company;

import java.util.Scanner;

public class InputHandler {
    public static int readInt() {
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}
