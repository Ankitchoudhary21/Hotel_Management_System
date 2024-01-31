package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    Room() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        //
        JLabel L1 = new JLabel("Room Number");
        L1.setBounds(10,10,100,20);
        add(L1);
        //
        JLabel L2 = new JLabel("Availability");
        L2.setBounds(120,10,100,20);
        add(L2);
        //
        JLabel L3 = new JLabel("Status");
        L3.setBounds(230,10,100,20);
        add(L3);
        //
        JLabel L4 = new JLabel("Price");
        L4.setBounds(330,10,100,20);
        add(L4);
        //
        JLabel L5 = new JLabel("Bed Type");
        L5.setBounds(410,10,100,20);
        add(L5);
        
        //for table
        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new Room();
    }
}
