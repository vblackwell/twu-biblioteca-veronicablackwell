package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    protected Menu testMenu;

    protected ByteArrayOutputStream outputStream;
    protected PrintStream printStream;
    protected List<Book> testList = new ArrayList<Book>();
    protected Book testBook1;
    protected Book testBook2;
    protected Book testBook3;

    @Before
    public void setUp(){
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        testBook1 = new Book("It", "Stephan King", 1989);
        testBook2 = new Book("Harry Potter", "JK Rowling", 1991);
        testBook3 = new Book("Corazon", "Yesika S.", 2017);
        testList.add(testBook1);
        testList.add(testBook2);
        testList.add(testBook3);
    }

    @Test
    public void shouldWelcome() {
        testMenu.welcome();
        assertThat(outputStream.toString(), is("welcome:)\n"));
//        String expectedWelcome = "welcome:)";
//        verify(printStream).println(expectedWelcome);
    }

    @Test
    public void shouldStartMenu(){
        testMenu.printMenu();
        assertThat(outputStream.toString(), is("MENU\nOption 1\nOption 2\nOption 3\n"));
//        String expectedMenu = "MENU\nOption 1\nOption 2\nOption 3\n";
//        verify(mockPrintStream).println(expectedMenu);
    }

}