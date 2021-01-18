package JunitTests;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {

        public static void main(String[] args) {
            Result result = JUnitCore.runClasses(TestLeastFrequentlyUsedCache.class);
            //Result stackTestResult = JUnitCore.runClasses(ImplStackTest.class);

            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }

          //  System.out.println(stackTestResult.wasSuccessful());
//            for (Failure failure : stackTestResult.getFailures()) {
//                System.out.println(failure.toString());
//            }
//
//            System.out.println(stackTestResult.wasSuccessful());
        }
    }


