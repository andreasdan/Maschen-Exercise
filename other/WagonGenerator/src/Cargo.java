

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Cargo {

    private List<String> cargoType;

    String type = "";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Cargo() {

        cargoType = new ArrayList<>(6);

        cargoType.add("wood");
        cargoType.add("steel");
        cargoType.add("oil");
        cargoType.add("gasoline");
        cargoType.add("food");
        cargoType.add("cars");
        cargoType.add("general goods");
    }

    public String getCargoType() {

        setType(cargoType.get(ThreadLocalRandom.current().nextInt(cargoType.size())));

        return getType();
    }

}
