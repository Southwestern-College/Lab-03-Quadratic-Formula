package project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;

public abstract class ConsoleTestBase {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    protected ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUpConsole() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreConsole() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    protected void provideInput(String data) {
        ByteArrayInputStream testInput =
                new ByteArrayInputStream(data.getBytes());
        System.setIn(testInput);
    }

    protected String getOutput() {
        return outputStream.toString();
    }
}