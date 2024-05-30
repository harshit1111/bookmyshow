package Services;

import Models.Screen;
import Models.Theatre;

public interface ScreenService {
    Screen getScreenById(String id);
    Screen createScreen(String theatreId);

    Theatre getTheatreByScreenId(String id);
}
