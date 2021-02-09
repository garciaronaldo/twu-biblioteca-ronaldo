package com.twu.biblioteca;

import com.twu.biblioteca.others.Constants;

import java.io.PrintStream;
import java.util.List;

public class BibliotecaCore {
    private final PrintStream printStream;

    public BibliotecaCore(PrintStream printStream){
        this.printStream = printStream;
    }

    public void printGreetingMessage(){
        printStream.println(Constants.GREETING_MESSAGE);
    }

    public void printBookList() {
        List<String> bookTitles = Constants.listBookTitles();
        bookTitles.forEach((String book) -> printStream.println(book));
    }
}
