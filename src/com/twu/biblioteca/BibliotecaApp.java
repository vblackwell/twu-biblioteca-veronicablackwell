package com.twu.biblioteca;

import org.mockito.internal.configuration.injection.scanner.MockScanner;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    protected List<Book> list;
    protected List<Book> checkedOutList = new ArrayList<Book>();
    protected Book returningBook;
    protected PrintStream printStream;
    protected ScanWrap scanner;
    protected Menu menu;


    public BibliotecaApp(List<Book> list, PrintStream printStream, ScanWrap scanner, Menu menu){
        this.list = list;
        this.printStream = printStream;
        this.scanner = scanner;
        this.menu = menu;
    }

    protected void start(){
        menu.welcome();
        menu.printMenu();
        userChooseOption();
    }

    protected void userChooseOption() {
        String userInput;
        while(true) {
            userInput = scanner.scanInput();
            if (userInput.equals("Option 1")) {
                menu.listBooks(list);
            }
            else if (userInput.contentEquals("Option 2")) {
                checkOut(scanner);
            } else if (userInput.equals("Option 3")) {
                returnBook(scanner); //returningBook as parameter
            } else if (userInput.toUpperCase().equals("X")) {
                quitApp();
                break;
            } else {
                printStream.println("Invalid Option!");
            }
        }
    }

    protected Boolean isBookInLib(String userInput){
        for (Book i: list){
            if (userInput.equals(i.title)){
                menu.successCheckout();
                return true;
            }
        }
        menu.unsuccessCheckout();
        return false;
    }

    protected Book checkOut(ScanWrap scanner){
        printStream.println("Enter book title");
        Book checkedOutBook = null;
        String userInput = scanner.scanInput();
        if (isBookInLib(userInput)){
             for(Book i: list) {
                 if (userInput.equals(i.title)) {
                     checkedOutBook = i;
                 }
             }
        }
        else {
            printStream.println("Invalid");
        }
        checkedOutList.add(checkedOutBook);
        list.remove(checkedOutBook);
        return checkedOutBook;
    }

    protected void returnBook(ScanWrap scanner) {
        String[] bookPieces = scanner.scanInput().split(",");
        String title = bookPieces[0];
        String author = bookPieces[1];
        int pubYear = Integer.parseInt(bookPieces[2]);
        Book returningBook = new Book(title, author, pubYear);

        boolean bookNotChecked = false;
        for (Book i: checkedOutList) {
            if (returningBook.title.equals(i.title)) {
                list.add(returningBook);
                checkedOutList.remove(returningBook);
                menu.successReturn();
                bookNotChecked = true;
            }
        }
        if (!bookNotChecked) {
            menu.unsuccessReturn();
        }
    }

    protected void quitApp(){
        menu.quitPrint();
        scanner.scanClose();
    }

    public static void main(String[] args){
        List<Book> mainBooks = new ArrayList<>();
        mainBooks.add(new Book("It", "Stephan King", 1989));
        mainBooks.add(new Book("Harry Potter", "JK Rowling", 1991));
        mainBooks.add(new Book("Corazon", "Yesika S.", 2017));

        BibliotecaApp bookApp = new BibliotecaApp(mainBooks, new PrintStream(System.out), new ScanWrap(),
                new Menu(new PrintStream(System.out), new ScanWrap()));
        bookApp.start();
    }
}
