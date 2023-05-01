package org.java;

import java.util.Scanner;

public class Main {

    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        Generator generator = new Generator(keyboard);
        //generator.mainLoop();
        keyboard.close();

    }
}