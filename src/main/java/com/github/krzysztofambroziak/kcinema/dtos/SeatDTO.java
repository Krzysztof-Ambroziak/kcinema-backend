package com.github.krzysztofambroziak.kcinema.dtos;

import java.io.Serializable;

public class SeatDTO implements Serializable {
    public SeatDTO(int row, int number, ReservationType reservationType) {
        this.row = row;
        this.number = number;
        this.reservationType = reservationType;
    }
    
    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public ReservationType getReservationType() {
        return reservationType;
    }
    
    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }
    
    private int row;
    
    private int number;
    
    private ReservationType reservationType;
}
