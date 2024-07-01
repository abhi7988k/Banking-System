import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance extends JFrame implements ActionListener {



    JLabel accountname,accountnumber,enteramount;
    JLabel lbaccountname,lbaccountnumber;
    JTextField getpin;
    JLabel withdrawamount;
    JDateChooser lbdate;
    JButton exit, withdraw;
    Balance(){
        setBounds(420,100,700,600);
        getContentPane().setBackground(new Color(0xB1F1D4));
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setBounds(20,160,650,350);
        p1.setBackground(new Color(0x16ECF3));
        p1.setBorder(BorderFactory.createLineBorder(new Color(0xE5AF0D),4));
        p1.setLayout(null);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icon/pngwing.png"));
        Image i2=i1.getImage().getScaledInstance(120,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(120,30,120,100);
        add(image);

        JLabel heading=new JLabel("M3 BANKING");
        heading.setBounds(280,60,280,40);
        heading.setFont(new Font("RALEWAY",Font.BOLD,40));
        heading.setForeground(Color.blue);
        add(heading);

        JPanel p2=new JPanel();
        p2.setBounds(460,200,150,100);
        p2.setBackground(new Color(0x53B6B9));
        p2.setBorder(BorderFactory.createLineBorder(new Color(0xE7B3B4BE, true),5));
        p2.setLayout(null);
        p1.add(p2);

        ImageIcon j1=new ImageIcon(ClassLoader.getSystemResource("Icon/withdraw.png"));
        Image j2=j1.getImage().getScaledInstance(140,100,Image.SCALE_DEFAULT);
        ImageIcon j3=new ImageIcon(j2);
        JLabel img=new JLabel(j3);
        img.setBounds(10,0,140,100);
        img.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        img.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Open Bank Account Clicked");
                setVisible(false);
                new Openaccountdetails1();
            }
        });
        p2.add(img);


        JPanel p3=new JPanel();
        p3.setBounds(15,10,620,320);
        p3.setBackground(new Color(255,253,208));
        p3.setLayout(null);
        p1.add(p3);

        JLabel user=new JLabel("Balance Enquiry");
        user.setBounds(10,5,180,30);
        user.setForeground(new Color(0xE8063309, true));
        user.setFont(new Font("RALEWAY",Font.BOLD,20));
        p3.add(user);



        JPanel p4=new JPanel();
        p4.setBounds(10,30,600,270);
        p4.setBackground(new Color(255,253,208));
        p4.setBorder(BorderFactory.createLineBorder(new Color(0xA19B9B),4));
        p4.setLayout(null);
        p3.add(p4);




        accountname=new JLabel("Account Name:");
        accountname.setBounds(25,10,170,30);
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

        enteramount=new JLabel("Your Current Balance is :");
        enteramount.setBounds(25,130,320,30);
        enteramount.setForeground(Color.BLACK);
        enteramount.setFont(new Font("RALEWAY",Font.BOLD,18));
        p4.add(enteramount);

        withdrawamount=new JLabel();
        withdrawamount.setBounds(250,130,150,30);
        withdrawamount.setForeground(Color.BLACK);
        withdrawamount.setHorizontalAlignment(JTextField.RIGHT);
        withdrawamount.setBackground(new Color(65,125,128));
        withdrawamount.setFont(new Font("RALEWAY",Font.BOLD,18));
        p4.add(withdrawamount);

        JPanel p5=new JPanel();
        p5.setBounds(30,180,190,70);
        p5.setBackground(new Color(255,253,208));
        p5.setBorder(BorderFactory.createLineBorder(new Color(0xA19B9B),4));
        p5.setLayout(null);
        p4.add(p5);





        withdraw=new JButton("Check Balance");
        withdraw.setBounds(5,5,180,60);
        withdraw.setFont(new Font("RALEWAY",Font.BOLD,16));
        withdraw.setBackground(new Color(0x21A22B));
        withdraw.setBorder(BorderFactory.createEmptyBorder());
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        p5.add(withdraw);




        exit=new JButton("BACK");
        exit.setBounds(570,520,100,28);
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
            }

            String queries = "select * from signuptwoe";
            ResultSet se = obj.co.createStatement().executeQuery(queries);
            while (se.next()) {
                lbaccountnumber.setText(se.getString("Cardnumber"));
            }
        } catch (SQLException es) {
            System.out.println(es.getMessage());
        }
    }







    public static void main(String[] args) {

        new Balance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==exit){
            setVisible(false);
            new Mainmenu();
        }

        if(e.getSource()==withdraw){
            balanceEnquiery();

        }



    }



    public void balanceEnquiery(){
        double balance=0;
        try{
            Conect obj=new Conect();
            String Accountno=lbaccountnumber.getText();
            String query="select * from deposits where Accountno='"+Accountno+"'";
            ResultSet rs=obj.co.createStatement().executeQuery(query);

            while (rs.next()){
                if(rs.getString("type").equals("depsit")){
                    balance = balance + Double.parseDouble(rs.getString("Depositamount"));
                }
                else {
                    balance=balance-Double.parseDouble(rs.getString("Depositamount"));
                }

            }

        }
        catch (Exception es){
            es.printStackTrace();
        }


        withdrawamount.setText(" "+balance);

    }


}
