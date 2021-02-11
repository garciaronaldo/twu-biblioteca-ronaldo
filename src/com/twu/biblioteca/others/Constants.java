package com.twu.biblioteca.others;
import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final String GREETING_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String MENU_INTRODUCTION = "Please choose an option: ";
    public static final String MENU_LINE = "------------------------------";
    public static final String MENU_FIRST_OPTION_LIST_OF_BOOKS = "1 - List of available books";
    public static final String MENU_SECOND_OPTION_CHECKOUT = "2 - Checkout book";
    public static final String MENU_LAST_OPTION_QUIT = "0 - Quit";
    public static final String MENU_INSERT_BOOK_TITLE_TO_BE_CHECKED_OUT = "Please insert the title of the book you want to check out:";
    public static final String MENU_INVALID_OPTION = "Please select a valid option!";
    public static final String MENU_SUCCESSFUL_CHECKOUT = "Successfully checked out "; //Insert book title in sequence
    public static final String MENU_GOODBYE = "Thanks for using Biblioteca!";

    public static List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("New Moon", "Stephenie Meyer", 2006));
        books.add(new Book("Eclipse", "Stephenie Meyer",2007));
        books.add(new Book("Breaking Dawn", "Stephenie Meyer", 2008));
        books.add(new Book("Midnight Sun", "Stephenie Meyer", 2020));
        books.add(new Book("Iracema", "José de Alencar", 1865));
        books.add(new Book("O Cortiço", "Aluísio Azevedo", 1890));
        books.add(new Book("Vidas Secas", "Graciliano Ramos", 1938));
        books.add(new Book("Feliz Ano Velho", "Marcelo Rubens Paiva", 1982));
        return books;
    }
}
