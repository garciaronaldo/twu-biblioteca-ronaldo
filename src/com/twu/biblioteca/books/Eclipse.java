package com.twu.biblioteca.books;

public class Eclipse implements IBook {
    public String getBookTitle() {
        return "Eclipse";
    }

    public String getBookAuthor() {
        return "Stephenie Meyer";
    }

    public int getBookPublicationYear() {
        return 2007;
    }
}
