package Models;

import Constants.City;

import java.util.UUID;

public class Theatre {
    public  String id;
    public  String name;
    public  City city;

    public  Theatre(City city , String name){
        id = UUID.randomUUID().toString();
        this.city = city;
        this.name = name;
    }

}
