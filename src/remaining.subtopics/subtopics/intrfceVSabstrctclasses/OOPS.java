package remaining.subtopics.intrfceVSabstrctclasses;

interface AdditonalFeatures{
    void powerSteering();
    void GPS();
}
interface AdditonalOffers{
    void warranty();
}


 abstract class  Cars{
     public abstract double price();
     public abstract int getTotalSeat();
     public abstract String colors();

     public String wheel()
     {
         return "4 wheeler";
     }
     public String CheckAC()
     {
         return "AC is available";
     }
     public String CallFacility()
     {
         return "Call Facility  supported";
     }


 }


        class Maruti extends Cars implements AdditonalFeatures{

            @Override
            public double price() {
                return 100;
            }

            @Override
            public int getTotalSeat() {
                return 6;
            }

            @Override
            public String colors() {
                return "Red";
            }

            @Override
            public void powerSteering() {
                System.out.println("Have power steering ");
            }

            @Override
            public void GPS() {
                System.out.println("have GPS");
            }
        }

        class Hyundyi extends  Cars implements AdditonalOffers{

            @Override
            public double price() {
                return 120;
            }

            @Override
            public int getTotalSeat() {
                return 7;
            }

            @Override
            public String colors() {
                return "black";
            }

            @Override
            public void warranty() {
                System.out.println("3 years additonal wararnty");

            }
        }

public class OOPS {
    public static void main(String[] args) {
        Maruti car1 =new Maruti();
        Hyundyi car2 =new Hyundyi();
        car1.powerSteering();
        car2.warranty();



    }
}
