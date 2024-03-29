package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Searchroom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    
    Searchroom() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel text = new JLabel("Search For Room");
        text.setFont(new Font("Tahoma",Font.ITALIC,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        bedType = new JComboBox(new String[]{"Single bed","Double bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.white);
        add(bedType);
        
        available = new JCheckBox("only display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        

        
        //
        JLabel L1 = new JLabel("Room Number");
        L1.setBounds(50,160,100,20);
        add(L1);
        //
        JLabel L2 = new JLabel("Availability");
        L2.setBounds(270,160,100,20);
        add(L2);
        //
        JLabel L3 = new JLabel("Cleaning-Status");
        L3.setBounds(450,160,100,20);
        add(L3);
        //
        JLabel L4 = new JLabel("Price");
        L4.setBounds(670,160,100,20);
        add(L4);
        //
        JLabel L5 = new JLabel("Bed Type");
        L5.setBounds(870,160,100,20);
        add(L5);
        
        //for table
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
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
               String query1 = "SELECT * FROM room WHERE bed_type = '" + bedType.getSelectedItem() + "'";
               String query2 = "SELECT * FROM room WHERE availability = 'Available' AND bed_type = '" + bedType.getSelectedItem() + "'";

               Conn conn = new Conn();
               ResultSet rs;
               
               if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
               }else {
                   rs = conn.s.executeQuery(query1);
               }
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
        new Searchroom();
    }
}
