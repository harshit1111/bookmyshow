package Services;

import Constants.City;
import Models.Booking;
import Models.Show;

import java.util.List;

public interface ShowService {

    Show getShowById(String showId);

    Show createShow(String movieId , String screenId);

    List<Show> getMovieShowsInSameCity(City city , String movieId);

    Boolean lockSeats(List<String>seatIds , String showId);
}
