package com.twu.biblioteca;
import com.twu.biblioteca.books.IBook;
import com.twu.biblioteca.others.Constants;
import org.junit.Test;
import java.io.PrintStream;
import java.util.List;
import static org.mockito.Mockito.*;

public class BibliotecaCoreTest {

    private final List<IBook> books = Constants.getAllBooks();

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

        books.forEach((IBook book) -> verify(printStreamMock).println(book.getBookTitle()));
    }

    @Test
    public void shouldListAllBooksWithAuthorAndPublicationYear(){
        PrintStream printStreamMock = mock(PrintStream.class);
        BibliotecaCore bibliotecaCore = new BibliotecaCore(printStreamMock);

        bibliotecaCore.printAllBooksCompleteInfo();

        books.forEach((IBook book) -> {
            verify(printStreamMock).println(book.getBookTitle());
            verify(printStreamMock, atLeastOnce()).println(book.getBookAuthor());
            verify(printStreamMock, atLeastOnce()).println(book.getBookPublicationYear());
        });
    }
}
