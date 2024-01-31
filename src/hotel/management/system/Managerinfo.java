package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Managerinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    Managerinfo() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        //
        JLabel L1 = new JLabel("Name");
        L1.setBounds(40,10,100,20);
        add(L1);
        //
        JLabel L2 = new JLabel("Age");
        L2.setBounds(170,10,100,20);
        add(L2);
        //
        JLabel L3 = new JLabel("Gender");
        L3.setBounds(290,10,100,20);
        add(L3);
        //
        JLabel L4 = new JLabel("Job");
        L4.setBounds(400,10,100,20);
        add(L4);
        //
        JLabel L5 = new JLabel("Salary");
        L5.setBounds(540,10,100,20);
        add(L5);
        //
        JLabel L6 = new JLabel("Phone Num");
        L6.setBounds(670,10,100,20);
        add(L6);
        //
        JLabel L7 = new JLabel("Email");
        L7.setBounds(790,10,100,20);
        add(L7);
        //
        JLabel L8 = new JLabel("Id-num");
        L8.setBounds(910,10,100,20);
        add(L8);
        
        //for table
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where job = 'Manager' ");
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
        new Managerinfo();
    }
}
