package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Booking {
    public  String id;
    public  String userId;

    public  String showId;

    public List<String> seaIds;

    public  Payment  payment;

    public  Booking(String userId , String showId,List<String> seaIds,Payment payment){
        id = UUID.randomUUID().toString();
        this.userId = userId;
        this.showId = showId;
        this.seaIds = seaIds;
        this.payment = payment;
    }
}
