package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfroom,tfroomprice;
    JComboBox availablecombo,cleancombo,bedcombo;
    
    AddRooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //for rooms
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD|Font.ITALIC,17));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        //for room no
        JLabel roomno = new JLabel("Room No :- ");
        roomno.setFont(new Font("Tahoma",Font.ITALIC,16));
        roomno.setBounds(60,80,120,30);
        add(roomno);
        
        //textfield for room no
        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        //for room available
        JLabel available = new JLabel("Available :-");
        available.setFont(new Font("Tahoma",Font.ITALIC,16));
        available.setBounds(60,130,120,30);
        add(available);
        
        //for dropbox of room availability
        String availableOptions[] = {"Available","Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        //for cleaning status
        JLabel clean = new JLabel("Cleaning Status :- ");
        clean.setFont(new Font("Tahoma",Font.ITALIC,16));
        clean.setBounds(60,180,120,30);
        add(clean);
        
        //for dropbox of cealing status
        String cleanOptions[] = {"Clean","Dirty"};
        cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
        //for Room Price
        JLabel roomprice = new JLabel("Room Price :- ");
        roomprice.setFont(new Font("Tahoma",Font.ITALIC,16));
        roomprice.setBounds(60,230,120,30);
        add(roomprice);
        
        //textfield for room price
        tfroomprice = new JTextField();
        tfroomprice.setBounds(200,230,150,30);
        add(tfroomprice);
        
        //for Bed type
        JLabel bedtype = new JLabel("Bed Type :- ");
        bedtype.setFont(new Font("Tahoma",Font.ITALIC,16));
        bedtype.setBounds(60,280,120,30);
        add(bedtype);
        
        //for dropbox of bed type
        String bedOptions[] = {"Single Bed","Double Bed"};
        bedcombo = new JComboBox(bedOptions);
        bedcombo.setBounds(200,280,150,30);
        bedcombo.setBackground(Color.WHITE);
        add(bedcombo);
        
        //button add room
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        //Button for Cancel room
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        setBounds(330,220,940,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String room_number = tfroom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String cleaning_status = (String) cleancombo.getSelectedItem();
            String price = tfroomprice.getText();
            String bed_type = (String) bedcombo.getSelectedItem();
            
            try {
             Conn conn = new Conn();
             String str = "insert into room values ('"+room_number+"', '"+availability+"', '"+cleaning_status+"','"+price+"','"+bed_type+"' )";
             
             conn.s.executeUpdate(str);
             
             JOptionPane.showMessageDialog(null, "New Room Added Sucessefully");
             
             setVisible(false);
             
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddRooms();
    }
}
