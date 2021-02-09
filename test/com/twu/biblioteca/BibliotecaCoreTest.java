package com.twu.biblioteca;


import com.twu.biblioteca.others.Constants;
import org.junit.Test;
import java.io.PrintStream;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    @Test
    public void shouldPrintGreetingMessage() {
        PrintStream printStreamMock = mock(PrintStream.class);
        BibliotecaCore bibliotecaCore = new BibliotecaCore(printStreamMock);
        bibliotecaCore.printGreetingMessage();
        verify(printStreamMock).println(Constants.GREETING_MESSAGE);
    }

    @Test
    public void shouldListAllBooksAfterGreetings(){

    }
}
