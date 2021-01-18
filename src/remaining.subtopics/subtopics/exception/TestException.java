package remaining.subtopics.exception;

import org.junit.Test;

public class TestException {
    @Test(expected = ArithmeticException.class)
    public void TestDivideByZeroNoExceptionHandling() {
        RuntimeExceptions.quotient(10, 0);

    }

    @Test
    public void TestStackUnwinding() {

    }


}
