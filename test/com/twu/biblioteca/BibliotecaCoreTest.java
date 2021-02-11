package com.twu.biblioteca;

import com.twu.biblioteca.others.Book;
import com.twu.biblioteca.others.Constants;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.List;

import static org.mockito.Mockito.*;

public class BibliotecaCoreTest {

    private final List<Book> books = Constants.getAllBooks();
    private PrintStream printStreamMock;
    private BibliotecaCore bibliotecaCore;

    @Before
    public void setUp(){
        this.printStreamMock = mock(PrintStream.class);
        this.bibliotecaCore = new BibliotecaCore(printStreamMock);
    }

    @Test
    public void shouldPrintGreetingMessage() {
        bibliotecaCore.printGreetingMessage();

        verify(printStreamMock).println(Constants.GREETING_MESSAGE);
    }

    @Test
    public void shouldListAllBooks(){
        bibliotecaCore.printAllAvailableBookTitles();

        books.forEach(book -> verify(printStreamMock).println(book.getTitle()));
    }

    @Test
    public void shouldListAllBooksWithAuthorAndPublicationYear(){
        bibliotecaCore.printAllBooksCompleteInfo();

        books.forEach(book -> {
            verify(printStreamMock).println(book.getTitle());
            verify(printStreamMock, atLeastOnce()).println(book.getAuthor());
            verify(printStreamMock, atLeastOnce()).println(book.getPublicationYear());
        });
    }

    @Test
    public void shouldDisplayMenuWithOptions(){
        String selectedOption = "0";
        System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));

        bibliotecaCore.startBiblioteca();

        verify(printStreamMock, times(1)).println(Constants.MENU_INTRODUCTION);
        verify(printStreamMock, times(1)).println(Constants.MENU_FIRST_OPTION_LIST_OF_BOOKS);
        verify(printStreamMock, times(1)).println(Constants.MENU_SECOND_OPTION_CHECKOUT);
        verify(printStreamMock, times(1)).println(Constants.MENU_LAST_OPTION_QUIT);
    }

    @Test
    public void shouldShowInvalidOptionMessageInMenu(){
        String selectedOption = "9\nTrue\n0";
        System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));

        bibliotecaCore.startBiblioteca();

        verify(printStreamMock, times(2)).println(Constants.MENU_INTRODUCTION);
        verify(printStreamMock, times(2)).println(Constants.MENU_FIRST_OPTION_LIST_OF_BOOKS);
        verify(printStreamMock, times(1)).println(Constants.MENU_INVALID_OPTION);
    }

    @Test
    public void shouldQuitWhenQuitOptionIsSelected(){
        String selectedOption = "0";
        System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));

        bibliotecaCore.startBiblioteca();

        verify(printStreamMock).println(Constants.MENU_INTRODUCTION);
        verify(printStreamMock).println(Constants.MENU_LAST_OPTION_QUIT);
        verify(printStreamMock).println(Constants.MENU_GOODBYE);
    }

    @Test
    public void shouldCheckoutBook(){
        String selectedOption = "2\nTwilight\nFalse";
        System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));

        bibliotecaCore.startBiblioteca();

        verify(printStreamMock, times(1)).println(Constants.MENU_INTRODUCTION);
        verify(printStreamMock, times(1)).println(Constants.MENU_SECOND_OPTION_CHECKOUT);
        verify(printStreamMock, times(1)).println(Constants.MENU_INSERT_BOOK_TITLE_TO_BE_CHECKED_OUT);
        verify(printStreamMock, times(1)).println(Constants.MENU_SUCCESSFUL_CHECKOUT + "Twilight");
    }

    @Test
    public void shouldPrintMessageAfterBookCheckout(){
        String selectedOption = "2\nTwilight\nFalse";
        System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));

        bibliotecaCore.startBiblioteca();

        verify(printStreamMock, times(1)).println(Constants.MENU_INTRODUCTION);
        verify(printStreamMock, times(1)).println(Constants.MENU_SECOND_OPTION_CHECKOUT);
        verify(printStreamMock, times(1)).println(Constants.MENU_INSERT_BOOK_TITLE_TO_BE_CHECKED_OUT);
        verify(printStreamMock, times(1)).println(Constants.MENU_SUCCESSFUL_CHECKOUT + "Twilight");
        verify(printStreamMock, times(1)).println(Constants.MENU_POST_CHECKOUT_MESSAGE);
    }

    @Test
    public void shouldPrintWarningMessageWhenBookIsNotAvailableForCheckout(){
        String selectedOption = "2\nHarry Potter\nFalse";
        System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));

        bibliotecaCore.startBiblioteca();

        verify(printStreamMock, times(1)).println(Constants.MENU_INTRODUCTION);
        verify(printStreamMock, times(1)).println(Constants.MENU_SECOND_OPTION_CHECKOUT);
        verify(printStreamMock, times(1)).println(Constants.MENU_INSERT_BOOK_TITLE_TO_BE_CHECKED_OUT);
        verify(printStreamMock, times(1)).println(Constants.MENU_UNAVAILABLE_BOOK);
    }

    @Test
    public void shouldReturnBook(){
        String selectedOption = "2\nIracema\nTrue\n3\nIracema\nFalse";
        System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));

        bibliotecaCore.startBiblioteca();

        verify(printStreamMock, times(2)).println(Constants.MENU_INTRODUCTION);
        verify(printStreamMock, times(2)).println(Constants.MENU_SECOND_OPTION_CHECKOUT);
        verify(printStreamMock, times(2)).println(Constants.MENU_THIRD_OPTION_RETURN);
        verify(printStreamMock, times(1)).println(Constants.MENU_INSERT_BOOK_TITLE_TO_BE_CHECKED_OUT);
        verify(printStreamMock, times(1)).println(Constants.MENU_SUCCESSFUL_CHECKOUT + "Iracema");
        verify(printStreamMock, times(1)).println(Constants.MENU_SUCCESSFUL_RETURN + "Iracema");
    }
}