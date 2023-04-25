package model;

import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

public class Controller {

    private HashTable<String, Passenger> hashTable;
    private PriotiyQueueIngress<Passenger> arrival_queue_firts_class;
    private Queue<Passenger> arrival_queue_economic_class;

    public Controller() {
        arrival_queue_economic_class = new Queue<>();
        arrival_queue_firts_class = new PriotiyQueueIngress<>();
    }

    public void LoadPassenger(String txt, int count) {
        File file = new File(txt);
        hashTable = new HashTable<>(count);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                Passenger p = new Passenger(parts[0],parts[1], Boolean.parseBoolean(parts[2]), Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]),Integer.parseInt(parts[5]));

                hashTable.insert(parts[5], p);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    public void ArriveP(String txt) {
        File file = new File(txt);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                Passenger p = hashTable.get(parts[0]);
                if (p != null) {
                    p.toString();
                    
                    p.setTime(LocalTime.now());
                  if(p.getTime().isBefore(plane.getTime())){
                    System.out.println("se gano un descuento del 10% para su proximo vuelo");
                  }
                    if (p.isFirst_class()) {
                        arrival_queue_firts_class.insert(p);
        
                    } else {
                        arrival_queue_economic_class.enqueue(p);
                    }
                }
                else{
                    System.out.println("no se encontro");
                }

            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    public void showOrderIngress() {
        arrival_queue_firts_class.print();
        arrival_queue_economic_class.print();
    }

    public void createPlane(int number,String time,int seats){
        LocalTime horaIngreso = LocalTime.parse(time);

        this.plane= new Plane(number, horaIngreso, seats);
        
    }


}


