package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid  ;
    JTextField tfnumber,tfname,tfcountry,tfdeposite;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //for text as a heading
        JLabel text = new JLabel("New Customer Form");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.ITALIC,20));
        add(text);
        
        //for id
        JLabel id = new JLabel("ID");
        id.setBounds(35, 80, 100, 20);
        id.setFont(new Font("Raleway",Font.ITALIC,20));
        add(id);
        
        //combobox id;
        String options[] = {"Aadhar card","Passport","Driving License","Voter-Id"};
        comboid = new JComboBox(options);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        //for Number;
        JLabel number = new JLabel("Number");
        number.setBounds(35, 120, 100, 20);
        number.setFont(new Font("Raleway",Font.ITALIC,20));
        add(number);
        
        //Textfield for number
        tfnumber = new JTextField();
        tfnumber.setBounds (200,120,150,25);
        add(tfnumber);
        
        //for name
        JLabel name = new JLabel("Name");
        name.setBounds(35, 160, 100, 20);
        name.setFont(new Font("Raleway",Font.ITALIC,20));
        add(name);
        
        //Textfield for name
        tfname = new JTextField();
        tfname.setBounds (200,160,150,25);
        add(tfname);
        
        //for gender
        JLabel gender = new JLabel("Gender");
        gender.setBounds(35, 200, 100, 20);
        gender.setFont(new Font("Raleway",Font.ITALIC,20));
        add(gender);
        
        //Radiobutton for gender
        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);
        
        //for countary
        JLabel country = new JLabel("Countary");
        country.setBounds(35, 240, 100, 20);
        country.setFont(new Font("Raleway",Font.ITALIC,20));
        add(country);
        
        //Textfield for countary
        tfcountry = new JTextField();
        tfcountry.setBounds (200,240,150,25);
        add(tfcountry);
        
        //for room
        JLabel room = new JLabel("Room No");
        room.setBounds(35, 280, 150, 20);
        room.setFont(new Font("Raleway",Font.ITALIC,20));
        add(room);
        
        //
        croom = new Choice();
        
        try{
            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available' ";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("room_number"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        croom.setBounds(200,280,150,25);
        add(croom);
        
        //for checkin time
        JLabel time = new JLabel("Checkin time");
        time.setBounds(35, 320, 150, 20);
        time.setFont(new Font("Raleway",Font.ITALIC,20));
        add(time);
        
        Date date = new Date();
        
        //for checkin edit by user
        checkintime = new JLabel("" + date);
        checkintime.setBounds(200, 320, 150, 25);
        checkintime.setFont(new Font("Raleway",Font.ITALIC,16));
        add(checkintime);
        
        //for deposite
        JLabel deposite = new JLabel("Deposite");
        deposite.setBounds(35, 360, 100, 20);
        deposite.setFont(new Font("Raleway",Font.ITALIC,20));
        add(deposite);
        
        //Textfield for deposite
        tfdeposite = new JTextField();
        tfdeposite.setBounds (200,360,150,25);
        add(tfdeposite);
        
        //for add button
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,25);
        add.addActionListener(this);
        add(add);
        
        //for cancel button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,25);
        back.addActionListener(this);
        add(back);
        
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        
        
        
        
        setBounds(350,200,800,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            
            if(rmale.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }
            
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposite.getText();
            
            try{
                String query = "insert into customer values('"+id+"','"+ number+"','"+ name+"','"+ gender+"','"+ country+"','"+ room+"','"+ time+"','"+ deposit+"')";
                String query2 = "update room set availability = 'Occupied' where room_number = '"+ room+"'";
                
                Conn conn = new Conn();
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Sucessfully");
                
                setVisible(false);
                new Reception();
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == back){
           setVisible(false);
            new Reception(); 
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
