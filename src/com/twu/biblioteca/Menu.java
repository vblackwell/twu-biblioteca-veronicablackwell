package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Menu {

    protected PrintStream printStream;
    protected ScanWrap scanner;

    public Menu(PrintStream printStream, ScanWrap scanner){
        this.printStream = printStream;
        this.scanner = scanner;
    }

    protected void welcome() {
        printStream.println("welcome:)");
    }

    protected void printMenu(){
        printStream.println("MENU\nOption 1\nOption 2\nOption 3\n");
    }

    protected void listBooks(List<Book> listBooks) {
        for (Book i: listBooks) {
            printStream.println(i);
        }
    }

    protected void successCheckout(){
        printStream.println("Thank you! Enjoy the book");
    }

    protected void unsuccessCheckout(){
        printStream.println("Sorry, that book is not available");
    }

    protected void successReturn(){
        printStream.println("Thank you for returning the book.");
    }

    protected void unsuccessReturn(){
        printStream.println("That is not a valid book to return.");
    }

    protected void quitPrint(){
        printStream.println("Quitting Biblioteca App!");
    }
}
