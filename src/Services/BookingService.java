package Services;

import Models.Booking;

import java.util.List;

public interface BookingService {

    Booking getBookingById(String id);

    Booking createBooking(String userId , String showId , List<String> seatIds);
}
