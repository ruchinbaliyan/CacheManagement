package learnjava.lfu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Logger LOG = LoggerFactory.getLogger(Application.class);
        LOG.info("Cache application has started");
        System.out.println("enter cache size");

        int cacheSize = sc.nextInt();
        LeastFrequentlyUsedCache cache  = new LeastFrequentlyUsedCache(cacheSize);
        String className = cache.getClass().getSimpleName();
        System.out.println("Working with "+className);

        long key,value;
        while(true) {
            System.out.println("1:get ,2:put, 3:exit");
            int choice =sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter key");
                    key = sc.nextLong();
                    System.out.println(cache.getValue(key));
                    break;

                case 2:
                    System.out.println("Enter key and value");
                    key = sc.nextInt();
                    value = sc.nextInt();

                    cache.putValue(key, value);
                    break;
                case 3:
                    System.out.println("enter multiple keys to get their values");
                    ArrayList<Long> list = new ArrayList<>();
                    System.out.println("enter number of keys ");
                    int n;n=sc.nextInt();
                    for(int i=0;i<n;i++)
                    {
                        list.add(sc.nextLong());
                    }

                    List<Long> values= new ArrayList<>();
                    values = cache.getValue(list);

                    for(int i=0;i<list.size();i++)
                    {
                        System.out.println("key:"+list.get(i)+" value:"+values.get(i));

                    }
                    break;


                case 4:
                    System.out.println("Exiting");
                    return;



            }
        }


    }
}
