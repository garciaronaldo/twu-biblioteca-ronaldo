package com.twu.biblioteca;

import com.twu.biblioteca.others.Book;
import com.twu.biblioteca.others.Constants;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class BibliotecaCore {
    private final PrintStream printStream;
    private final List<Book> books;
    private Scanner input;

    public BibliotecaCore(PrintStream printStream){
        this.printStream = printStream;
        books = Constants.getAllBooks();
    }

    public void startBiblioteca(){
        printGreetingMessage();
        printMenu();
    }

    public void printGreetingMessage(){
        printStream.println(Constants.GREETING_MESSAGE);
    }

    public void printMenu() {
        printAllMenuOptions();
        this.input = new Scanner(System.in);
        chooseOptions();
    }

    public void printAllAvailableBookTitles() {
        books.forEach(
                    book -> {
                        if(book.isBookAvailable()){
                            printStream.println(book.getTitle());
                        }}
        );
        printStream.println("\n");
    }

    public void printAllBooksCompleteInfo() {
        books.forEach((Book book) -> {
                    printStream.println(book.getTitle());
                    printStream.println(book.getAuthor());
                    printStream.println(book.getPublicationYear());
                    printStream.println("\n");
                });
    }

    private void printAllMenuOptions() {
        printStream.println(Constants.MENU_INTRODUCTION);
        printStream.println(Constants.MENU_LINE);
        printStream.println(Constants.MENU_FIRST_OPTION_LIST_OF_BOOKS);
        printStream.println(Constants.MENU_SECOND_OPTION_CHECKOUT);
        printStream.println(Constants.MENU_LAST_OPTION_QUIT);
    }

    private void chooseOptions() {
        int choice = input.nextInt();

        switch (choice){
            case 1:
                printAllAvailableBookTitles();
                printAllMenuOptions();
                chooseOptions();
            case 2:
                printStream.println(Constants.MENU_INSERT_BOOK_TITLE_TO_BE_CHECKED_OUT);
                checkoutBook();
                break;
            case 0:
                printStream.println(Constants.MENU_GOODBYE);
                break;
            default:
                printStream.println(Constants.MENU_INVALID_OPTION);
                chooseOptions();
        }
    }

    private void checkoutBook() {
        input.nextLine();
        String bookTitleToBeCheckedOut = input.nextLine();
        for(Book book : books){
            if(book.getTitle().equals(bookTitleToBeCheckedOut) && book.isBookAvailable()){
                book.checkOutBook();
                printStream.println(Constants.MENU_SUCCESSFUL_CHECKOUT + book.getTitle());
                printStream.println(Constants.MENU_POST_CHECKOUT_MESSAGE);
                return;
            }
        }
        printStream.println(Constants.MENU_UNAVAILABLE_BOOK);
    }
}
