package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    protected List<Book> list;

    public static void main(String[] args){}

    protected void start(PrintStream printStream, List<Book> list){
        welcome(printStream);
        listBooks(printStream, list);
    }

    protected void welcome(PrintStream printStream) {
        printStream.println("welcome:)");
    }

    protected void listBooks(PrintStream printStream, List<Book> testList) {
        for (Book i: testList) {
            printStream.println(i);
        }
    }

    /*public List<Book> addList(Book book){
        list
    }*/
}
