package com.twu.biblioteca;


import com.twu.biblioteca.BibliotecaApp;
import org.junit.*;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
 * Author: Veronica Blackwell
 * Paired With: Daisy Arellano and Thalia Estrella
 */

public class BibliotecaAppTest {

    protected BibliotecaApp biblibtest;
    //protected ByteArrayOutputStream outputStream;
    protected PrintStream mockPrintStream;
    protected ScanWrap mockScanner;
    protected Menu mockMenu;

    protected List<Book> testBooks = new ArrayList<Book>();
    protected Book testBook1;
    protected Book testBook2;
    protected Book testBook3;

    protected List<Movie> testMovies = new ArrayList<>();
    protected Movie testMovie1;
    protected Movie testMovie2;
    protected Movie testMovie3;

    @Before
    public void setUp(){
        //outputStream = new ByteArrayOutputStream();
        mockPrintStream = mock(PrintStream.class);
        mockScanner = mock(ScanWrap.class);
        mockMenu = mock(Menu.class);

        testBook1 = new Book("It", "Stephan King", 1989);
        testBook2 = new Book("Harry Potter", "JK Rowling", 1991);
        testBook3 = new Book("Corazon", "Yesika S.", 2017);
        testBooks.add(testBook1);
        testBooks.add(testBook2);
        testBooks.add(testBook3);

        testMovie1 = new Movie("Kill Bill", "Quentin Tarantino", 2003, "8");
        testMovie2 = new Movie("Pulp Fiction", "Quentin Tarantino", 1994, "9");
        testMovie3 = new Movie("Django Unchained", "Quentin Tarantino", 2012, "9");
        testMovies.add(testMovie1);
        testMovies.add(testMovie2);
        testMovies.add(testMovie3);

        biblibtest = new BibliotecaApp(testBooks, testMovies, mockPrintStream, mockScanner, mockMenu);
    }

    /*
    Older story tests that were no longer needed due to starting to use mock
    @Test
    public void shouldWelcome() {
        biblibtest.welcome();
        //assertThat(outputStream.toString(), is("welcome:)\n"));
        String expectedWelcome = "welcome:)";
        verify(mockPrintStream).println(expectedWelcome);
    }

    @Test
    public void shouldStartMenu(){
        biblibtest.start();
        assertThat(outputStream.toString(), is("welcome:)\nMENU\nOption 1\n"));
    }*/

    @Test
    public void userShouldChooseOption1(){
        when(mockScanner.scanInput()).thenReturn("Option 1");
        biblibtest.userChooseOption();
        verify(mockMenu).listBooks(testBooks);
    }

   /*@Test
    public void userShouldChooseOption2(){
        when(mockScanner.scanInput()).thenReturn("Option 2");
        biblibtest.userChooseOption();
        biblibtest.checkOut(mockScanner);
        when(mockScanner.scanInput()).thenReturn("It");
        assertThat(biblibtest.checkOut(mockScanner), is(testBook1));
    }

    /*@Test
    public void shouldCheckOut(){
        biblibtest.checkOut();
        assertThat();
    }

    @Test
    public void shouldQuit(){
        biblibtest.quitApp();
        when();
    }*/

}
