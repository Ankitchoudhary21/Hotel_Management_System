package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Customerinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    Customerinfo() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        //
        JLabel L1 = new JLabel("Doc Type");
        L1.setBounds(10,10,100,20);
        add(L1);
        //
        JLabel L2 = new JLabel("Doc Num");
        L2.setBounds(160,10,100,20);
        add(L2);
        //
        JLabel L3 = new JLabel("Name");
        L3.setBounds(290,10,100,20);
        add(L3);
        //
        JLabel L4 = new JLabel("Gender");
        L4.setBounds(410,10,100,20);
        add(L4);
        //
        JLabel L5 = new JLabel("Country");
        L5.setBounds(510,10,100,20);
        add(L5);
        //
        JLabel L6 = new JLabel("Room-No");
        L6.setBounds(640,10,100,20);
        add(L6);
        //
        JLabel L7 = new JLabel("Checkin time");
        L7.setBounds(760,10,100,20);
        add(L7);
        //
        JLabel L8 = new JLabel("Deposit");
        L8.setBounds(900,10,100,20);
        add(L8);
        
        //for table
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(400,500,120,30);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new Customerinfo();
    }
}
