package Services;

import Constants.City;
import Models.Theatre;

public interface TheatreService {

    Theatre getTheatreById(String id);

    Theatre createTheatre( String name , City city);
}
