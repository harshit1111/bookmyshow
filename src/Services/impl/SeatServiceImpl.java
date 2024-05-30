package Services.impl;

import Models.Seat;
import Services.SeatService;

import java.util.HashMap;
import java.util.Map;

public class SeatServiceImpl implements SeatService {

    Map<String,Seat> seatMap;

    public  SeatServiceImpl(){
        seatMap = new HashMap<>();
    }
    @Override
    public Seat getSetById(String id) {
        return seatMap.get(id);
    }

    @Override
    public Seat createSeat(String screenId) {
        Seat seat = new Seat(screenId);
        seatMap.put(seat.id , seat);
        return  seat;
    }
}
