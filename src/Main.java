import Constants.City;
import Models.Booking;
import Models.Movie;
import Models.Screen;
import Models.Show;
import Models.Theatre;
import Models.User;
import Services.BookingService;
import Services.MovieService;
import Services.ScreenService;
import Services.ShowService;
import Services.TheatreService;
import Services.impl.BookingserviceImpl;
import Services.impl.MovieServiceImpl;
import Services.impl.ScreenServiceImpl;
import Services.impl.ShowServiceImpl;
import Services.impl.TheatreServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /**
         * USER --> id, email
         * MOVIE --> id , name
         * THEATRE --> id , name , city
         * SHOW  --> movieID , sceenId , startTime , endTime
         * SCREEN --> id , theatreid
         * SEAT --> id , type
         * Reservation --> id,
         *
         * userId to user map
         * movie Id to movie map
         * theatre id to thatre map
         * show id to show map
         * screen id to scrren map
         * seat id to seat map
         *
         *
         * user --> will search for a movie by city , then we will show shows with the movie in the same city
         * user selects a show , we give the empty seats
         * user can reservr a seat
         */

        TheatreService theatreService = TheatreServiceImpl.getInstance();
        MovieService movieService = new MovieServiceImpl();

        Theatre t1 =  theatreService.createTheatre("PVR" , City.DELHI);
        theatreService.createTheatre("IMAX" , City.MUMBAI);

        Movie movie =  movieService.createMovie("pie");
        Movie movie1 = movieService.createMovie("pie2");

        ScreenService screenService = ScreenServiceImpl.getInstance();
        Screen screen =  screenService.createScreen(t1.id);

        ShowService showService = ShowServiceImpl.getInstance();
        Show show =  showService.createShow(movie.id , screen.id);

        List<Show> shows  = showService.getMovieShowsInSameCity(City.DELHI , movie1.id);

        for(Show show1 : shows){
            System.out.println(show1.id);
        }


        BookingService bookingService = BookingserviceImpl.getInstance();

        User user = new User();
        user.name = "hhh";

        List<String> seatids = new ArrayList<>();
        seatids.add("1");

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Booking>> x = new ArrayList<>();

        for(int i = 0 ; i < 10 ; i++){
          Future<Booking> booking =    executorService.submit(() -> bookingService.createBooking(user.id , show.id , seatids));

        }
    }
}