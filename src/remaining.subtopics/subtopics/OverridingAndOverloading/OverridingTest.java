package remaining.subtopics.OverridingAndOverloading;


import org.junit.Test;

public class OverridingTest {

    @Test(expected = Exception.class)
    public void TestPriavteMethods()
    {
        Employees emp1 =new Employees();
        Manager emp2 =new Manager();
        emp1.Greet();
        emp2.MessagePrint();


    }





}
