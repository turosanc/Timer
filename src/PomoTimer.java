import java.awt.event.*;
import javax.swing.*;

public class PomoTimer implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton stopButton = new JButton("STOP");
    JButton resetButton = new JButton("RESET");
    JButton nekoButton = new JButton("Kitty");
    JLabel timeLabel = new JLabel();


    int elapsedTime = 0; //this the total time
    int seconds = 0;
    int minutes = 0;
    int hours = 0;

    String secString = "";
    String minString = "";
    String hourString = "";

    //this is the actual timer section
    //1000 = 1 sec
    Timer timer = new Timer(1000, new ActionListener(){

        public void actionPerformed(ActionEvent e){
            //counts time using milisecs
            elapsedTime = elapsedTime+1000;
            hours = elapsedTime/3600000;
            minutes = (elapsedTime/60000)%60;
            seconds = (elapsedTime/1000)%60;
            //int to string to display on timer
            secString = String.format("%02d", seconds);
            minString = String.format("%02d", minutes);
            hourString = String.format("%02d", hours);

            timeLabel.setText(hourString + ":" +minString + ":" + secString);


            //need to add new frames for neko button and when certain intervals are hit

        }

    });

    //believe nekobutton should be out of timer class with different actionlistner


    PomoTimer(){

        timeLabel.setText("00.00.00");
        timeLabel.setBounds(100,100,300,100);
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);


        startButton.setBounds(100,200,100,50);
        startButton.addActionListener(this);

        stopButton.setBounds(200, 200, 100, 50);
        stopButton.addActionListener(this);


        resetButton.setBounds(300,200,100,50);
        resetButton.addActionListener(this);

        nekoButton.setBounds(200,0, 100, 50);
        nekoButton.addActionListener(this);





        frame.add(startButton);
        frame.add(stopButton);
        frame.add(nekoButton);
        frame.add(resetButton);
        frame.add(timeLabel);

        //goes at end to show everything

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.print("Button was hit");

        if(e.getSource() == startButton){
            start();
        }
        if(e.getSource() == resetButton){
            reset();
        }
        if(e.getSource() == stopButton){
            stop();
        }

        if(e.getSource() == nekoButton){
            System.out.print("PSPSPSPSPSPSPSPSPSPSPSPS kitty");
        }
    }

    void start(){
        timer.start();
    }

    void stop(){
        timer.stop();
    }

    void reset(){
        timer.stop();
        elapsedTime = 0;
        timeLabel.setText("00.00.00");
    }
}
