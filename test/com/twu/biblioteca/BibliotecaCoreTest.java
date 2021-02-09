package com.twu.biblioteca;


import com.twu.biblioteca.others.Constants;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaCoreTest {

    @Test
    public void shouldPrintGreetingMessage() {
        PrintStream printStreamMock = mock(PrintStream.class);
        BibliotecaCore bibliotecaCore = new BibliotecaCore(printStreamMock);

        bibliotecaCore.printGreetingMessage();

        verify(printStreamMock).println(Constants.GREETING_MESSAGE);
    }

    @Test
    public void shouldListAllBooksAfterGreetings(){
        PrintStream printStreamMock = mock(PrintStream.class);
        BibliotecaCore bibliotecaCore = new BibliotecaCore(printStreamMock);

        bibliotecaCore.printBookList();

        List<String> booksTitles = Constants.listBookTitles();
        booksTitles.forEach((String book) -> verify(printStreamMock).println(book));
    }
}
