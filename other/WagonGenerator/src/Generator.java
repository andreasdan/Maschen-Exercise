import java.util.ArrayList;
import java.util.List;

public class Generator {

    public static void main(String[] args) {
        Cargo cargo = new Cargo();
        Weight weight = new Weight();
        Destination destination = new Destination();
        List<String>list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            cargo.getCargoType();
            weight.getWeightType();
            destination.getDestination();


            list.add(i, cargo.getType() + ", "+ weight.getTypeOfWeight() +", "+ destination.getDest());
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println(list.get(i));
        }


    }
}
