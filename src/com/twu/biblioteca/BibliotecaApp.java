package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    protected List<String> list = Arrays.asList("Mockingbird", "1994", "The Hobbit");

    public void start(PrintStream printStream, List<String> list){
        welcome(printStream);
        listBooks(printStream, list);
    }

    public void welcome(PrintStream printStream) {
        printStream.println("welcome:)");
    }

    public void listBooks(PrintStream printStream, List<String> testList) {
        for (String i: testList) {
            printStream.println(i);
        }
    }
}

/*public class main(String[] args){

}*/
