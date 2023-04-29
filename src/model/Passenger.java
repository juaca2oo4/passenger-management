package model;

import java.time.LocalTime;

public class Passenger implements ComparatorPas<Passenger> {

    private String name;

    private String surname;

    private boolean first_class;

    private int asiento;

    private Seat seat;

    private int miles;

    private LocalTime time;

    private int id;

    private int dis;



    public Passenger(String name, String surname, boolean first_class, int asiento, int miles, int id) {
        this.name = name;
        this.surname = surname;
        this.first_class = first_class;
        this.asiento = asiento;
        this.miles = miles;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFirst_class() {
        return first_class;
    }

    public void setFirst_class(boolean first_class) {
        this.first_class = first_class;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public int compareTo1(Passenger otro) {
        if (miles > otro.miles) {
            return -1;
        } else if (miles < otro.miles) {
            return 1;
        } else {
            return 0;
        }
    }

    // comparision order: nombre, edad, ciudad
    @Override

    public int compareTo(Passenger otro) {
        int valu = Integer.compare(this.miles, otro.getMiles());
        if (valu == 0) {
            valu = this.name.compareTo(otro.getName());
        }
        return valu;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "name=" + name;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }


@Override
public int compare(Passenger otro) {
       int valu = Integer.compare(this.dis, otro.getDis());
        if(valu==1){
            return -1;
        }else if(valu==-1){
            return 1;
        }
        if(valu==0){
           valu= Integer.compare(this.time.toSecondOfDay(), otro.getTime().toSecondOfDay());
        }
        return valu;

    }

public int getDis() {
    return dis;
}

public void setDis(int dis) {
    this.dis = dis;
}

public int row(){
    return seat.getRow();
}






}