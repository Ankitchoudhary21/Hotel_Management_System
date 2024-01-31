package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox availablecombo,gendercombo,bedcombo;
    
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //for rooms
        JLabel heading = new JLabel("Add Driver");
        heading.setFont(new Font("Tahoma",Font.BOLD|Font.ITALIC,17));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        //for room no
        JLabel name = new JLabel("Dvr Name :- ");
        name.setFont(new Font("Tahoma",Font.ITALIC,16));
        name.setBounds(60,70,120,30);
        add(name);
        
        //textfield for room no
        tfname = new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);
        
        //for room available
        JLabel available = new JLabel("Dvr's age :-");
        available.setFont(new Font("Tahoma",Font.ITALIC,16));
        available.setBounds(60,120,120,30);
        add(available);
        
        //textfield for Driver's age
        tfage = new JTextField();
        tfage.setBounds(200,120,150,30);
        add(tfage);
        
        //for Driver's gender
        JLabel gender = new JLabel("Dvr's Gender :- ");
        gender.setFont(new Font("Tahoma",Font.ITALIC,16));
        gender.setBounds(60,150,120,30);
        add(gender);
        
        //for dropbox of Driver's age
        String genderOptions[] = {"Male","Female"};
        gendercombo = new JComboBox(genderOptions);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        //for car
        JLabel car = new JLabel("Car's Comp :- ");
        car.setFont(new Font("Tahoma",Font.ITALIC,16));
        car.setBounds(60,190,120,30);
        add(car);
        
        //textfield for room price
        tfcompany = new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);
        
        //for car model
        JLabel carmodel = new JLabel("Car's Model :- ");
        carmodel.setFont(new Font("Tahoma",Font.ITALIC,16));
        carmodel.setBounds(60,230,120,30);
        add(carmodel);
        
        //textfield for car model
        tfmodel = new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);
        
        //for driver availability
        JLabel lbavailable = new JLabel("Available");
        lbavailable.setFont(new Font("Tahoma",Font.ITALIC,16));
        lbavailable.setBounds(60,270,120,30);
        add(lbavailable);
        
        //for dropbox of Driver's availability
        String availableOptions[] = {"Avaible","Busy"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        //
        JLabel location = new JLabel("Location :- ");
        location.setFont(new Font("Tahoma",Font.ITALIC,16));
        location.setBounds(60,310,120,30);
        add(location);
        
        //textfield for car model
        tflocation = new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);
        
        
        
        
        
        
        
        //button add room
        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);
        
        //Button for Cancel room
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        setBounds(300,200,980,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String name = tfname.getText();
            String age =  tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfmodel.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();
            
            try {
             Conn conn = new Conn();
             String str = "insert into driver values ('"+name+"', '"+age+"', '"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"' )";
             
             conn.s.executeUpdate(str);
             
             JOptionPane.showMessageDialog(null, "New Driver Added Sucessefully");
             
             setVisible(false);
             
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddDriver();
    }
}
