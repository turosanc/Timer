import java.awt.event.*;
import javax.swing.*;

public class PomoTimer implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0; //this the total time

    //this is the actual timer section
    //1000 = 1 sec
    Timer timer = new Timer(1000, new ActionListener(){

        public void actionPerformed(ActionEvent e){

            elapsedTime = elapsedTime+1000;
            //need to add hour min sec

            timeLabel.setText("");

        }

    });


    PomoTimer(){

        timeLabel.setText("00.00.00");
        timeLabel.setBounds(100,100,300,100);
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);


        startButton.setBounds(100,200,100,50);
        startButton.addActionListener(this);


        resetButton.setBounds(300,200,100,50);
        resetButton.addActionListener(this);





        frame.add(startButton);
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
    }

    void start(){
        timer.start();
    }

    void stop(){
        timer.stop();
    }

    void reset(){
        timer.stop();
        timeLabel.setText("00.00.00");
    }
}
