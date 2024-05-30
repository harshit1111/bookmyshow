package Models;

import java.util.UUID;

public class Movie {
    public  String id;
    public  String name;

    public  Movie(String name){
        id = UUID.randomUUID().toString();
        this.name = name;
    }
}
