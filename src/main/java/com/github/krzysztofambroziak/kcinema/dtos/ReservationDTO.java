package com.github.krzysztofambroziak.kcinema.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReservationDTO implements Serializable {
    public List<SeatDTO> getSeatDTOS() {
        return seatDTOS;
    }
    
    public void addSeat(SeatDTO seatDTO) {
        seatDTOS.add(seatDTO);
    }
    
    private final List<SeatDTO> seatDTOS = new ArrayList<>();
}
