package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public  class HotelManagementSystem extends JFrame implements ActionListener{
    
    HotelManagementSystem(){

        setBounds(100,100,1366,565);
        setLayout(null);
        
        //Below line is for Image_of_Hotel.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Hotel.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);//locationx, locationy,length,breadth
        add(image);
        
        //Below line is for "Hotel Management System"
        JLabel text = new JLabel("Hotel Management System...");
        text.setBounds(20,430,1000,90);
        text.setForeground(new Color(0, 255, 255));
        text.setFont(new Font("serif", Font.ITALIC, 70));
        image.add(text);
        
       //Below line is for "Next" Button.
       JButton button = new JButton("Next");
       button.setBounds(1150, 450, 150, 50);
       button.setBackground(new Color(0, 255, 255));
       button.setForeground(Color.BLACK);
       button.addActionListener(this);
       button.setFont(new Font("serif", Font.ITALIC, 30));
       image.add(button);
       
       setVisible(true);
        
       //Below is for deeper funcationality of "Hotel Management System..." line .
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(400);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(400);
            }catch (Exception e){
                e.printStackTrace();
            }
        }    
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
       new HotelManagementSystem();
    } 
}
