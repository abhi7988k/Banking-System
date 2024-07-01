
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Openaccountdetails1 extends JFrame implements ActionListener {

    JLabel name,fathername,email,gender,marital,address,city,state,birthday,pin,income,education;
    JTextField nametextfield,fathernametextfield,emailtextfield,addresstextfield,citytextfield,statetextfield,pintextfield;
    JDateChooser birthChooser;
    JDateChooser upchoose;
    Choice choose,maritalchoose,incomechoose,educationchoose;
    JButton openaccount,exit;



    Openaccountdetails1(){
        setBounds(420,10,700,800);
        getContentPane().setBackground(new Color(0xB1F1D4));
        setLayout(null);



        upchoose = new JDateChooser();
        upchoose.setBounds(520,90,150,25);
        upchoose.setBorder(BorderFactory.createEmptyBorder());
        add(upchoose);

        JPanel p1=new JPanel();
        p1.setBounds(20,120,650,600);
        p1.setBackground(new Color(0x16ECF3));
        p1.setBorder(BorderFactory.createLineBorder(new Color(0xE5AF0D),4));
        p1.setLayout(null);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icon/pngwing.png"));
        Image i2=i1.getImage().getScaledInstance(120,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(120,10,120,100);
        add(image);

        JLabel heading=new JLabel("M3 BANKING");
        heading.setBounds(280,40,280,40);
        heading.setFont(new Font("RALEWAY",Font.BOLD,40));
        heading.setForeground(Color.blue);
        add(heading);

        JPanel p2=new JPanel();
        p2.setBounds(20,20,610,570);
        p2.setBackground(new Color(253,253,200));
        p2.setLayout(null);
        p1.add(p2);

        JLabel open=new JLabel("Open Bank Account-Page1");
        open.setBounds(10,10,320,30);
        open.setForeground(new Color(0xE8063309, true));
        open.setFont(new Font("RALEWAY",Font.BOLD,25));
        p2.add(open);

        JPanel p3=new JPanel();
        p3.setBounds(20,50,570,500);
        p3.setBackground(new Color(253,253,200));
        p3.setBorder(BorderFactory.createLineBorder(new Color(192,192,192),4));
        p3.setLayout(null);
        p2.add(p3);

        name=new JLabel("Name:");
        name.setBounds(20,30,100,20);
        name.setFont(new Font("RALEWAY",Font.BOLD,18));
        name.setForeground(Color.BLACK);
        p3.add(name);

        nametextfield=new JTextField();
        nametextfield.setBounds(200,30,150,25);
        p3.add(nametextfield);


        fathername=new JLabel("Father Name:");
        fathername.setBounds(20,70,130,20);
        fathername.setFont(new Font("RALEWAY",Font.BOLD,18));
        fathername.setForeground(Color.BLACK);
        p3.add(fathername);
        fathernametextfield=new JTextField();
        fathernametextfield.setBounds(200,70,180,25);
        p3.add(fathernametextfield);

        gender=new JLabel("Gender:");
        gender.setBounds(20,110,170,20);
        gender.setFont(new Font("RALEWAY",Font.BOLD,18));
        gender.setForeground(Color.BLACK);
        p3.add(gender);

        choose=new Choice();
        choose.add("Male");
        choose.add("Female");
        choose.setBounds(200,110,180,25);
        p3.add(choose);

        email=new JLabel("Email:");
        email.setBounds(20,150,150,20);
        email.setFont(new Font("RALEWAY",Font.BOLD,18));
        email.setForeground(Color.BLACK);
        p3.add(email);
        emailtextfield=new JTextField();
        emailtextfield.setBounds(200,150,180,25);
        p3.add(emailtextfield);

        marital=new JLabel("Marital Status:");
        marital.setBounds(20,190,170,20);
        marital.setFont(new Font("RALEWAY",Font.BOLD,18));
        marital.setForeground(Color.BLACK);
        p3.add(marital);

        maritalchoose=new Choice();
        maritalchoose.add("Married");
        maritalchoose.add("Bachelor");
        maritalchoose.setBounds(200,190,180,25);
        p3.add(maritalchoose);


        address=new JLabel("Address:");
        address.setBounds(20,230,170,20);
        address.setFont(new Font("RALEWAY",Font.BOLD,18));
        address.setForeground(Color.BLACK);
        p3.add(address);
        addresstextfield=new JTextField();
        addresstextfield.setBounds(200,230,180,25);
        p3.add(addresstextfield);

        city=new JLabel("City:");
        city.setBounds(20,270,170,20);
        city.setFont(new Font("RALEWAY",Font.BOLD,18));
        city.setForeground(Color.BLACK);
        p3.add(city);
        citytextfield=new JTextField();
        citytextfield.setBounds(200,270,180,25);
        p3.add(citytextfield);

        state=new JLabel("State:");
        state.setBounds(20,310,170,20);
        state.setFont(new Font("RALEWAY",Font.BOLD,18));
        state.setForeground(Color.BLACK);
        p3.add(state);
        statetextfield=new JTextField();
        statetextfield.setBounds(200,310,180,25);
        p3.add(statetextfield);

        birthday=new JLabel("D.O.B:");
        birthday.setBounds(20,350,170,20);
        birthday.setFont(new Font("RALEWAY",Font.BOLD,18));
        birthday.setForeground(Color.BLACK);
        p3.add(birthday);
        birthChooser = new JDateChooser();
        birthChooser.setBounds(200,350,180,25);
        birthChooser.setBorder(BorderFactory.createEmptyBorder());
        p3.add(birthChooser);

        pin=new JLabel("Pin code:");
        pin.setBounds(20,390,170,20);
        pin.setFont(new Font("RALEWAY",Font.BOLD,18));
        pin.setForeground(Color.BLACK);
        p3.add(pin);

        pintextfield=new JTextField();
        pintextfield.setBounds(200,390,180,25);
        p3.add(pintextfield);

        income=new JLabel("Income:");
        income.setBounds(20,430,170,20);
        income.setFont(new Font("RALEWAY",Font.BOLD,18));
        income.setForeground(Color.BLACK);
        p3.add(income);

        incomechoose=new Choice();
        incomechoose.add("null");
        incomechoose.add("<1,50,000");
        incomechoose.add("<2,50,000");
        incomechoose.add("<5,00,000");
        incomechoose.add("Upto 10,00,000");
        incomechoose.add("Above 10,00,000");
        incomechoose.setBounds(200,430,180,25);
        p3.add(incomechoose);

        education=new JLabel("Education:");
        education.setBounds(20,470,170,20);
        education.setFont(new Font("RALEWAY",Font.BOLD,18));
        education.setForeground(Color.BLACK);
        p3.add(education);

        educationchoose=new Choice();
        educationchoose.add("Educated");
        educationchoose.add("Non-Educated");
        educationchoose.setBounds(200,470,180,25);
        p3.add(educationchoose);

        JPanel p4=new JPanel();
        p4.setBounds(400,60,150,100);
        p4.setBackground(new Color(253,253,200));
        p4.setBorder(BorderFactory.createLineBorder(new Color(192,192,192),4));
        p4.setLayout(null);
        p3.add(p4);

        ImageIcon j1=new ImageIcon(ClassLoader.getSystemResource("Icon/transaction.png"));
        Image j2=j1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon j3=new ImageIcon(j2);
        JLabel img=new JLabel(j3);
        img.setBounds(20,0,100,100);
        img.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p4.add(img);






        exit=new JButton("Next");
        exit.setBounds(560,725,100,30);
        exit.setBackground(new Color(192,192,192));
        exit.setFont(new Font("RALEWAY",Font.BOLD,18));
        exit.setForeground(Color.red);
        exit.addActionListener(this);
        add(exit);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Name=nametextfield.getText();
        String Fathername=fathernametextfield.getText();
        String Gender=choose.getSelectedItem();
        String Email=emailtextfield.getText();
        String Marital=maritalchoose.getSelectedItem();
        String Address=addresstextfield.getText();
        String City=citytextfield.getText();
        String State=statetextfield.getText();
        String Birthday=((JTextField)birthChooser.getDateEditor().getUiComponent()).getText();
        String Pin=pintextfield.getText();
        String Income=incomechoose.getSelectedItem();
        String Education=educationchoose.getSelectedItem();
        String Opendate=((JTextField)upchoose.getDateEditor().getUiComponent()).getText();

        try{

          if(e.getSource()==exit){
              if(Name.isEmpty() || Fathername.isEmpty() || Gender.isEmpty() || Email.isEmpty() || Marital.isEmpty() || Address.isEmpty() || City.isEmpty() || State.isEmpty() || Birthday.isEmpty() || Pin.isEmpty()|| Income.isEmpty() || Education.isEmpty() || Opendate.isEmpty()){
                  JOptionPane.showMessageDialog(null,"Please fill the Required Field");
              }
              else{
                  Conect obj=new Conect();
                  String query="insert into signups values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                  PreparedStatement ps=obj.co.prepareStatement(query);
                  ps.setString(1,Name);
                  ps.setString(2,Fathername);
                  ps.setString(3,Gender);
                  ps.setString(4,Email);
                  ps.setString(5,Marital);
                  ps.setString(6,Address);
                  ps.setString(7,City);
                  ps.setString(8,State);
                  ps.setString(9,Birthday);
                  ps.setString(10,Pin);
                  ps.setString(11,Income);
                  ps.setString(12,Education);
                  ps.setString(13,Opendate);
                  ps.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Submit Successfully");
                  new Openaccountdetails2();

              }
          }




        }
        catch (Exception es){
            System.out.println(es.getMessage());
        }

    }
    public static void main(String[] args) {

        new Openaccountdetails1();
    }



}
