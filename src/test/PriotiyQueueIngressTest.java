package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import model.Passenger;
import model.PriotiyQueueIngress;

public class PriotiyQueueIngressTest {

    public PriotiyQueueIngress<Passenger> setUpScenario1() {
        PriotiyQueueIngress<Passenger> priotiyQueueIngress = new  PriotiyQueueIngress<>();
        return priotiyQueueIngress;

    }
    public PriotiyQueueIngress<Passenger> setUpScenario2() {
        PriotiyQueueIngress<Passenger> priotiyQueueIngress = new  PriotiyQueueIngress<>();
        Passenger p1 = new Passenger("Valeria","Ortiz",true,6,50,12345678);
        Passenger p2 = new Passenger("pipe","bueno",true,22,897,39876543);
        Passenger p3 = new Passenger("Danielle","marsh",true,7,1111,99999999);
        priotiyQueueIngress.insert(p1);
        priotiyQueueIngress.insert(p2);
        priotiyQueueIngress.insert(p3);
        return priotiyQueueIngress;

    }


    @Test
    void testDelete1() {
        PriotiyQueueIngress<Passenger> p= setUpScenario2();
        p.delete();
        assertEquals("name=pipename=Valeria",p.printMSg() );
    }
    @Test
    void testDelete2() {
        PriotiyQueueIngress<Passenger> p= setUpScenario2();
        p.delete();
        p.delete();
        p.delete();
        assertEquals("",p.printMSg() );
    }

    @Test
    void testDelete3() {
        PriotiyQueueIngress<Passenger> p= setUpScenario1();
        try{
            p.delete();
            fail("esta vacio el queue");
        }catch( NoSuchElementException e){
            assertNotNull(e);
        }

    }

    @Test
    void testInsert1() {
        PriotiyQueueIngress<Passenger> p= setUpScenario1();
        Passenger p1 = new Passenger("Valeria","Ortiz",true,6,50,12345678);
        p.insert(p1);
        Passenger p2 = new Passenger("pipe","bueno",true,22,897,39876543);
        p.insert(p2);

        assertEquals("name=pipename=Valeria",p.printMSg() );
    }

    @Test
    void testInsert2() {
        PriotiyQueueIngress<Passenger> p= setUpScenario2();
        Passenger p1 = new Passenger("Carlos","hernandez",true,22,897,654321789);
        p.insert(p1);
        Passenger p2 = new Passenger("albert","hernandez",true,22,897,6543289);
        p.insert(p2);
        assertEquals("name=Daniellename=albertname=pipename=Valerianame=Carlos",p.printMSg() );
    }
    
    @Test
    void testInsert3() {
        PriotiyQueueIngress<Passenger> p= setUpScenario2();
        Passenger p1 = new Passenger("Valeria","Ortiz",true,6,50,12345678);
        p.insert(p1);
        assertEquals("name=Daniellename=Valerianame=pipename=Valeria",p.printMSg());


    }
}
