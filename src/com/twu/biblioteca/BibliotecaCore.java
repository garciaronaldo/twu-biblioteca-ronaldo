package com.twu.biblioteca;

import com.twu.biblioteca.others.Constants;

import java.io.PrintStream;

public class BibliotecaCore {
    private final PrintStream printStream;

    public BibliotecaCore(PrintStream printStream){
        this.printStream = printStream;
    }

    public void printGreetingMessage(){
        printStream.println(Constants.GREETING_MESSAGE);
    }
}
