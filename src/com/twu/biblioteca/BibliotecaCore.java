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
        startMenu();
    }

    public void printGreetingMessage(){
        printStream.println(Constants.GREETING_MESSAGE);
    }

    public void startMenu() {
        this.input = new Scanner(System.in);
        printMenu();
    }

    public void printMenu() {
        printAllMenuOptions();
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
        printStream.println(Constants.MENU_THIRD_OPTION_RETURN);
        printStream.println(Constants.MENU_LAST_OPTION_QUIT);
    }

    private void chooseOptions() {
        int choice = input.nextInt();

        switch (choice){
            case 1:
                printAllAvailableBookTitles();
                break;
            case 2:
                printStream.println(Constants.MENU_INSERT_BOOK_TITLE_TO_BE_CHECKED_OUT);
                checkoutBook();
                break;
            case 3:
                printStream.println(Constants.MENU_INSERT_BOOK_TITLE_TO_BE_RETURNED);
                returnBook();
                break;
            case 0:
                printStream.println(Constants.MENU_GOODBYE);
                return;
            default:
                printStream.println(Constants.MENU_INVALID_OPTION);
        }
        shouldContinueAfterChoosingAnOption();
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
        printStream.println(Constants.MENU_UNAVAILABLE_BOOK_FOR_CHECK_OUT);
    }

    private void returnBook() {
        input.nextLine();
        String bookTitleToBeReturned = input.nextLine();
        for(Book book : books){
            if(book.getTitle().equals(bookTitleToBeReturned) && !book.isBookAvailable()){
                book.checkOutBook();
                printStream.println(Constants.MENU_SUCCESSFUL_RETURN + book.getTitle());
                printStream.println(Constants.MENU_POST_RETURN_MESSAGE);
                break;
            }
        }
        printStream.println(Constants.MENU_NOT_VALID_BOOK_FOR_RETURN);
    }

    private void shouldContinueAfterChoosingAnOption() {
        printStream.println(Constants.MENU_CONTINUE);
        boolean newChoice = input.nextBoolean();
        if(newChoice == true){
            printMenu();
        }
        else{
            printStream.println(Constants.MENU_GOODBYE);
            return;
        }
    }
}
