package hu.pallas.stopper;

// ***************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{
	
 	
 
 JFrame frame = new JFrame("János Időmérő Csudamasinája");
 JButton startButton = new JButton("Start");
 JButton stopButton = new JButton("Stop");
 JButton resetButton = new JButton("Reset");
 JLabel timeLabel = new JLabel();
 int elapsedTime = 0;
 int seconds =0;
 int minutes =0;
 int hours =0;
 boolean started = false;
 private boolean visible;
 String seconds_string = String.format("%02d", seconds);
 String minutes_string = String.format("%02d", minutes);
 String hours_string = String.format("%02d", hours);
 
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
 
 Timer timer = new Timer(1000, new ActionListener() {
  
  public void actionPerformed(ActionEvent e) {
   
   elapsedTime=elapsedTime+1000;
   hours = (elapsedTime/3600000);
   minutes = (elapsedTime/60000) % 60;
   seconds = (elapsedTime/1000) % 60;
   seconds_string = String.format("%02d", seconds);
   minutes_string = String.format("%02d", minutes);
   hours_string = String.format("%02d", hours);
   timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
   
  }
  
 });
 
 
 Stopwatch(){
  
  timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
  timeLabel.setBounds(150,100,200,100);
  timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
  timeLabel.setBorder(BorderFactory.createBevelBorder(1));
  timeLabel.setOpaque(true);
  timeLabel.setHorizontalAlignment(JTextField.CENTER);
  
  startButton.setBounds(100,200,100,50);
  startButton.setFont(new Font("Arial",Font.BOLD,20));
  startButton.setFocusable(false);
  startButton.addActionListener(this);
  
  stopButton.setBounds(200,200,100,50);
  stopButton.setFont(new Font("Arial",Font.BOLD,20));
  stopButton.setFocusable(false);
  stopButton.addActionListener(this);
  
  resetButton.setBounds(300,200,100,50);
  resetButton.setFont(new Font("Arial",Font.BOLD,20));
  resetButton.setFocusable(false);
  resetButton.addActionListener(this);
  
  frame.add(startButton);
  frame.add(stopButton);
  frame.add(resetButton);
  frame.add(timeLabel);
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(520,420);
  frame.setLayout(null);
  frame.setVisible(true);
  
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  
  if(e.getSource()==startButton) {
    started=false;
    start();
  }
  
  if(e.getSource()==stopButton) {
    started=false;
    stop();
   }
   
  
  if(e.getSource()==resetButton) {
   started=false;
   reset();
  }
  
 }
 
 void start() {
  timer.start();
 }
 
 void stop() {
  timer.stop();
 }
 
 void reset() {
  timer.stop();
  elapsedTime=0;
  seconds =0;
  minutes=0;
  hours=0;
  seconds_string = String.format("%02d", seconds);
  minutes_string = String.format("%02d", minutes);
  hours_string = String.format("%02d", hours);       timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
 }

}

