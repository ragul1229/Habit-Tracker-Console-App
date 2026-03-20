import java.time.LocalTime;
import java.time.LocalDate;

public class Remainder {
    int r_id;
    LocalTime time;
    LocalDate date;
    String message;
    Remainder(int r_id,LocalTime time,LocalDate date,String message){
        this.r_id = r_id;
        this.time = time;
        this.date = date;
        this.message = message;
    }

}
