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
    protected ByteArrayOutputStream outputStream;
    protected PrintStream printStream;
    protected ScanWrap mockScanner;
    protected List<Book> testList = new ArrayList<Book>();
    protected Book testBook1;
    protected Book testBook2;
    protected Book testBook3;

    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        mockScanner = mock(ScanWrap.class);
        testBook1 = new Book("It", "Stephan King", 1989);
        testBook2 = new Book("Harry Potter", "JK Rowling", 1991);
        testBook3 = new Book("Corazon", "Yesika S.", 2017);
        testList.add(testBook1);
        testList.add(testBook2);
        testList.add(testBook3);
        biblibtest = new BibliotecaApp(testList, printStream, mockScanner);
    }

    @Test
    public void shouldWelcome() {
        biblibtest.welcome();
        assertThat(outputStream.toString(), is("welcome:)\n"));
    }

    @Test
    public void shouldListBooks() {
        biblibtest.listBooks();
        assertThat(outputStream.toString(), is("It, Stephan King, 1989\nHarry Potter, JK Rowling, 1991\nCorazon, " +
                "Yesika S., 2017\n"));
    }

    @Test
    public void shouldStartMenu(){
        biblibtest.start();
        assertThat(outputStream.toString(), is("welcome:)\nMENU\nOption 1\n"));
    }

    @Test
    public void userShouldChooseOption(){
        biblibtest.userChooseOption(mockScanner);
        assertThat(outputStream.toString(), is("Option 1: List of Books\n"));
    }

}
