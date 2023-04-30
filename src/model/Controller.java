package model;

import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

public class Controller {

    private HashTable<String, Passenger> hashTable;
    private PriotiyQueueIngress<Passenger> arrival_queue_firts_class;
    private Queue<Passenger> arrival_queue_economic_class;
    private Plane plane;
    private ArrayList<Row> out;

    public Controller() {
        plane = new Plane(3623, LocalTime.of(10, 00, 0), 36, 6, 6);
        arrival_queue_economic_class = new Queue<>();
        arrival_queue_firts_class = new PriotiyQueueIngress<>();
        out = new ArrayList<>();
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

                int fila = (Integer.parseInt(parts[3]) - 1) / plane.getColumn() + 1;
                int columna = (Integer.parseInt(parts[3]) - 1) % plane.getColumn() + 1;
                p.setSeat(new Seat(columna, fila));

                int p1Dist = Math.min(p.getSeat().getColumn(), plane.getColumn() - p.getSeat().getColumn() + 1);
                p.setDis(p1Dist);

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
        OutArray();
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
                    LocalTime horaIngreso = LocalTime.parse(parts[1]);
                    p.setTime(horaIngreso);
                    if (p.getTime().isBefore(plane.getTime())) {
                        System.out.println(p.getName() + " se gano un descuento del 10% para su proximo vuelo");
                    }
                    if (p.isFirst_class()) {
                        arrival_queue_firts_class.insert(p);
                        out.get(p.row()-1).insert(p);

                    } else {
                        arrival_queue_economic_class.enqueue(p);
                        out.get(p.row()-1).insert(p);

                    }
                } else {
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
        System.out.println("primera clase");
        arrival_queue_firts_class.print();
        System.out.println("clase economica");
        arrival_queue_economic_class.print();
    }



    public boolean IngressEmpty() {
        if (arrival_queue_economic_class.isEmpty() && arrival_queue_firts_class.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean HashEmpty() {
        return hashTable.isEmpty();
    }

    public void OutArray(){
       for(int i=1;i<=plane.getRow();i++){
         Row s= new Row(i);
         out.add(s);
       }
    }

    public void Out(){
        for(int i=0;i<plane.getRow();i++){
          out.get(i).print();
        }
     }




}
