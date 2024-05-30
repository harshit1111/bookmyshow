package Models;

import java.util.UUID;

public class Seat {
    public  String id;
    public  String screenId;

    public  Seat(String screenId){
        id = UUID.randomUUID().toString();
        this.screenId = screenId;
    }
}
