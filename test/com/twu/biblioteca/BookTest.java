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

public class BookTest {

    protected Book testBook;

    @Before
    public void setUp(){
        testBook = new Book("It", "Stephan King", 1989);
    }

    @Test

    public void testConstructor(){
        assertThat(testBook.toString(), is(String.join(", ","It", "Stephan King", "1989")));
    }


}