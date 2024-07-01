
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Changepin extends JFrame implements ActionListener {
    JLabel accountname,accountnumber,accountbalance,date,lbchoose;
    JLabel lbaccountname,lbaccountnumber;
    JTextField changetextfield;

    JLabel lbdate,change;

    JButton changepin,exit;
    Changepin(){
        setBounds(420,100,700,600);
        getContentPane().setBackground(new Color(0xB1F1D4));
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setBounds(20,130,650,350);
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



        JPanel p3=new JPanel();
        p3.setBounds(10,10,630,330);
        p3.setBackground(new Color(255,253,208));
        p3.setLayout(null);
        p1.add(p3);

        JLabel head=new JLabel("Change Pin");
        head.setBounds(20,0,280,30);
        head.setForeground(new Color(0xE8063309, true));
        head.setFont(new Font("RALEWAY",Font.BOLD,25));
        p3.add(head);





        JPanel p4=new JPanel();
        p4.setBounds(15,30,600,280);
        p4.setBackground(new Color(255,253,208));
        p4.setBorder(BorderFactory.createLineBorder(new Color(0xA19B9B),4));
        p4.setLayout(null);
        p3.add(p4);


        accountname=new JLabel("Account Name:");
        accountname.setBounds(25,10,150,30);
        accountname.setForeground(Color.BLACK);
        accountname.setFont(new Font("RALEWAY",Font.BOLD,18));
        p4.add(accountname);

        lbaccountname=new JLabel();
        lbaccountname.setBounds(200,10,200,30);
        lbaccountname.setForeground(Color.BLACK);
        lbaccountname.setFont(new Font("RALEWAY",Font.BOLD,18));
        p4.add(lbaccountname);

        accountnumber=new JLabel("Account Number:");
        accountnumber.setBounds(25,50,170,30);
        accountnumber.setForeground(Color.BLACK);
        accountnumber.setFont(new Font("RALEWAY",Font.BOLD,18));
        p4.add(accountnumber);

        lbaccountnumber=new JLabel();
        lbaccountnumber.setBounds(200,50,200,30);
        lbaccountnumber.setForeground(Color.BLACK);
        lbaccountnumber.setFont(new Font("RALEWAY",Font.BOLD,18));
        p4.add(lbaccountnumber);

        accountbalance=new JLabel("Account  Type:");
        accountbalance.setForeground(Color.BLACK);
        accountbalance.setBounds(25,90,170,30);
        accountbalance.setFont(new Font("RALEWAY",Font.BOLD,18));
        p4.add(accountbalance);

        lbchoose=new JLabel();
        lbchoose.setBounds(200,90,170,25);
        lbchoose.setFont(new Font("RALEWAY",Font.BOLD,18));
        lbchoose.setForeground(Color.BLACK);
        p4.add(lbchoose);


        date=new JLabel("Open Date:");
        date.setBounds(25,130,100,30);
        date.setForeground(Color.BLACK);
        date.setFont(new Font("RALEWAY",Font.BOLD,18));
        p4.add(date);

        lbdate=new JLabel();
        lbdate.setBounds(200,130,120,25);
        lbdate.setForeground(Color.BLACK);
        lbdate.setFont(new Font("RALEWAY",Font.BOLD,18));
        lbdate.setHorizontalAlignment(JTextField.RIGHT);
        p4.add(lbdate);

        change=new JLabel("Change Pin:");
        change.setBounds(25,170,150,30);
        change.setForeground(Color.BLACK);
        change.setFont(new Font("RALEWAY",Font.BOLD,18));
        p4.add(change);

        changetextfield=new JTextField();
        changetextfield.setBounds(200,170,150,25);
        changetextfield.setBackground(new Color(60, 60, 61, 228));
        changetextfield.setForeground(Color.WHITE);
        changetextfield.setFont(new Font("RALEWAY",Font.BOLD,18));
        changetextfield.setHorizontalAlignment(JTextField.RIGHT);
        p4.add(changetextfield);

        changepin=new JButton("Update");
        changepin.setBounds(250,230,100,28);
        changepin.setBackground(new Color(192,192,192));
        changepin.setFont(new Font("RALEWAY",Font.BOLD,18));
        changepin.setForeground(Color.red);
        changepin.addActionListener(this);
        p4.add(changepin);




        exit=new JButton("BACK");
        exit.setBounds(570,490,100,28);
        exit.setBackground(new Color(192,192,192));
        exit.setFont(new Font("RALEWAY",Font.BOLD,18));
        exit.setForeground(Color.red);
        exit.addActionListener(this);
        add(exit);

        updateAccountDetails();


        setVisible(true);

    }

    private void updateAccountDetails() {
        try {
            Conect obj = new Conect();
            String query = "select * from signups";
            ResultSet rs = obj.co.createStatement().executeQuery(query);
            while (rs.next()) {
                lbaccountname.setText(rs.getString("Name"));
                lbdate.setText(rs.getString("Opendate"));
            }

            String queries = "select * from signuptwoe";
            ResultSet se = obj.co.createStatement().executeQuery(queries);
            while (se.next()) {
                lbaccountnumber.setText(se.getString("Cardnumber"));
                lbchoose.setText(se.getString("Accounttype"));
                changetextfield.setText(se.getString("Password"));
            }
        } catch (SQLException es) {
            System.out.println(es.getMessage());
        }
    }


    private void ChangePin() {
        try {
            String Password = changetextfield.getText();
            Conect obj = new Conect();
            String query = "UPDATE signuptwoe SET Password = ?";
            PreparedStatement ps = obj.co.prepareStatement(query);
            ps.setString(1, Password);
            ps.executeUpdate();
            ps.close();

                JOptionPane.showMessageDialog(null, "Change pin successfully.");
                setVisible(false);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
    }
    public static void main(String[] args) {

        new Changepin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
            new Mainmenu();
        }
        if(e.getSource()==changepin){
            ChangePin();
            setVisible(false);
            new Mainmenu();
        }

    }
}
