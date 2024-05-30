package Models;

import java.util.UUID;

public class Show {
    public  String id;
    public  String movieId;
    public String screeId;
    public  Long startTime;
    public  Long endTime;

    public  Show(String movieId , String screeId){
        id = UUID.randomUUID().toString();
        this.movieId = movieId;
        this.screeId = screeId;

    }
}
