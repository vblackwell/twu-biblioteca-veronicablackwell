package com.twu.biblioteca;


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

/*
 * Author: Veronica Blackwell
 * Paired With: Daisy Arellano and Thalia Estrella
 */

public class BibliotecaAppTest {

    protected BibliotecaApp biblibtest;
    protected ByteArrayOutputStream outputStream;
    protected PrintStream printStream;
    protected List<String> testList;

    @Before
    public void setUp(){
        biblibtest = new BibliotecaApp();
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        testList = Arrays.asList("It", "Harry Potter", "Corazon");

    }

    @Test
    public void shouldWelcome() {
        biblibtest.welcome(printStream);
        assertThat(outputStream.toString(), is("welcome:)\n"));
    }

    @Test
    public void shouldListBooks() {
        biblibtest.listBooks(printStream, testList);
        assertThat(outputStream.toString(), is("It\nHarry Potter\nCorazon\n"));
    }

    @Test
    public void shouldStart(){
        biblibtest.start(printStream, testList);
        assertThat(outputStream.toString(), is("welcome:)\nIt\nHarry Potter\nCorazon\n"));
    }

}
