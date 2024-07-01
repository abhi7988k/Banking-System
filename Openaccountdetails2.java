
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class Openaccountdetails2 extends JFrame  implements ActionListener {

    JLabel occupation,pannumber,aadhar,senior,accounttype,cardnumber,pinnumber,service;
    JTextField pannumbertextfield,aadhartextfield,cardnumbertextfield;
    Choice  occupationchoose,seniorchoose,accountchoose;
    JPasswordField pinnumberpassword;
    JButton openaccount,exit;
    JCheckBox servicecheckbox, servicecheckbox2, servicecheckbox3, servicecheckbox4, servicecheckbox5, servicecheckbox6;

    Random ran;
    String cardNumber;




    Openaccountdetails2(){
        setBounds(420,10,700,800);
        getContentPane().setBackground(new Color(0xB1F1D4));
        setLayout(null);





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

        JLabel open=new JLabel("Open Bank Account-Page2");
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

        occupation=new JLabel("Occupation:");
        occupation.setBounds(20,30,120,20);
        occupation.setFont(new Font("RALEWAY",Font.BOLD,18));
        occupation.setForeground(Color.BLACK);
        p3.add(occupation);


        occupationchoose=new Choice();
        occupationchoose.add("Salaried");
        occupationchoose.add("Self-Employed");
        occupationchoose.add("Business");
        occupationchoose.add("Student");
        occupationchoose.add("Others");
        occupationchoose.setBounds(200,30,150,25);
        p3.add(occupationchoose);


        pannumber=new JLabel("PAN Number::");
        pannumber.setBounds(20,70,130,20);
        pannumber.setFont(new Font("RALEWAY",Font.BOLD,18));
        pannumber.setForeground(Color.BLACK);
        p3.add(pannumber);
        pannumbertextfield=new JTextField();
        pannumbertextfield.setBounds(200,70,180,25);
        p3.add(pannumbertextfield);

        aadhar=new JLabel("Aadhar Number:");
        aadhar.setBounds(20,110,170,20);
        aadhar.setFont(new Font("RALEWAY",Font.BOLD,18));
        aadhar.setForeground(Color.BLACK);
        p3.add(aadhar);

        aadhartextfield=new JTextField();
        aadhartextfield.setBounds(200,110,180,25);
        p3.add(aadhartextfield);

        senior=new JLabel("Senior Citizen:");
        senior.setBounds(20,150,150,20);
        senior.setFont(new Font("RALEWAY",Font.BOLD,18));
        senior.setForeground(Color.BLACK);
        p3.add(senior);
        seniorchoose=new Choice();
        seniorchoose.add("Yes");
        seniorchoose.add("No");
        seniorchoose.setBounds(200,150,180,25);
        p3.add(seniorchoose);

        accounttype=new JLabel("Account Type:");
        accounttype.setBounds(20,190,150,20);
        accounttype.setFont(new Font("RALEWAY",Font.BOLD,18));
        accounttype.setForeground(Color.BLACK);
        p3.add(accounttype);
        accountchoose=new Choice();
        accountchoose.add("Saving Account");
        accountchoose.add("Current Account");
        accountchoose.add("Fixed Deposit Account");
        accountchoose.add("Recurring Deposit Account");
        accountchoose.setBounds(200,190,180,25);
        p3.add(accountchoose);

        cardnumber=new JLabel("Card Number:");
        cardnumber.setBounds(20,230,150,20);
        cardnumber.setFont(new Font("RALEWAY",Font.BOLD,18));
        cardnumber.setForeground(Color.BLACK);
        p3.add(cardnumber);

        ran = new Random();
        cardNumber = generateCardNumber();

        cardnumbertextfield=new JTextField(cardNumber);
        cardnumbertextfield.setBounds(200,230,180,25);
        cardnumbertextfield.setFont(new Font("RALEWAY",Font.BOLD,18));
        cardnumbertextfield.setForeground(Color.BLACK);
        p3.add(cardnumbertextfield);


        pinnumber=new JLabel("Pin:");
        pinnumber.setBounds(20,270,150,20);
        pinnumber.setFont(new Font("RALEWAY",Font.BOLD,18));
        pinnumber.setForeground(Color.BLACK);
        p3.add(pinnumber);

        pinnumberpassword=new JPasswordField();
        pinnumberpassword.setBounds(200,270,180,25);
        pinnumberpassword.setFont(new Font("RALEWAY",Font.BOLD,18));
        pinnumberpassword.setForeground(Color.BLACK);
        p3.add(pinnumberpassword);

        service=new JLabel("Service Required:");
        service.setBounds(20,310,180,20);
        service.setFont(new Font("RALEWAY",Font.BOLD,18));
        service.setForeground(Color.BLACK);
        p3.add(service);

        servicecheckbox=new JCheckBox("Atm Card");
        servicecheckbox.setFont(new Font("RALEWAY",Font.BOLD,18));
        servicecheckbox.setBounds(20,340,150,20);
        servicecheckbox.setForeground(Color.BLACK);
        servicecheckbox.setBackground(Color.white);
        p3.add( servicecheckbox);

        servicecheckbox2=new JCheckBox("Internet Banking");
        servicecheckbox2.setFont(new Font("RALEWAY",Font.BOLD,18));
        servicecheckbox2.setBounds(220,340,190,20);
        servicecheckbox2.setForeground(Color.BLACK);
        servicecheckbox2.setBackground(Color.white);
        p3.add( servicecheckbox2);

        servicecheckbox3=new JCheckBox("Mobile Banking");
        servicecheckbox3.setFont(new Font("RALEWAY",Font.BOLD,18));
        servicecheckbox3.setBounds(20,380,170,20);
        servicecheckbox3.setForeground(Color.BLACK);
        servicecheckbox3.setBackground(Color.white);
        p3.add( servicecheckbox3);

        servicecheckbox4=new JCheckBox("Email Alert");
        servicecheckbox4.setFont(new Font("RALEWAY",Font.BOLD,18));
        servicecheckbox4.setBounds(220,380,150,20);
        servicecheckbox4.setForeground(Color.BLACK);
        servicecheckbox4.setBackground(Color.white);
        p3.add( servicecheckbox4);

        servicecheckbox5=new JCheckBox("Cheque Bookk");
        servicecheckbox5.setFont(new Font("RALEWAY",Font.BOLD,18));
        servicecheckbox5.setBounds(20,420,170,20);
        servicecheckbox5.setForeground(Color.BLACK);
        servicecheckbox5.setBackground(Color.white);
        p3.add( servicecheckbox5);

        servicecheckbox6=new JCheckBox("E-statement");
        servicecheckbox6.setFont(new Font("RALEWAY",Font.BOLD,18));
        servicecheckbox6.setBounds(220,420,150,20);
        servicecheckbox6.setForeground(Color.BLACK);
        servicecheckbox6.setBackground(Color.white);
        p3.add( servicecheckbox6);




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




        JPanel p5=new JPanel();
        p5.setBounds(400,400,150,60);
        p5.setBackground(new Color(253,253,200));
        p5.setBorder(BorderFactory.createLineBorder(new Color(192,192,192),4));
        p5.setLayout(null);
        p3.add(p5);
        openaccount=new JButton("Open Account");
        openaccount.setBounds(5,5,140,50);
        openaccount.setFont(new Font("RALEWAY",Font.BOLD,15));
        openaccount.setBackground(new Color(0x36EA42));
        openaccount.setForeground(Color.black);
        openaccount.addActionListener(this);
        p5.add(openaccount);


        exit=new JButton("CANCEL");
        exit.setBounds(540,725,130,30);
        exit.setBackground(new Color(192,192,192));
        exit.setFont(new Font("RALEWAY",Font.BOLD,16));
        exit.setForeground(Color.red);
        exit.addActionListener(this);
        add(exit);

        setVisible(true);

    }

    private String generateCardNumber() {
        StringBuilder cardNum = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int group = ran.nextInt(9000) + 1000; // 4-digit group
            if (i > 0) {
                cardNum.append(" ");
            }
            cardNum.append(group);
        }
        return  cardNum.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String Occupation=occupationchoose.getSelectedItem();
        String Pan=pannumbertextfield.getText();
        String Aadhar=aadhartextfield.getText();
        String Senior=seniorchoose.getSelectedItem();
        String Accounttype=accountchoose.getSelectedItem();
        String Cardnumber=cardnumbertextfield.getText();
        String Password=new String(pinnumberpassword.getPassword());
        StringBuilder Service=new StringBuilder();
        if(servicecheckbox.isSelected()){
            Service.append("Atm Card");
        }
        if(servicecheckbox2.isSelected()){
            Service.append("Internet Banking");
        }
        if(servicecheckbox3.isSelected()){
            Service.append("Mobile Banking");
        }
        if(servicecheckbox4.isSelected()){
            Service.append("Email Alert");
        }
        if(servicecheckbox5.isSelected()){
            Service.append("Cheque Book");
        }
        if(servicecheckbox6.isSelected()){
            Service.append("E-statement");
        }

        try{
            if(e.getSource()==openaccount){
                if(Occupation.isEmpty() || Pan.isEmpty() || Aadhar.isEmpty() || Senior.isEmpty() || Accounttype.isEmpty() || Cardnumber.isEmpty() || Password.isEmpty() || Service.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please fill all fields");
                }
                else {
                    Conect obj=new Conect();
                    String Query="insert into signuptwoe values (?,?,?,?,?,?,?,?)";
                    PreparedStatement ps=obj.co.prepareStatement(Query);
                    ps.setString(1,Occupation);
                    ps.setString(2,Pan);
                    ps.setString(3,Aadhar);
                    ps.setString(4,Senior);
                    ps.setString(5,Accounttype);
                    ps.setString(6,Cardnumber);
                    ps.setString(7,Password);
                    ps.setString(8,String.valueOf(Service));
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Submit Successfully");
                    setVisible(false);
                    new Bank();
                }
            }
           if(e.getSource()==exit){
               setVisible(false);
               new Bank();
           }

        }
        catch (Exception es){
            System.out.println(es.getMessage());
        }

    }
    public static void main(String[] args) {

        new Openaccountdetails2();
    }



}
