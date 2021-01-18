package remaining.subtopics.OverridingAndOverloading;

public class Sum {

    public int sum(int x, int y) {
        return (x + y);
    }

    public int sum(int x, int y, int z) {
        return (x + y + z);
    }

    public double sum(double x, double y) {
        return (x + y);
    }

    public int sum(int... numbers) {
        System.out.println("we have " + numbers.length + "parameters");
        int sum = 0;
        for (int i : numbers)
            sum += i;
        return sum;

    }

    protected double sum(String name, double... numbers) {
        System.out.println(name);
        double sum = 0;
        for (double i : numbers) {
            sum += i;
        }
        return sum;
    }


    public static void main(String args[])
    {
        //To show overloading
        Sum s = new Sum();
        System.out.println(s.sum(10, 20));
        System.out.println(s.sum(10, 20, 30));
        System.out.println(s.sum(10.5, 20.5));
        System.out.println(s.sum(1,2,3,4,5,6));
        System.out.println(s.sum("Ravi",1,1,1,1,1,1,1,1,1,1,1));


    }
}

