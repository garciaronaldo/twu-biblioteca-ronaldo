package com.twu.biblioteca;

import com.twu.biblioteca.others.Book;
import com.twu.biblioteca.others.Constants;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.List;

import static org.mockito.Mockito.*;

public class BibliotecaCoreTest {

    private final List<Book> books = Constants.getAllBooks();

    @Test
    public void shouldPrintGreetingMessage() {
        PrintStream printStreamMock = mock(PrintStream.class);
        BibliotecaCore bibliotecaCore = new BibliotecaCore(printStreamMock);

        bibliotecaCore.printGreetingMessage();

        verify(printStreamMock).println(Constants.GREETING_MESSAGE);
    }

    @Test
    public void shouldListAllBooks(){
        PrintStream printStreamMock = mock(PrintStream.class);
        BibliotecaCore bibliotecaCore = new BibliotecaCore(printStreamMock);

        bibliotecaCore.printAllBookTitles();

        books.forEach((Book book) -> verify(printStreamMock).println(book.getTitle()));
    }

    @Test
    public void shouldListAllBooksWithAuthorAndPublicationYear(){
        PrintStream printStreamMock = mock(PrintStream.class);
        BibliotecaCore bibliotecaCore = new BibliotecaCore(printStreamMock);

        bibliotecaCore.printAllBooksCompleteInfo();

        books.forEach((Book book) -> {
            verify(printStreamMock).println(book.getTitle());
            verify(printStreamMock, atLeastOnce()).println(book.getAuthor());
            verify(printStreamMock, atLeastOnce()).println(book.getPublicationYear());
        });
    }

    @Test
    public void shouldDisplayMenuWithOptions(){
        PrintStream printStreamMock = mock(PrintStream.class);
        BibliotecaCore bibliotecaCore = new BibliotecaCore(printStreamMock);
        String selectedOption = "1";
        System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));

        bibliotecaCore.printMenu();

        verify(printStreamMock, times(1)).println(Constants.MENU_TITLE);
        verify(printStreamMock, times(1)).println(Constants.MENU_FIRST_OPTION_LIST_OF_BOOKS);
    }

    @Test
    public void shouldShowInvalidOptionMessageInMenu(){
        PrintStream printStreamMock = mock(PrintStream.class);
        BibliotecaCore bibliotecaCore = new BibliotecaCore(printStreamMock);
        String selectedOption = "9\n1";
        System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));

        bibliotecaCore.printMenu();

        verify(printStreamMock, times(1)).println(Constants.MENU_TITLE);
        verify(printStreamMock, times(1)).println(Constants.MENU_FIRST_OPTION_LIST_OF_BOOKS);
        verify(printStreamMock, times(1)).println(Constants.MENU_INVALID_OPTION);
    }
}