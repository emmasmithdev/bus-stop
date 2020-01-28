import java.util.ArrayList;

public class BusStop {

    private String name;
    private ArrayList<Person> queue;

    public BusStop(String name, ArrayList<Person> queue) {
        this.name = name;
        this.queue = queue;
    }

    public String getName() {
        return name;
    }

    public int queueSize() {
        return this.queue.size();
    }

    public void joinQueue(Person person) {
        this.queue.add(person);
    }

    public Person leaveQueue() {
        return this.queue.remove(0);
    }
}
