package com.twu.biblioteca;

import org.mockito.internal.configuration.injection.scanner.MockScanner;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    protected List<Book> list;
    protected List<Book> checkedOutList;
    protected Book returningBook;
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
        }
        else if(scanner.scanInput().equals("Option 3")) {
            returnBook(returningBook); //does this work??
        }
        else if (scanner.scanInput().equals("X")){
            quitApp();
        }
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
        checkedOutList.add(checkedOutBook);
        return checkedOutBook;
    }

    protected void returnBook(Book returningBook) {
        for (Book i: checkedOutList) {
            if (returningBook.title.equals(i.title)) {
                printStream.println("Thank you for returning the book.");
                list.add(returningBook);
            }
            else{
                printStream.println("That is not a valid book to return.");
            }
        }
    }

    protected void quitApp(){
        printStream.println("Quitting Biblioteca App!");
        scanner.scanClose();
    }

    /*public static void main(String[] args){
        start();
    }*/
}
