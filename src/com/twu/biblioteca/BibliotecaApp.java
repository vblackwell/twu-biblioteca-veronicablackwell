package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void run(PrintStream printStream) {
        printStream.print("welcome:)");
    }

    public void runList(PrintStream printStream, List<String> testList) {
        for (String i: testList) {
            printStream.print(i);
            printStream.print("\n");
        }
    }
}
