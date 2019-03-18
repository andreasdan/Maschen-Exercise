
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Destination {

    private List<String> destination;

    String dest = "";

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public Destination() {
        destination = new ArrayList<>(11);

        destination.add("Hamburg Harbour");
        destination.add("Scandinavia");
        destination.add("Duisburg");
        destination.add("K�ln");
        destination.add("Stuttgart");
        destination.add("Frankfurt");
        destination.add("Kassel");
        destination.add("Hannover");
        destination.add("Berlin");
        destination.add("Leipzig");
        destination.add("N�rnberg");
        destination.add("Munich");
    }

    public String getDestination() {
        setDest(destination.get(ThreadLocalRandom.current().nextInt(destination.size())));
        return getDest();
    }
}
