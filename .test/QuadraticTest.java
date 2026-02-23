package project;

import java.io.*;
import java.util.Scanner;

public class QuadraticTest {
    public static void main(String[] args) throws IOException {
        int numberOfTests = 4;
        Scanner input = new Scanner(new File("quadratic-input.txt"));
        input.useDelimiter("//Z");
        String read = input.next();

        for (int i = 0; i < numberOfTests; i++) {
            System.out.printf("%n**************** Test %d ****************%n", i);
            InputStream stream = new ByteArrayInputStream(read.getBytes());
            stream.skip(9*i);
            System.setIn(stream);
            QuadraticSolver.main(null);
        }
    }
}
