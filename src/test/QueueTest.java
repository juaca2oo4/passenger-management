package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.EmptyStackException;

import org.junit.Test;

import junit.framework.TestCase;
import model.Passenger;
import model.Queue;

public class QueueTest {

    public Queue<Passenger> setUpScenario2() {
        Passenger p1 = new Passenger("Santiago", "Hernandez", false, 6, 100, 105362267);
        Passenger p2 = new Passenger("Sergio", "florez", false, 15, 1000, 654321789);
        Queue<Passenger> queue = new Queue<>();
        queue.enqueue(p1);
        queue.enqueue(p2);
        return queue;
    }

    public Queue<Passenger> setUpScenario1() {
        Queue<Passenger> queue = new Queue<>();
        return queue;

    }

    @Test
    public void testEnqueue1() {
        Queue<Passenger> q = setUpScenario1();
        Passenger p1 = new Passenger("Santiago", "Hernandez", false, 6, 100, 105362267);
        q.enqueue(p1);
        assertEquals("name=Santiago", q.printMSg());

    }

    @Test
    public void testEnqueue2() {
        Queue<Passenger> q = setUpScenario2();
        Passenger p1 = new Passenger("Santiago", "Hernandez", false, 6, 100, 105362267);
        Passenger p2 = new Passenger("Sergio", "florez", false, 15, 1000, 654321789);
        q.enqueue(p2);
        q.enqueue(p1);
        assertEquals("name=Santiagoname=Sergioname=Sergioname=Santiago", q.printMSg());

    }

    @Test
    public void testEnqueue3() {
        Queue<Passenger> q = setUpScenario1();
        Passenger p2 = new Passenger("Sergio", "florez", false, 15, 1000, 654321789);
        q.enqueue(p2);
        assertEquals("name=Sergio", q.printMSg());

    }

    @Test
    public void tesDequeue1() {
        Queue<Passenger> q = setUpScenario2();
        Passenger x = q.dequeue();
        assertEquals("Santiago", x.getName());

    }

    @Test
    public void testDequeue2() {
        Queue<Passenger> q = setUpScenario2();
        Passenger x1 = q.dequeue();
        Passenger x2 = q.dequeue();
        assertEquals("SantiagoSergio", x1.getName() + x2.getName());
    }

    @Test
    public void testDequeue3() {
        Queue<Passenger> q = setUpScenario1();
        try {
            q.dequeue();
            fail("esta vacio el queeue");
        } catch (EmptyStackException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testPeek1() {
        Queue<Passenger> q = setUpScenario2();
        Passenger x1 = q.peek();
        assertEquals("Santiago", x1.getName());
    }
    @Test
    public void testPeek2() {
        Queue<Passenger> q = setUpScenario2();
        Passenger x1 = q.peek();
        Passenger x2 = q.peek();
        assertEquals("SantiagoSantiago", x1.getName() + x2.getName());
    }
    
    @Test
    public void testPeek3() {
        Queue<Passenger> q = setUpScenario1();
        try {
            q.peek();
            fail("esta vacio el queeue");
        } catch (EmptyStackException e) {
            assertNotNull(e);
        }
    }
}
