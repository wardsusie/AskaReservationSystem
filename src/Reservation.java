import javax.swing.text.ParagraphView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {

    private String name;
    private int nPeople;
    private long timeMade;
    private long timeFor;
    private String time;
    private boolean waitlisted;
    private Object DateFormat;
    private SimpleDateFormat timeFormat;
//    private String entireReservation;

    public Reservation(){
        name = new String();
        nPeople = (int)(Math.random()*10+1);
        DateFormat dateFormat = new SimpleDateFormat("M-dd-yyyy k:mm");
        timeMade = new Date().getTime() - (int)(Math.random() * 100000000);
        timeFor = new Date().getTime() - (int)(Math.random() * 10000000);
    }

    public Reservation(String paramNPeople, String paramTimeFor, String paramTimeMade) {
         nPeople = Integer.valueOf(paramNPeople);
        try {
            DateFormat stringToDate = new SimpleDateFormat("M-dd-yyyy k:mm");
            Date timeForDate = stringToDate.parse(paramTimeFor);
            Date timeMadeDate = stringToDate.parse(paramTimeMade);
            timeFor = timeForDate.getTime();
            timeMade = timeMadeDate.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public void timeStuff(){
        long now = new Date().getTime();
        System.out.println(now);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd k:mm");
        String timeString = dateFormat.format(now);
        System.out.println(timeString);

        long future = new Date().getTime() + 100000;
        String futureString = dateFormat.format(future);
        System.out.println(futureString);
        System.out.println(future > now);

        Date futureDate = new Date(future);
        Date nowDate = new Date(now);
        System.out.println(futureDate.before(nowDate));
        
        
        String min = "15:00:00";
        String max = "21:00:00";
        
//        try { //check schoology
//            DateFormat = timeFormat = new SimpleDateFormat("HH:mm:ss");
//            Date minHour = timeFormat.parse(min);
//            Date maxHour = timeFormat.parse(max);
//
//            future = new Date().getTime();
//
//        }

    }

    public void printInfo(){
       // print details for a single reservation
        System.out.println("Reservation for " + nPeople + " made at " + timeMade + " o'clock" + " for " + timeFor + " o'clock");

    }

    public String getEntireReservation(){
        DateFormat dateFormat = new SimpleDateFormat("M-dd-yyyy k:mm");

        String entireReservation = ("Reservation for " + nPeople + " made at " + dateFormat.format(timeMade) + " o'clock" + " for " + dateFormat.format(timeFor) + " o'clock");
        return entireReservation;
    }

    public int getNPeople(){
        return nPeople;
    }

    public long getTimeMade(){
        return timeMade;

    }

    public long getTimeFor(){
        return timeFor;
    }


}
