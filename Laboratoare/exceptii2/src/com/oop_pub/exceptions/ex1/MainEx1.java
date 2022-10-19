package com.oop_pub.exceptions.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainEx1 {

    private static void readAndPrintLine() {

        // TODO: Read a line from stdin and print it to stdout
        // TODO: Don't forget to close the reader (Hint: try-with-resources, try-finally)

        // try with resources
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String string = null;
            if ((string = reader.readLine()) != null) {
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        readAndPrintLine();
    }
}
