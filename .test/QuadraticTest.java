import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class QuadraticTest {

    @ParameterizedTest(name = "a={0}, b={1}, c={2}")
    @CsvSource({
        "1, 2, 1, 'x = -1.0000'",
        "1, 3, 2, 'x_1 = -2.0000|x_2 = -1.0000'",
        "1, 2, 3, 'x_1 = -1.0000 + 1.4142i|x_2 = -1.0000 - 1.4142i'"
    })
    void testQuadraticSolverSolutionsOnly(
            double a,
            double b,
            double c,
            String expectedSolutions) {

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        String simulatedInput = String.format("%.0f%n%.0f%n%.0f%n", a, b, c);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(outputStream));

            QuadraticSolver.main(null);

            String actualOutput = normalize(outputStream.toString());

            for (String expectedSolution : expectedSolutions.split("\\|")) {
                assertTrue(
                        actualOutput.contains(expectedSolution),
                        () -> "Expected output to contain: " + expectedSolution
                                + System.lineSeparator()
                                + "Actual output was:"
                                + System.lineSeparator()
                                + actualOutput
                );
            }

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    private String normalize(String text) {
        return text.replace("\r\n", "\n")
                .replace("\r", "\n")
                .replace("−", "-")
                .replace("–", "-")
                .trim();
    }
}
