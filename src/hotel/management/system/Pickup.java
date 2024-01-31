package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    
    Pickup() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.ITALIC,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Type of car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select*from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //
        JLabel L1 = new JLabel("Driver Name");
        L1.setBounds(50,160,100,20);
        add(L1);
        //
        JLabel L2 = new JLabel("Driver Age");
        L2.setBounds(180,160,100,20);
        add(L2);
        //
        JLabel L3 = new JLabel("Gender");
        L3.setBounds(330,160,100,20);
        add(L3);
        //
        JLabel L4 = new JLabel("Car's Comp");
        L4.setBounds(460,160,100,20);
        add(L4);
        //
        JLabel L5 = new JLabel("Car's Brand");
        L5.setBounds(630,160,100,20);
        add(L5);
        //
        JLabel L6 = new JLabel("Availibility");
        L6.setBounds(740,160,100,20);
        add(L6);
        //
        JLabel L7 = new JLabel("Location");
        L7.setBounds(890,160,100,20);
        add(L7);
        
        //for table
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        submit= new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
               String query1 = "SELECT * FROM driver WHERE brand = '" + typeofcar.getSelectedItem() + "'";
               
               Conn conn = new Conn();
               ResultSet rs;
               rs = conn.s.executeQuery(query1);
               table.setModel(DbUtils.resultSetToTableModel(rs));
               
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else {
           setVisible(false);
            new Reception(); 
        }
        
    }
    public static void main(String[] args){
        new Pickup();
    }
}
