package remaining.subtopics.OverridingAndOverloading;

public class Tester extends Employees{
    @Override
    public int getSalary()
    {
        return base+5000;

    }
    @Override
    public void Designation()
    {
        super.Designation();
        System.out.println("tester");

    }
}
