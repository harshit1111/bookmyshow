package Models;

import java.util.UUID;

public class Screen {
    public  String id;
    public  String theaterId;

    public  Screen(String theaterId){
        id = UUID.randomUUID().toString();
        this.theaterId = theaterId;
    }
}
