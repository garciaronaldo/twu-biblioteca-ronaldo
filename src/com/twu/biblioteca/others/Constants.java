package com.twu.biblioteca.others;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static String GREETING_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public static List<String> listBookTitles(){
        List<String> books = new ArrayList<>();
        books.add("Twilight");
        books.add("New Moon");
        books.add("Eclipse");
        books.add("Breaking Dawn");
        books.add("Iracema");
        books.add("O Cortico");
        books.add("Vidas Secas");
        books.add("Feliz Ano Velho");
        return books;
    }
}
