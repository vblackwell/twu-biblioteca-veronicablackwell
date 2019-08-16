package com.twu.biblioteca;


import com.twu.biblioteca.BibliotecaApp;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    @Test
    public void test() {
        BibliotecaApp biblibtest = new BibliotecaApp();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        biblibtest.run(printStream);

        assertThat(outputStream.toString(), is("welcome:)"));
    }

    @Test
    public void test1() {
        BibliotecaApp biblibtest = new BibliotecaApp();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        List<String> testList = Arrays.asList("Mockingbird", "1994", "The Hobbit");

        biblibtest.runList(printStream, testList);

        assertThat(outputStream.toString(), is("Mockingbird\n1994\nThe Hobbit\n"));
    }
}
