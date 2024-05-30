package Models;

import java.util.UUID;

public class Payment {
    public  String id;
    public  PaymentStatus paymentStatus;

    public Payment(PaymentStatus paymentStatus){
        id = UUID.randomUUID().toString();
        this.paymentStatus = paymentStatus;
    }
}
