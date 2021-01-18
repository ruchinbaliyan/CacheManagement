package remaining.subtopics.OverridingAndOverloading;

public class Manager extends Employees {
    @Override
    public int getSalary()
    {
        return base+10000;

    }
    @Override
    public void Designation()
    {
        super.Designation();
        System.out.println("manager");

    }

    public void MessagePrint()
    {
        System.out.println("meesage in manager ");
    }

    public void Greet()
    {

    }
}
