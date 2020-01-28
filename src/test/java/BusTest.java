import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private BusStop busStop;

    @Before
    public void before(){
        person1 = new Person("Ally");
        person2 = new Person("Anna");
        person3 = new Person("Colin");
        person4 = new Person("Lindsey");
        ArrayList<Person> passengers = new ArrayList<>();
        passengers.add(person1);
        passengers.add(person2);
        passengers.add(person1);
        passengers.add(person2);
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
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        bus.addPassenger(person1);
        assertEquals(7, bus.passengerCount());
    }

    @Test
    public void busFull(){
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        bus.addPassenger(person1);
        assertEquals(10, bus.passengerCount());
    }

    @Test
    public void canRemovePassenger(){
        bus.removePassenger(person1);
        assertEquals(3, bus.passengerCount());
    }

    @Test
    public void canPickupPassengerFromQueue(){
        busStop.joinQueue(person3);
        busStop.joinQueue(person4);
        bus.pickUpFromBuStop(busStop);
        assertEquals(1, busStop.queueSize());
        assertEquals(5, bus.passengerCount());

    }


}
