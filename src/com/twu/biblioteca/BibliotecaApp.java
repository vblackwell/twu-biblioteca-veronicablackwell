package com.twu.biblioteca;

import org.mockito.internal.configuration.injection.scanner.MockScanner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    protected List<Book> list;
    protected PrintStream printStream;
    protected ScanWrap scanner;


    public BibliotecaApp(List<Book> list, PrintStream printStream, ScanWrap scanner){
        this.list = list;
        this.printStream = printStream;
        this.scanner = scanner;
    }

    protected void start(){
        welcome();
        printMenu();
        userChooseOption(scanner);
    }

    protected void printMenu(){
        printStream.println("MENU\nOption 1");
    }

    protected void welcome() {
        printStream.println("welcome:)");
    }

    protected void listBooks() {
        for (Book i: list) {
            printStream.println(i);
        }
    }

    protected void userChooseOption(ScanWrap scanner) {
        if (scanner.scanInput().equals("Option 1")){
            listBooks();
        }
        else if(scanner.scanInput().equals("Option 2")){
            checkOut();
        }/*
        else if (scanner.scanInput().equals("X")){
            quitApp();
        }*/
        else {
            printStream.println("Invalid Option!");
        }
    }

    protected Boolean isBookInLib(){
        for (Book i: list){
            if (scanner.scanInput().equals(i.title)){
                printStream.println("Thank you! Enjoy the book");
                return true;
            }
        }
        printStream.println("Sorry, that book is not available");
        return false;
    }

    protected Book checkOut(){
        Book checkedOutBook = null;
        if (isBookInLib().equals(true)){
             for(Book i: list) {
                 if (scanner.scanInput().equals(i.title)) {
                     checkedOutBook = i;
                 }
             }

        }
        list.remove(checkedOutBook);
        return checkedOutBook;
    }

    /*protected void quitApp(){

    }

    public static void main(String[] args){

    }

    /*public List<Book> addList(Book book){
        list
    }*/
}
