package com.twu.biblioteca;

import com.sun.source.tree.LiteralTree;
import org.mockito.internal.configuration.injection.scanner.MockScanner;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    protected List<Book> books;
    protected List<Book> checkedOutBooks = new ArrayList<Book>();
    protected List<Movie> checkedOutMovies = new ArrayList<Movie>();
    protected List<Movie> movies;
    protected PrintStream printStream;
    protected ScanWrap scanner;
    protected Menu menu;


    public BibliotecaApp(List<Book> books, List<Movie> movies, PrintStream printStream, ScanWrap scanner, Menu menu){
        this.books = books;
        this.movies = movies;
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
                menu.listBooks(books);
            }
            else if (userInput.equals("Option 2")){
                checkOutBook(scanner);
            }
            else if (userInput.equals("Option 3")) {
                returnBook(scanner);
            }
            else if (userInput.equals("Option 4")) {
                menu.listMovies(movies);
            }
            else if (userInput.equals("Option 5")){
                checkOutMovie(scanner);
            }
            else if (userInput.toUpperCase().equals("X")) {
                quitApp();
                break;
            } else {
                printStream.println("Invalid Option!");
            }
        }
    }

    protected Boolean isBookInLib(String userInput){
        for (Book i: books){
            if (userInput.equals(i.title)){
                menu.successCheckout();
                return true;
            }
        }
        menu.unsuccessCheckout();
        return false;
    }

    protected Book checkOutBook(ScanWrap scanner){
        printStream.println("Enter book title");
        Book checkedOutBook = null;
        String userInput = scanner.scanInput();
        if (isBookInLib(userInput)){
             for(Book i: books) {
                 if (userInput.equals(i.title)) {
                     checkedOutBook = i;
                 }
             }
        }
        else {
            printStream.println("Invalid");
        }
        checkedOutBooks.add(checkedOutBook);
        books.remove(checkedOutBook);
        return checkedOutBook;
    }

    protected Boolean isMovieInLib(String userInput){
        for (Movie i: movies){
            if (userInput.equals(i.title)){
                menu.successCheckout();
                return true;
            }
        }
        menu.unsuccessCheckout();
        return false;
    }

    protected Movie checkOutMovie(ScanWrap scanner){
        printStream.println("Enter book title");
        Movie checkedOutMovie = null;
        String userInput = scanner.scanInput();
        if (isMovieInLib(userInput)){
            for(Movie i: movies) {
                if (userInput.equals(i.title)) {
                    checkedOutMovie = i;
                }
            }
        }
        else {
            printStream.println("Invalid");
        }
        checkedOutMovies.add(checkedOutMovie);
        books.remove(checkedOutMovie);
        return checkedOutMovie;
    }

    protected void returnBook(ScanWrap scanner) {
        printStream.println("Enter book title, author, and publication year in the following way." +
                "Example: It/Stephan King/1989");
        String[] bookPieces = scanner.scanInput().split("/");
        String title = bookPieces[0];
        String author = bookPieces[1];
        int pubYear = Integer.parseInt(bookPieces[2]);
        Book returningBook = new Book(title, author, pubYear);

        boolean bookNotChecked = false;
        for (Book i: checkedOutBooks) {
            if (returningBook.title.equals(i.title)) {
                books.add(returningBook);
                checkedOutBooks.remove(returningBook);
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

        List<Movie> mainMovies = new ArrayList<>();
        mainMovies.add(new Movie("Kill Bill", "Quentin Tarantino", 2003, "8"));
        mainMovies.add(new Movie("Pulp Fiction", "Quentin Tarantino", 1994, "9"));
        mainMovies.add(new Movie("Django Unchained", "Quentin Tarantino", 2012, "9"));

        BibliotecaApp bookApp = new BibliotecaApp(mainBooks, mainMovies, new PrintStream(System.out), new ScanWrap(),
                new Menu(new PrintStream(System.out)));
        bookApp.start();
    }
}
