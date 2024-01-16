import com.sun.codemodel.internal.JArray;
import com.sun.tools.doclets.internal.toolkit.AnnotationTypeOptionalMemberWriter;

import java.util.ArrayList;




public class Aska {

    private ArrayList<Reservation> reservations = new ArrayList<>();

    public Aska(){
        for(int x = 0; x< 6; x++) {
            addReservation();
        }
          displayReservations();
//        sortBynPeople();
//        timeStuff();
        sortByTimeFor();
        displayReservations();
    }

    public void displayReservations() {
        for (int y = 0; y < 6; y++) {
            reservations.get(y).printInfo();
        }

        System.out.println();

//        for(Reservation r : reservations){
//            r.printInfo();
//    }
    } //might not need anymore after GUI exists

    public String returnReservations(){
        String info = "";
        for (int y = 0; y < reservations.size(); y++) {
            info = info + reservations.get(y).getEntireReservation() + "\n";
        }
        return info;
    }

    public void addReservation(){
        reservations.add(new Reservation());
        System.out.println("there are " + reservations.size() + " reservations");
    }

    public void makeReservation(String np, String tm, String tf){
        reservations.add(new Reservation(np, tm, tf));
        System.out.println("there are " + reservations.size() + " reservations");

    }

    public void makeRandomReservation(){
        reservations.add(new Reservation());
        System.out.println("there are " + reservations.size() + " reservations");
    }



    public void sortBynPeople(){    //bubble sort
       for (int x =1; x< reservations.size(); x++){
           System.out.println("x: " + x);
           for(int i =1; i < (reservations.size() - (x-1)); i++){
               System.out.println("i: " + i);
               if(reservations.get(i-1).getNPeople()>reservations.get(i).getNPeople()){
                   Reservation temp = reservations.get(i);
                   reservations.set(i, reservations.get(i-1));
                   reservations.set(i-1, temp);
               }
           }
       }
    }

    public void sortByTimeMade(){
        for (int x =1; x< reservations.size(); x++){
            System.out.println("");
            for(int i =1; i < (reservations.size() - (x-1)); i++){
                if(reservations.get(i-1).getTimeMade()>reservations.get(i).getTimeMade()){
                    Reservation temp = reservations.get(i);
                    reservations.set(i, reservations.get(i-1));
                    reservations.set(i-1, temp);
                }
            }
        }

    }

    public void sortByTimeFor(){
        for (int x =1; x< reservations.size(); x++){
            System.out.println("");
            for(int i =1; i < (reservations.size() - (x-1)); i++){
                if(reservations.get(i-1).getTimeFor()>reservations.get(i).getTimeFor()){
                    Reservation temp = reservations.get(i);
                    reservations.set(i, reservations.get(i-1));
                    reservations.set(i-1, temp);
                }
            }
        }


    }

    public void sortByWaitlist(){


    }
//    public static void main(String[] args) {
//        Aska restaurant = new Aska();
//    }
}
