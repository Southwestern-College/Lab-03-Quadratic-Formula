import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class QuadraticSolverTest extends ConsoleTestBase {

    @ParameterizedTest(name = "a={0}, b={1}, c={2}")
    @CsvSource({
        // two complex solutions
        "1,2,3,two complex solutions,-1.0000,1.4142",

        // one real solution
        "1,2,1,one real solution,-1.0000,0.0000",

        // two real solutions
        "1,3,2,two real solutions,-2.0000,-1.0000"
    })
    void testQuadraticSolver(double a,
                             double b,
                             double c,
                             String solutionType,
                             String expectedRoot1,
                             String expectedRoot2) {

        String input = a + "\n" + b + "\n" + c + "\n";

        String output = runProgram(input,
                () -> QuadraticSolver.main(new String[]{}));

        String normalized = normalize(output);

        // Check solution classification
        assertTrue(normalized.contains(solutionType),
                "\nIncorrect solution classification.\nOutput:\n" + output);

        // Complex case
        if (solutionType.contains("complex")) {

            assertTrue(normalized.contains(expectedRoot1),
                    "\nMissing real part.\nOutput:\n" + output);

            assertTrue(normalized.contains(expectedRoot2),
                    "\nMissing imaginary magnitude.\nOutput:\n" + output);
        }

        // One real root
        else if (solutionType.contains("one real")) {

            assertTrue(normalized.contains(expectedRoot1),
                    "\nIncorrect real root.\nOutput:\n" + output);
        }

        // Two real roots
        else {

            assertTrue(normalized.contains(expectedRoot1),
                    "\nMissing first real root.\nOutput:\n" + output);

            assertTrue(normalized.contains(expectedRoot2),
                    "\nMissing second real root.\nOutput:\n" + output);
        }
    }

    private String normalize(String s) {
        return s.replace("\r", "")
                .replaceAll("\\s+", " ")
                .trim();
    }
}
