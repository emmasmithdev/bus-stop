import java.util.ArrayList;

public class Bus {

    private String destination;
    private int capacity;
    private ArrayList<Person> passengers;

    public Bus(String destination, int capacity, ArrayList<Person> passengers) {
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = passengers;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }


    public int passengerCount() {
       return this.passengers.size();
    }

    public void addPassenger(Person person) {
        if (this.passengers.size() < this.capacity) {
            this.passengers.add(person);
        }
    }

    public void removePassenger(Person person) {
        this.passengers.remove(person);
    }

    public void pickUpFromBustop(BusStop busStop) {
        Person newPassenger = busStop.leaveQueue();
        addPassenger(newPassenger);
    }
}
