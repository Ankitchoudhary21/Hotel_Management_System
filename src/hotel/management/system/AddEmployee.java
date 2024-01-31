package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaddhar;
    JRadioButton rbmale,rbfemale,rbother;
    JButton submit;
    JComboBox cbjob;
    
    
    AddEmployee(){
        setLayout(null);
         
        //For Name
        JLabel lbname = new JLabel("Name :- ");
        lbname.setBounds(60,30,120,30);
        lbname.setFont(new Font("Tahoma",Font.ITALIC,17));
        add(lbname);
        
        //Textfield for Name
        tfname = new JTextField();
        tfname.setBounds (200,30,150,30);
        add(tfname);
        
        // For Age
        JLabel lbage = new JLabel("Age :- ");
        lbage.setBounds(60,80,120,30);
        lbage.setFont(new Font("Tahoma",Font.ITALIC,17));
        add(lbage);
        
        //Textfield for Age
        tfage = new JTextField();
        tfage.setBounds (200,80,150,30);
        add(tfage);
        
        //For Gender
        JLabel lbgender = new JLabel("Gender :- ");
        lbgender.setBounds(60,130,120,30);
        lbgender.setFont(new Font("Tahoma",Font.ITALIC,17));
        add(lbgender);
        
        //Radio-Button for Gender
        // For male
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma", Font.ITALIC, 14));
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        //For Female
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("Tahoma", Font.ITALIC, 14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        //for other
        rbother = new JRadioButton("Other");
        rbother.setBounds(370,130,70,30);
        rbother.setFont(new Font("Tahoma", Font.ITALIC, 14));
        rbother.setBackground(Color.white);
        add(rbother);
       
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        bg.add(rbother);
        
        //For Job
        JLabel lbjob = new JLabel("Job :- ");
        lbjob.setBounds(60,180,120,30);
        lbjob.setFont(new Font("Tahoma",Font.ITALIC,17));
        add(lbjob);
        
        //For Drop-Box
        String str[] = {"Front Desk Clerks","Poters","Housekeeping","Kitchen staff","Room Service"," Chefs","Waiters/Waitress", "Manager","Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.white);
        add(cbjob);
        
        //For Salary
        JLabel lbsalary = new JLabel("Salary :- ");
        lbsalary.setBounds(60,230,120,30);
        lbsalary.setFont(new Font("Tahoma",Font.ITALIC,17));
        add(lbsalary);
        
        //Textfield for Salary
        tfsalary = new JTextField();
        tfsalary.setBounds (200,230,150,30);
        add(tfsalary);
        
        //For Phone
        JLabel lbphone = new JLabel("Phone :- ");
        lbphone.setBounds(60,280,120,30);
        lbphone.setFont(new Font("Tahoma",Font.ITALIC,17));
        add(lbphone);
        
        //Textfield for Phone
        tfphone = new JTextField();
        tfphone.setBounds (200,280,150,30);
        add(tfphone);
        
        //For Email
        JLabel lbemail = new JLabel("Email :- ");
        lbemail.setBounds(60,330,120,30);
        lbemail.setFont(new Font("Tahoma",Font.ITALIC,17));
        add(lbemail);
        
        //Textfield for Email
        tfemail = new JTextField();
        tfemail.setBounds (200,330,150,30);
        add(tfemail);
        
        //For Adhar
        JLabel lbadhar = new JLabel("Addhar No :- ");
        lbadhar.setBounds(60,380,120,30);
        lbadhar.setFont(new Font("Tahoma",Font.ITALIC,17));
        add(lbadhar);
        
        //Textfield for Addhar
        tfaddhar = new JTextField();
        tfaddhar.setBounds (200,380,150,30);
        add(tfaddhar);
        
        //For Submit butoon
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);
        
        //for image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,520,370);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String adhar = tfaddhar.getText();
        
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        }else if(rbfemale.isSelected()){
            gender = "Female";
        }else if(rbother.isSelected()){
            gender = "Other";
        }
        
        String job = (String) cbjob.getSelectedItem();
        
        try{
            Conn conn = new Conn();
            
            String query = "insert into employee values('"+name+"','"+ age + "', '"+ gender + "', '"+ job + "', '"+ salary + "', '"+ phone + "', '"+ email + "', '"+ adhar + "')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee added sucessessfully");
            
            setVisible(false);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new AddEmployee();
    }
}
