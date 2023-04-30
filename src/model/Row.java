package model;

public class Row {

    private int i;

    private PriotiyQueueOut<Passenger> out;

    public Row(int i) {
        this.i = i;
        out= new PriotiyQueueOut<>();
    }

    public void insert(Passenger p){
        out.insert(p);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public PriotiyQueueOut<Passenger> getOut() {
        return out;
    }

    public void setOut(PriotiyQueueOut<Passenger> out) {
        this.out = out;
    }

    public void print(){
        out.print();
    }



}