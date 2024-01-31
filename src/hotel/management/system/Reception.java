package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
   JButton newCustomer,rooms,department,allEmployee,customers,managerInfo,checkout,update,roomStatus,
   pickup,searchRoom,logout;
   
    Reception() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Butoon for New Customer
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(new Color(0, 255, 255));
        newCustomer.setForeground(Color.BLACK);
        newCustomer.setFont(new Font("serif", Font.ITALIC,15));
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        //Butoon for rooms
        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(new Color(0, 255, 255));
        rooms.setForeground(Color.BLACK);
        rooms.setFont(new Font("serif", Font.ITALIC,15));
        rooms.addActionListener(this);
        add(rooms);
        
        //Button for department
        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(new Color(0, 255, 255));
        department.setForeground(Color.BLACK);
        department.setFont(new Font("serif", Font.ITALIC,15));
        department.addActionListener(this);
        add(department);
        
        //Button for allEmployee
        allEmployee = new JButton("All Employee ");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setBackground(new Color(0, 255, 255));
        allEmployee.setForeground(Color.BLACK);
        allEmployee.setFont(new Font("serif", Font.ITALIC,15));
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        //Button for customers
        customers = new JButton("Customers");
        customers.setBounds(10,190,200,30);
        customers.setBackground(new Color(0, 255, 255));
        customers.setForeground(Color.BLACK);
        customers.setFont(new Font("serif", Font.ITALIC,15));
        customers.addActionListener(this);
        add(customers);
        
        //Button for managerInfo
        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10,240,200,30);
        managerInfo.setBackground(new Color(0, 255, 255));
        managerInfo.setForeground(Color.BLACK);
        managerInfo.setFont(new Font("serif", Font.ITALIC,15));
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        //Button for Check out
        checkout = new JButton("Check Out");
        checkout.setBounds(10,280,200,30);
        checkout.setBackground(new Color(0, 255, 255));
        checkout.setForeground(Color.BLACK);
        checkout.setFont(new Font("serif", Font.ITALIC,15));
        checkout.addActionListener(this);
        add(checkout);
        
        //Button for Update Status
        update = new JButton("Update Status");
        update.setBounds(10,320,200,30);
        update.setBackground(new Color(0, 255, 255));
        update.setForeground(Color.BLACK);
        update.setFont(new Font("serif", Font.ITALIC,15));
        update.addActionListener(this);
        add(update);
        
        //Button for Room Status
        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10,360,200,30);
        roomStatus.setBackground(new Color(0, 255, 255));
        roomStatus.setForeground(Color.BLACK);
        roomStatus.setFont(new Font("serif", Font.ITALIC,15));
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        //Button for Pickup Service
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10,400,200,30);
        pickup.setBackground(new Color(0, 255, 255));
        pickup.setForeground(Color.BLACK);
        pickup.setFont(new Font("serif", Font.ITALIC,15));
        pickup.addActionListener(this);
        add(pickup);

        //Button for search room
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,440,200,30);
        searchRoom.setBackground(new Color(0, 255, 255));
        searchRoom.setForeground(Color.BLACK);
        searchRoom.setFont(new Font("serif", Font.ITALIC,15));
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        //Button for logout
        logout = new JButton("LogOut");
        logout.setBounds(10,480,200,30);
        logout.setBackground(new Color(0, 255, 255));
        logout.setForeground(Color.BLACK);
        logout.setFont(new Font("serif", Font.ITALIC,15));
        logout.addActionListener(this);
        add(logout);
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }else if(ae.getSource() == department){
            setVisible(false);
            new Department();
        }else if(ae.getSource() == allEmployee){
            setVisible(false);
            new Employeeinfo();
        }else if(ae.getSource() == managerInfo){
            setVisible(false);
            new Managerinfo();
        }else if(ae.getSource() == customers){
            setVisible(false);
            new Customerinfo();
        }else if(ae.getSource() == searchRoom){
            setVisible(false);
            new Searchroom();
        }else if(ae.getSource() == update ){
            setVisible(false);
            new Updatecheck();
        }else if(ae.getSource() == roomStatus ){
            setVisible(false);
            new Updateroom();
        }else if(ae.getSource() == pickup){
            setVisible(false);
            new Pickup();
        }else if(ae.getSource() == checkout){
            setVisible(false);
            new Checkout();
        }else if(ae.getSource() == logout){
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new Reception();
    }
}
