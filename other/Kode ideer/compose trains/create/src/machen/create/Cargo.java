package machen.create;

import java.util.*;



public class Cargo {

    private Random random = new Random();
    String item = "";

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void Cargo() {
        List<String> setCargo = new ArrayList<String>();
        setCargo.add("wood");
        setCargo.add("steel");
        setCargo.add("oil");
        setCargo.add("gasoline");
        setCargo.add("food");
        setCargo.add("cars");
        setCargo.add("general goods");
        for (int i = 0; i < 10; i++){
            getRandomItem(setCargo);
        }
    }

    public void getRandomItem(List<String> setCargo) {

        int index = random.nextInt(setCargo.size());

        System.out.println(setCargo.get(index));
        setItem(setCargo.get(index));
    }
}
