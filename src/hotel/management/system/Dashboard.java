
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard(){
        setBounds(0,0,1920,1080);
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1980, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1980,1080);
        add(image);
        
        JLabel text = new JLabel("The Villa Welcomes You...");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.ITALIC,46));
        text.setForeground(new Color(139, 69, 19));
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1980,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.BLUE);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("Admin ");
        admin .setForeground(Color.BLUE);
        mb.add(admin );
        
        JMenuItem addemployee = new JMenuItem("Add Employee");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms = new JMenuItem("Add Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers = new JMenuItem("Add Driver");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        }else if (ae.getActionCommand().equals("Add Rooms")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("Add Driver")){
            new AddDriver();
        }else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }
       
    }
    public static void main(String[] args){
        new Dashboard();
    }
}
