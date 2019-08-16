package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int pubYear;

    public Book(final String title, final String author, final int pubYear){
        this.title = title;
        this.author = author;
        this.pubYear = pubYear;
    }

    @Override
    public String toString(){
        return String.join(", ",
                title,
                author,
                Integer.toString(pubYear));
    }

}
