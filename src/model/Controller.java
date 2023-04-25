package model;

public class Controller {

    private HashTable<String, Passenger> hashTable;

    public Controller() {

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
                Passenger p = new Passenger(parts[0], Boolean.parseBoolean(parts[1]), Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]));

                hashTable.insert(parts[0], p);
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
                        //premiar de alguna manera a estos manes
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


}


