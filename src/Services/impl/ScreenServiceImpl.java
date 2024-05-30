package Services.impl;

import Models.Screen;
import Models.Theatre;
import Services.ScreenService;
import Services.TheatreService;

import java.util.HashMap;
import java.util.Map;

public class ScreenServiceImpl implements ScreenService {

    static ScreenService screenService;

    Map<String,Screen> screenMap;
    TheatreService theatreService;

    private   ScreenServiceImpl(){
        screenMap = new HashMap<>();
        theatreService =  TheatreServiceImpl.getInstance();
    }

    static public ScreenService getInstance(){
        if(screenService == null){
            synchronized (ScreenServiceImpl.class) {
                if(screenService == null){
                    screenService = new ScreenServiceImpl();
                }

            }
        }
        return  screenService;
    }
    @Override
    public Screen getScreenById(String id) {
        return screenMap.get(id);
    }

    @Override
    public Screen createScreen(String theatreId) {
        Screen screen = new Screen(theatreId);
        screenMap.put(screen.id , screen);
        return screen;
    }

    @Override
    public Theatre getTheatreByScreenId(String id) {
        Screen screen = screenMap.get(id);
        return theatreService.getTheatreById(screen.theaterId);
    }
}
