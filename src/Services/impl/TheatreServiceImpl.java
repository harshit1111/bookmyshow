package Services.impl;

import Constants.City;
import Models.Theatre;
import Services.TheatreService;

import java.util.HashMap;
import java.util.Map;

public class TheatreServiceImpl implements TheatreService {

    Map<String,Theatre> theatreMap;
    static TheatreService theatreService;

    private   TheatreServiceImpl(){
        theatreMap = new HashMap<>();
    }

    static public TheatreService getInstance(){
        if(theatreService == null){
            synchronized (TheatreService.class){
                if(theatreService == null){
                    theatreService = new TheatreServiceImpl();
                }
            }
        }
        return  theatreService;
    }
    @Override
    public Theatre getTheatreById(String id) {
        return theatreMap.get(id);

    }

    @Override
    public Theatre createTheatre( String name, City city) {
        Theatre theatre = new Theatre(city , name);
        theatreMap.put(theatre.id , theatre);
        return  theatre;
    }

    public City geCityByTheatreId(String theatreId) {
        return theatreMap.get(theatreId).city;
    }
}
