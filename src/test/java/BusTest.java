import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person;
    private BusStop busStop;

    @Before
    public void before(){
        person = new Person();
        ArrayList<Person> passengers = new ArrayList<>();
        passengers.add(person);
        passengers.add(person);
        passengers.add(person);
        passengers.add(person);
        bus = new Bus("Glasgow", 10, passengers);
        ArrayList<Person> queue = new ArrayList<>();
        busStop = new BusStop("Renfield St", queue);
    }

    @Test
    public void hasDestination(){
        assertEquals("Glasgow", bus.getDestination());
    }

    @Test
    public void passengerCount(){
        assertEquals(4, bus.passengerCount());
    }

    @Test
    public void canAddPassenger(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(7, bus.passengerCount());
    }

    @Test
    public void busFull(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(10, bus.passengerCount());
    }

    @Test
    public void canRemovePassenger(){
        bus.removePassenger(person);
        assertEquals(3, bus.passengerCount());
    }

    @Test
    public void canPickupPassengerFromQueue(){
        busStop.joinQueue(person);
        busStop.joinQueue(person);
        bus.pickUpFromBustop(busStop);
        assertEquals(1, busStop.queueSize());
        assertEquals(5, bus.passengerCount());
    }


}
