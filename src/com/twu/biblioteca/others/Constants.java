package com.twu.biblioteca.others;
import com.twu.biblioteca.books.*;
import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static String GREETING_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public static List<IBook> getAllBooks(){
        List<IBook> books = new ArrayList<>();
        books.add(new Twilight());
        books.add(new NewMoon());
        books.add(new Eclipse());
        books.add(new BreakingDawn());
        books.add(new MidnightSun());
        books.add(new Iracema());
        books.add(new OCortico());
        books.add(new VidasSecas());
        books.add(new FelizAnoVelho());
        return books;
    }
}
