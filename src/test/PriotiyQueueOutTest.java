package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.time.LocalTime;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import model.Passenger;
import model.PriotiyQueueOut;

public class PriotiyQueueOutTest {

    public PriotiyQueueOut<Passenger> setUpScenario1() {
        PriotiyQueueOut<Passenger> priotiyQueueOut = new  PriotiyQueueOut<>();
        return priotiyQueueOut;

    }
    public PriotiyQueueOut<Passenger> setUpScenario2() {
        PriotiyQueueOut<Passenger> priotiyQueueOut = new  PriotiyQueueOut<>();
        Passenger p1 = new Passenger("Valeria","Ortiz",true,6,50,12345678);
        p1.setTime( LocalTime.of(15, 30, 0));
        Passenger p2 = new Passenger("pipe","bueno",true,22,897,39876543);
        p2.setTime( LocalTime.of(14, 30, 0));
        Passenger p3 = new Passenger("Danielle","marsh",true,7,1111,99999999);
        p3.setTime( LocalTime.of(16, 30, 0));
        priotiyQueueOut.insert(p1);
        priotiyQueueOut.insert(p2);
        priotiyQueueOut.insert(p3);
        return priotiyQueueOut;

    }
    @Test
    void testDelete1() {
        PriotiyQueueOut<Passenger> p= setUpScenario2();
        p.delete();
        assertEquals("name=Daniellename=Valeria",p.printMSg() );
    }
    @Test
    void testDelete2() {
        PriotiyQueueOut<Passenger> p= setUpScenario2();
        p.delete();
        p.delete();
        p.delete();
        assertEquals("",p.printMSg() );
    }

    @Test
    void testDelete3() {
        PriotiyQueueOut<Passenger> p= setUpScenario1();
        try{
            p.delete();
            fail("esta vacio el queue");
        }catch( NoSuchElementException e){
            assertNotNull(e);
        }

    }
    @Test
    void testInsert1() {
        PriotiyQueueOut<Passenger> p= setUpScenario1();
        Passenger p1 = new Passenger("Valeria","Ortiz",true,6,50,12345678);
        p1.setTime( LocalTime.of(15, 30, 0));
        p.insert(p1);
        Passenger p2 = new Passenger("pipe","bueno",true,22,897,39876543);
        p2.setTime( LocalTime.of(15, 30, 0));
        p.insert(p2);

        assertEquals("name=Valerianame=pipe",p.printMSg() );
    }

    @Test
    void testInsert2() {
        PriotiyQueueOut<Passenger> p= setUpScenario2();
        Passenger p1 = new Passenger("Carlos","hernandez",true,22,897,654321789);
        p1.setTime( LocalTime.of(14, 30, 0));
        p.insert(p1);
        Passenger p2 = new Passenger("albert","hernandez",true,7,897,6543289);
        p2.setTime( LocalTime.of(16, 30, 0));
        p.insert(p2);
        assertEquals("name=pipename=Carlosname=Daniellename=Valerianame=albert",p.printMSg() );
    }
    
    @Test
    void testInsert3() {
        PriotiyQueueOut<Passenger> p= setUpScenario2();
        Passenger p1 = new Passenger("Valeria","Ortiz",true,8,50,12345678);
        p1.setTime( LocalTime.of(14, 27, 0));
        p.insert(p1);
        assertEquals("name=Valerianame=pipename=Daniellename=Valeria",p.printMSg());


    }

}
