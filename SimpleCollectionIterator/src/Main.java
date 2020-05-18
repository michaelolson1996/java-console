import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Automobile car = new Automobile("car", 100);
        Automobile truck = new Automobile("truck", 200);
        Automobile suv = new Automobile("suv", 150);

        Collection<Automobile> automobiles = new ArrayList<>();
        automobiles.add(car);
        automobiles.add(suv);
        automobiles.add(truck);

        for (Automobile automobile : automobiles)
        {
            System.out.println(automobile);
        }

        System.out.println("\n\n");
        System.out.println("Iterator removal\n");
        Iterator<Automobile> automobileIterator = automobiles.iterator();

        while (automobileIterator.hasNext())
        {
            Automobile automobile = automobileIterator.next();
            if (automobile.getWeight() > 130)
            {
                System.out.println(automobile);
            }
            else
            {
                automobileIterator.remove();
            }
        }

        System.out.println(automobiles);

        System.out.println("\n\n");

        System.out.println("Car is in the ArrayList : " + automobiles.contains(car));

    }
}
