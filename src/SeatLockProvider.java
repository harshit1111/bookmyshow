import java.util.concurrent.locks.ReentrantLock;

public class SeatLockProvider {

    static  SeatLockProvider seatLockProvider = null;
    private ReentrantLock reentrantLock;

    private  SeatLockProvider(){
        seatLockProvider = new SeatLockProvider();
        reentrantLock = new ReentrantLock();
    }

    public  static  SeatLockProvider getInstance(){
        if(seatLockProvider == null){
            synchronized (SeatLockProvider.class){
                if (seatLockProvider == null) {
                    seatLockProvider = new SeatLockProvider();
                }
            }
        }
        return  seatLockProvider;
    }
}
