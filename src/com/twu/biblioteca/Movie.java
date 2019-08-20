package com.twu.biblioteca;

public class Movie {
    protected String title;
    protected String director;
    protected int year;
    protected String rating;

    public Movie(final String title, final String director, final int year, final String rating){
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString(){
        return String.join(", ",
                title,
                director,
                Integer.toString(year),
                rating);
    }
}
