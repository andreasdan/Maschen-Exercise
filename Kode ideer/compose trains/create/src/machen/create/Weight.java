package machen.create;
import java.util.*;

public class Weight {

    private Random random = new Random();


    String item = "";

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;


    }

    public void Weight() {



        List<String> setWeight = new ArrayList<>();

        setWeight.add("light");
        setWeight.add("medium");
        setWeight.add("heavy");

        for (int i = 0; i < 10; i++){
            getRandomItem(setWeight);


        }
    }

    public void getRandomItem(List<String> setWeight) {

        int index = random.nextInt(setWeight.size());

        System.out.println(setWeight.get(index));
        setItem(setWeight.get(index));



    }
}

