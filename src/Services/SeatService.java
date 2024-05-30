package Services;

import Models.Seat;

public interface SeatService {
    Seat getSetById(String id);
    Seat createSeat(String screenId);

}
