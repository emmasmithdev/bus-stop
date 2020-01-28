import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private BusStop busStop;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private Bus bus;

    @Before
    public void before(){
        person1 = new Person("Emma");
        person2 = new Person("Paul");
        person3 = new Person("Murray");
        person4 = new Person("Mark");
        person5 = new Person("Debbie");
        ArrayList<Person> passengers = new ArrayList<>();
        passengers.add(person1);
        passengers.add(person2);
        passengers.add(person3);
        passengers.add(person4);
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
        busStop.joinQueue(person5);
        assertEquals(1, busStop.queueSize());
    }

    @Test
    public void canRemovePerson(){
        busStop.joinQueue(person1);
        busStop.joinQueue(person2);
        busStop.joinQueue(person3);
        busStop.leaveQueue(0);
        assertEquals(2, busStop.queueSize());
        assertEquals(person2, busStop.leaveQueue(0));
    }
}
