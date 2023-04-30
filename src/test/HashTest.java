package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import model.HashTable;

import model.Passenger;

import model.PriotiyQueueIngress;
import org.junit.jupiter.api.Test;



public class HashTest {

    public HashTable<String, Passenger> setUpScenario1() {
        HashTable<String, Passenger> hashtable = new  HashTable<>(3);
        return hashtable;
    }

    public HashTable<String, Passenger> setUpScenario2() { // Insert
        HashTable<String, Passenger> hashtable = new HashTable<>(3);
        Passenger p1 = new Passenger("Valeria","Ortiz",true,6,50,12345678);
        Passenger p2 = new Passenger("pipe","bueno",true,22,897,39876543);
        Passenger p3 = new Passenger("Danielle","marsh",true,7,1111,99999999);
        hashtable.insert(p1.getName(), p1);
        hashtable.insert(p2.getName(), p2);
        hashtable.insert(p3.getName(), p3);
        return hashtable;
    }

    @Test
    void testInsert1(){
        HashTable<String, Passenger> h= setUpScenario1();
        Passenger p1 = new Passenger("Valeria","Ortiz",true,6,50,12345678);
        h.insert(p1.getName(), p1);
        assertEquals("name=Valeria, ",h.print());
    }
    @Test
    void testInsert2(){
        HashTable<String, Passenger> h= setUpScenario2(); 
        Passenger p1 = new Passenger("Cole","Min",true,9,1000,11099205);
        h.insert(p1.getName(), p1);
        Passenger p2 = new Passenger("Dani","Ramirez",true,7,1111,99999999);
        h.insert(p2.getName(), p2);
        assertEquals("name=Cole, name=Danielle, name=Valeria, name=pipe, name=Dani, ",h.print());
    }
    @Test
    void testInsert3() {
        HashTable<String, Passenger> h = setUpScenario2();
        Passenger p2 = new Passenger("Danielle","marsh",true,7,1111,99999999);
        Passenger p4 = new Passenger("Danielle","marsh",true,7,1111,99999999);

        h.insert(p2.getName(), p2);
        h.insert(p4.getName(), p4);
        assertEquals("name=Danielle, name=Danielle, name=Danielle, name=Valeria, name=pipe, ",h.print());
    }
    @Test
    public void testRemove3() {
        HashTable<String, Passenger> h = setUpScenario2();
        h.remove("Danielle");
        assertEquals("name=Valeria, name=pipe, ", h.print());
    }
    @Test
    void testRemove2() {
        HashTable<String, Passenger> h = setUpScenario2();
        h.remove("Cole");
        h.remove("pipe");
        h.remove("Danielle");
        h.remove("Valeria");
        assertEquals("", h.print());
    }
    @Test
    void testRemove1() {
        HashTable<String, Passenger> h = setUpScenario1();
        h.remove("Valeria");
        assertEquals("",h.print() );
    }

}