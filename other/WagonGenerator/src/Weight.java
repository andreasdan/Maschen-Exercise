

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Weight {

    private List<String> weightType;

    String typeOfWeight = "";

    public String getTypeOfWeight() {
        return typeOfWeight;
    }

    public void setTypeOfWeight(String typeOfWeight) {
        this.typeOfWeight = typeOfWeight;
    }

    public Weight() {

        weightType = new ArrayList<>(2);

        weightType.add("light");
        weightType.add("medium");
        weightType.add("heavy");
    }

    public String getWeightType() {
        setTypeOfWeight(weightType.get(ThreadLocalRandom.current().nextInt(weightType.size())));
        return getTypeOfWeight();
    }
}
