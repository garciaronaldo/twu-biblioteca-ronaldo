package com.twu.biblioteca;

import com.twu.biblioteca.books.IBook;
import com.twu.biblioteca.others.Constants;

import java.io.PrintStream;
import java.util.List;

public class BibliotecaCore {
    private final PrintStream printStream;
    private final List<IBook> books;

    public BibliotecaCore(PrintStream printStream){
        this.printStream = printStream;
        books = Constants.getAllBooks();
    }

    public void printGreetingMessage(){
        printStream.println(Constants.GREETING_MESSAGE);
    }

    public void printAllBookTitles() {
        books.forEach((IBook book) -> printStream.println(book.getBookTitle()));
        printStream.println("\n");
    }

    public void printAllBooksCompleteInfo() {
        books.forEach((IBook book) -> {
                    printStream.println(book.getBookTitle());
                    printStream.println(book.getBookAuthor());
                    printStream.println(book.getBookPublicationYear());
                    printStream.println("\n");
                });
    }
}
