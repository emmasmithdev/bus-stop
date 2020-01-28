import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private BusStop busStop;
    private Person person;
    private Bus bus;

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
    public void hasName(){
        assertEquals("Renfield St", busStop.getName());
    }

    @Test
    public void queueStartsEmpty(){
        assertEquals(0, busStop.queueSize());
    }

    @Test
    public void canAddPerson(){
        busStop.joinQueue(person);
        assertEquals(1, busStop.queueSize());
    }

    @Test
    public void canRemovePerson(){
        busStop.joinQueue(person);
        busStop.joinQueue(person);
        busStop.leaveQueue();
        assertEquals(1, busStop.queueSize());
    }
}
