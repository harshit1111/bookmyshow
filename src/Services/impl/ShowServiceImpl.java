package Services.impl;

import Constants.City;
import Models.Booking;
import Models.Show;
import Models.Theatre;
import Services.ScreenService;
import Services.ShowService;
import Services.TheatreService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowServiceImpl implements ShowService {

    Map<String,Show> showMap;
    Map<City , List<String>> cityToShowIdMap;
    Map<String,Map<String,Boolean>> showTobookedSeatIds;

    static ShowService showService = null;

    ScreenService screenService;

    private   ShowServiceImpl(){
        cityToShowIdMap = new HashMap<>();
        showMap = new HashMap<>();
        screenService = ScreenServiceImpl.getInstance();
        showTobookedSeatIds = new HashMap<>();
    }

    static  public  ShowService getInstance(){
        if(showService == null){
            synchronized (ShowService.class){
                if(showService == null){
                    showService = new ShowServiceImpl();
                }
            }
        }
        return  showService;
    }
    @Override
    public Show getShowById(String showId) {
        return  showMap.get(showId);
    }

    @Override
    public Show createShow(String movieId, String screenId) {
        Theatre theatre = screenService.getTheatreByScreenId(screenId);
        Show show = new Show(movieId , screenId);
        showMap.put(show.id , show);
        showTobookedSeatIds.put(show.id,new HashMap<>());
        cityToShowIdMap.computeIfAbsent(theatre.city , k -> new ArrayList<>()).add(show.id);
        return show;
    }

    @Override
    public List<Show> getMovieShowsInSameCity(City city , String movieId) {
        List<Show> shows = new ArrayList<>();
        for(String showId : cityToShowIdMap.get(city)){
            if(this.getShowById(showId).movieId == movieId){
                shows.add(this.getShowById(showId));
            }
        }
        return shows;
    }

    public Boolean lockSeats(List<String> seatIds , String showId){
        Map<String,Boolean> map = showTobookedSeatIds.get(showId);
        List<String> seatsDone = new ArrayList<>();
        boolean canBook = true;
        for(String seatId : seatIds){
            synchronized (seatId){
                if(!map.containsKey(seatId) || map.get(seatId) == false){
                    map.put(seatId , true);
                    seatsDone.add(seatId);
                }else{
                    canBook = false;
                }
            }
        }
        if(canBook){
            return  true;
        }else{
            for(String x : seatsDone){
                synchronized (x){
                    map.put(x , false);
                }
            }
            return  false;
        }
     }
}
