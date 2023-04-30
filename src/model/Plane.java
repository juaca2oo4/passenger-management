package model;

import java.time.LocalTime;

public class Plane {

    private int number_plane;

    private LocalTime time;

    private int number_seats;

    private int column;

    private int row;

    public Plane(int number_plane, LocalTime time, int number_seats,int column, int row) {
        this.number_plane = number_plane;
        this.time = time;
        this.number_seats = number_seats;
        this.column=column;
        this.row=row;
    }

    public int getNumber_plane() {
        return number_plane;
    }

    public void setNumber_plane(int number_plane) {
        this.number_plane = number_plane;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getNumber_seats() {
        return number_seats;
    }

    public void setNumber_seats(int number_seats) {
        this.number_seats = number_seats;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }



}
