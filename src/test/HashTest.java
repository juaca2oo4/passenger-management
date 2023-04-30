package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import model.HashTable;

import model.Passenger;

import org.junit.jupiter.api.Test;



public class HashTest {

    public HashTable<String, Passenger> SetUpScenario1() {
        HashTable<String, Passenger> hashtable = new  HashTable<>(3);
        return hashtable;
    }

    public HashTable<String, Passenger> SetUpScenario2() { // Insert
        HashTable<String, Passenger> hashtable = new HashTable<>(3);
        Passenger p1 = new Passenger("Valeria","Ortiz",true,6,50,12345678);
        Passenger p2 = new Passenger("pipe","bueno",true,22,897,39876543);
        Passenger p3 = new Passenger("Danielle","marsh",true,7,1111,99999999);
        hashtable.insert(p1.getName(), p1);
        hashtable.insert(p2.getName(), p2);
        hashtable.insert(p3.getName(), p3);
        return hashtable;
    }

    public HashTable<String, Passenger> setUpScenario3(){ //Remove
        HashTable<String, Passenger> hashtable = new HashTable<>(3);
        Passenger p1 = new Passenger("Alice", "Smith", true, 1, 1000, 13475098);
        Passenger p2 = new Passenger("Bob", "Johnson", false, 2, 2000, 22094628);
        Passenger p3 = new Passenger("Cole", "Min", true, 9, 1000,11099205);

        hashtable.insert(p1.getName(), p1);
        hashtable.insert(p2.getName(), p2);
        hashtable.insert(p3.getName(), p3);

        hashtable.remove("Bob");
        return hashtable;
    }

    public HashTable<String, Passenger> setUpScenario4() { //isEmpty
        HashTable<String, Passenger> hashtable = new HashTable<>(3);
        Passenger p1 = new Passenger("Alice", "Smith", true, 1, 1000, 13475098);
        Passenger p2 = new Passenger("Bob", "Johnson", false, 2, 2000, 22094628);
        Passenger p3 = new Passenger("Cole", "Min", true, 9, 1000, 11099205);

        hashtable.insert(p1.getName(), p1);
        hashtable.insert(p2.getName(), p2);
        hashtable.insert(p3.getName(), p3);

        String expectedOutput = "name=Alice, name=Bob, name=Cole";
        String actualOutput = hashtable.print();
        return hashtable;
    }
}