package Services.impl;

import Models.Booking;
import Models.Payment;
import Models.PaymentStatus;
import Services.BookingService;
import Services.ShowService;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingserviceImpl implements BookingService {

    static BookingService bookingService = null;
    Map<String , Booking> bookingMap;

    public BookingserviceImpl(){
        bookingMap = new HashMap<>();
    }

    static  public  BookingService getInstance(){
        if(bookingService ==null){
            synchronized (BookingserviceImpl.class){
                if(bookingService== null){
                    bookingService= new BookingserviceImpl();
                }
            }
        }
        return  bookingService;
    }
    @Override
    public Booking getBookingById(String id) {
        return bookingMap.get(id);
    }

    @Override
    public Booking createBooking(String userId, String showId, List<String> seatIds) {
        ShowService showService = ShowServiceImpl.getInstance();
        Boolean canBook = showService.lockSeats(seatIds , showId);
        System.out.println(canBook);
        if(!canBook){
            return  null;
        }

        Payment payment = new Payment(PaymentStatus.PENDING);
        Booking booking = new Booking(userId , showId , seatIds,payment);

        bookingMap.put(booking.id , booking);

        // payment service

        Boolean paid = true;

        if(paid){
            booking.payment.paymentStatus = PaymentStatus.PAID;
        }else{
            // unlock all the seats
        }


        return  booking;
    }
}
