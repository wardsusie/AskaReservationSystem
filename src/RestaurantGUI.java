import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class RestaurantGUI implements ActionListener {

    Aska aska = new Aska();
    private JFrame mainFrame;
    private JPanel panel;
    private JPanel panel2;
    private JButton addReservation;
    private JButton numberPeople;
    private JButton timeMade;
    private JButton timeFor;
    private JLabel label; // displays current reservations
    private JPanel panel3;
    private JLabel label2; // sorts reservations
    private JLabel title;
    private JPanel panel4;
    private JTextArea textArea;
    private JTextField textTimeMade;
    private JTextField textPeople;
    private JTextField textTimeFor;


    public static void main(String[] args) { new RestaurantGUI();}

    public RestaurantGUI(){

        mainFrame = new JFrame();
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        addReservation = new JButton("Add Reservation");
        addReservation.addActionListener(this);
        numberPeople = new JButton("Sort by Number of People");
        numberPeople.addActionListener(this);
        timeMade = new JButton("Sort by Time Made");
        timeMade.addActionListener(this);
        timeFor = new JButton("Sort by Time For");
        timeFor.addActionListener(this);
        title = new JLabel("Welcome to Aska Reservations !!");
        label = new JLabel("");
        label2 = new JLabel("");
        panel4 = new JPanel();

        textArea = new JTextArea();
        textTimeMade = new JTextField("Add time made");
       textPeople = new JTextField("Add Number of People");
       textTimeFor = new JTextField("Add time for");

//        for(int i=1;i<5; i++){
//            textArea.setText(textArea.getText() + aska.returnReservations() + "\n");
//        }
        textArea.setText(aska.returnReservations());

        panel4.setLayout(new BorderLayout());
        panel4.add(title, BorderLayout.CENTER);

        panel3.setLayout(new GridLayout(2, 4)); //adding reservation
        panel3.add(addReservation, BorderLayout.SOUTH);
//        panel3.add(label, BorderLayout.WEST);
        panel3.add(textPeople, BorderLayout.NORTH);
        panel3.add(textTimeFor, BorderLayout.CENTER);
        panel3.add(textTimeMade, BorderLayout.EAST);


        panel2.setLayout(new GridLayout(1,3)); //sorting
        panel2.add(numberPeople,BorderLayout.WEST);
        panel2.add(timeMade, BorderLayout.CENTER);
        panel2.add(timeFor, BorderLayout.EAST);
//        panel2.add(label2,BorderLayout.SOUTH);

        panel.setLayout(new GridLayout(4,1));
        panel.add(panel4, BorderLayout.NORTH);
        panel.add(panel3, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);
        panel.add(textArea,BorderLayout.SOUTH);
        //panel.add(label);

        mainFrame.add(panel);
        mainFrame.setSize(600,600);
        mainFrame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonClicked = e.getSource();

//        if(buttonClicked == addReservation){
//            aska.makeRandomReservation();
//            textArea.setText(aska.returnReservations() );
//        }

        if (buttonClicked == addReservation){
            System.out.println("add reservation button clicked");
            String peopleNumber = textPeople.getText();
            String forTime = "1-10-2024 " + textTimeFor.getText() + ":00";
            String madeTime = "1-10-2024 " + textTimeMade.getText() + ":00";
            aska.makeReservation(peopleNumber, forTime, madeTime);
          System.out.println ("reservation made: "  );
            textArea.setText(aska.returnReservations());


        }
//        if(buttonClicked == numberPeople){
//            label2.setText(label2.getText() + aska.sortBynPeople());  //make returnReservation - sort by npeople class in Aska?
//        }
//        if (buttonClicked == timeFor){
//            label2.setText(label2.getText() + aska.sortByTimeFor());
//        }
//        if (buttonClicked == timeMade){
//            label2.setText(label2.getText() + aska.sortByTimeMade());
//        }

        if(buttonClicked == numberPeople){
            aska.sortBynPeople();
            textArea.setText(aska.returnReservations());
        }
        if(buttonClicked == timeFor){
            aska.sortByTimeFor();
            textArea.setText(aska.returnReservations());
        }
        if(buttonClicked == timeMade){
            aska.sortByTimeMade();
            textArea.setText(aska.returnReservations());
        }


    }
}
