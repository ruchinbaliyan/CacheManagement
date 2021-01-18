package remaining.subtopics.exception;

public class StackUnwinding {
                public static void main(String args[]) {
                    try {
                        throwException();
                    } catch (Exception exception) {
                        System.err.println("Exception handled in main");
                        System.err.printf("%s\n\n", exception.getMessage());
                        exception.printStackTrace(); // print exception stack trace

                        StackTraceElement[] traceElements = exception.getStackTrace();
                        System.out.println("\nStack trace from getStackTrace:");
                        System.out.println("Class\t\tFile\t\t\tLine\tMethod");

                        // loop through traceElements to get exception description
                        for (StackTraceElement element : traceElements) {
                            System.out.printf("%s\t", element.getClassName());
                            System.out.printf("%s\t", element.getFileName());
                            System.out.printf("%s\t", element.getLineNumber());
                            System.out.printf("%s\n", element.getMethodName());
                        }
                        System.out.println();
                        System.out.println("using toString (will print className along with detailedMessage");
                        System.out.println(exception.toString());
                        System.out.println();
                        System.out.println("using getMessage will print only the message without classname");
                        System.out.println(exception.getMessage());
                    }
                }

    // throwException throws exception that is not caught in this method
    public  static void throwException() throws Exception {
        try // throw an exception and catch it in main
        {
            System.out.println("Method throwException");
            throw new Exception("testing exception printing ");
        } catch (RuntimeException runtimeException) {
            System.err.println("Exception handled in method throwException");
        } finally {
            System.err.println("Finally is always executed");
        }
    }
}



