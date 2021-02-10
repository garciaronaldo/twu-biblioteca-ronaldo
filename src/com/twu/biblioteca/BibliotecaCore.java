package com.twu.biblioteca;

import com.twu.biblioteca.others.Book;
import com.twu.biblioteca.others.Constants;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class BibliotecaCore {
    private final PrintStream printStream;
    private final List<Book> books;

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
        printMenuIntroduction();
        showMenuOptions(new Scanner(System.in));
    }

    public void printAllBookTitles() {
        books.forEach((Book book) -> printStream.println(book.getTitle()));
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

    private void printMenuIntroduction() {
        printStream.println(Constants.MENU_TITLE);
        printStream.println(Constants.MENU_LINE);
        printStream.println(Constants.MENU_FIRST_OPTION_LIST_OF_BOOKS);
        printStream.print(Constants.MENU_QUIT_OPTION);
    }

    private void showMenuOptions(Scanner input) {
        int choice = input.nextInt();

        switch (choice){
            case 1:
                printAllBookTitles();
                break;
            case 0:
                printStream.println(Constants.MENU_GOODBYE);
                break;
            default:
                printStream.println(Constants.MENU_INVALID_OPTION);
                showMenuOptions(input);
        }
    }
}
