package Models;

import java.util.UUID;

public class User {
    public  String id;
    public  String name;

    public  User(){
        id = UUID.randomUUID().toString();
    }
}
