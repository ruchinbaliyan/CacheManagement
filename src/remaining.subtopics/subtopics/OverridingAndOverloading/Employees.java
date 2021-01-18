package remaining.subtopics.OverridingAndOverloading;

public class Employees {
    int base  =40000;

    public  int getSalary()
    {
        return base;

    }
    static String objective()
    {
        return "overiding concept";

    }

    final String greetings()
    {
        return "Hello";

    }
    private final void MessagePrint()
    {
        System.out.println("message in emp ");
    }

    public void Greet()
    {
        System.out.println("hi ");
        MessagePrint();
    }

    protected  void  Designation()
    {
        System.out.print("tesco:");
    }
}
