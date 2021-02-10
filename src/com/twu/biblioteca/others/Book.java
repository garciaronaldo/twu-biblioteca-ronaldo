package com.twu.biblioteca.others;

public class Book {
    private String Title;
    private String Author;
    private int PublicationYear;

    public Book(String title, String author, int publicationYear){
        setTitle(title);
        setAuthor(author);
        setPublicationYear(publicationYear);
    }
    public void setTitle(String title){
        this.Title = title;
    }

    public void setAuthor(String author){
        this.Author = author;
    }

    public void setPublicationYear(int year){
        this.PublicationYear = year;
    }

    public String getTitle(){
        return Title;
    }

    public String getAuthor(){
        return Author;
    }

    public int getPublicationYear(){
        return PublicationYear;
    }
}
