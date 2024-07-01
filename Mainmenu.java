import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Mainmenu extends JFrame implements ActionListener {

    JLabel accountname,accountnumber,accountbalance,date,lbchoose;

    JLabel deposit,withdraw,transaction,changepin;
    JLabel lbaccountname,lbaccountnumber;

    JLabel lbdate;

    JButton exit,checkbalance;
    Mainmenu(){
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

        JPanel p2=new JPanel();
        p2.setBounds(50,180,120,100);
        p2.setBackground(new Color(253,253,200));
        p2.setBorder(BorderFactory.createLineBorder(new Color(0xFF0E0E0E, true),2));
        p2.setLayout(null);
        p1.add(p2);


        ImageIcon j1=new ImageIcon(ClassLoader.getSystemResource("Icon/deposit.png"));
        Image j2=j1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon j3=new ImageIcon(j2);
        JLabel img=new JLabel(j3);
        img.setBounds(10,0,100,100);
        img.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        img.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Open Deoposit Clicked");
                setVisible(false);
                new Deposit();
            }
        });
        p2.add(img);



        JPanel p5=new JPanel();
        p5.setBounds(195,180,120,100);
        p5.setBackground(new Color(253,253,200));
        p5.setBorder(BorderFactory.createLineBorder(new Color(0xFF0E0E0E, true),2));
        p5.setLayout(null);
        p1.add(p5);

        ImageIcon s1=new ImageIcon(ClassLoader.getSystemResource("Icon/withdraw.png"));
        Image s2=s1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon s3=new ImageIcon(s2);
        JLabel imga=new JLabel(s3);
        imga.setBounds(10,0,100,100);
        imga.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imga.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Open Withdraw Clicked");
                setVisible(false);
                new Withdraw();
            }
        });
        p5.add(imga);

        JPanel p6=new JPanel();
        p6.setBounds(335,180,120,100);
        p6.setBackground(new Color(253,253,200));
        p6.setBorder(BorderFactory.createLineBorder(new Color(0xFF0E0E0E, true),2));
        p6.setLayout(null);
        p1.add(p6);

        ImageIcon x1=new ImageIcon(ClassLoader.getSystemResource("Icon/transaction.png"));
        Image x2=x1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon x3=new ImageIcon(x2);
        JLabel imgag=new JLabel(x3);
        imgag.setBounds(10,0,100,100);
        imgag.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imgag.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Open Bank Transaction Clicked");
                setVisible(false);
                new Transaction();

            }
        });
        p6.add(imgag);


        JPanel p7=new JPanel();
        p7.setBounds(480,180,120,100);
        p7.setBackground(new Color(253,253,200));
        p7.setBorder(BorderFactory.createLineBorder(new Color(0xFF0E0E0E, true),2));
        p7.setLayout(null);
        p1.add(p7);

        ImageIcon r1=new ImageIcon(ClassLoader.getSystemResource("Icon/Pin.png"));
        Image r2=r1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon r3=new ImageIcon(r2);
        JLabel imgages=new JLabel(r3);
        imgages.setBounds(10,0,100,100);
        imgages.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imgages.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Open Change Pin Clicked");
                setVisible(false);
                new Changepin();
            }
        });
        p7.add(imgages);






        JPanel p3=new JPanel();
        p3.setBounds(10,10,630,330);
        p3.setBackground(new Color(255,253,208));
        p3.setLayout(null);
        p1.add(p3);

        JLabel head=new JLabel("Account");
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

        date=new JLabel("DATE:");
        date.setBounds(400,10,100,30);
        date.setForeground(Color.BLACK);
        date.setFont(new Font("RALEWAY",Font.BOLD,18));
        p4.add(date);

        lbdate=new JLabel();
        lbdate.setBounds(470,15,120,25);
        lbdate.setForeground(Color.BLACK);
        lbdate.setFont(new Font("RALEWAY",Font.BOLD,18));
        lbdate.setHorizontalAlignment(JTextField.RIGHT);
        p4.add(lbdate);

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
        accountbalance.setBounds(25,90,170,30);
        accountbalance.setForeground(Color.BLACK);
        accountbalance.setFont(new Font("RALEWAY",Font.BOLD,18));
        p4.add(accountbalance);

        lbchoose=new JLabel();
        lbchoose.setBounds(200,90,170,25);
        lbchoose.setFont(new Font("RALEWAY",Font.BOLD,18));
        lbchoose.setForeground(Color.BLACK);
        p4.add(lbchoose);

        deposit=new JLabel("DEPOSIT");
        deposit.setBounds(45,250,100,20);
        deposit.setForeground(Color.blue);
        deposit.setFont(new Font("RALEWAY",Font.BOLD,16));
        p4.add(deposit);

        withdraw=new JLabel("WITHDRAW");
        withdraw.setBounds(185,250,100,20);
        withdraw.setForeground(Color.blue);
        withdraw.setFont(new Font("RALEWAY",Font.BOLD,16));
        p4.add(withdraw);

        transaction=new JLabel("TRANSACTION");
        transaction.setBounds(314,250,140,20);
        transaction.setForeground(Color.blue);
        transaction.setFont(new Font("RALEWAY",Font.BOLD,16));
        p4.add(transaction);

        changepin=new JLabel("CHANGE PIN");
        changepin.setBounds(468,250,150,20);
        changepin.setForeground(Color.blue);
        changepin.setFont(new Font("RALEWAY",Font.BOLD,16));
        p4.add(changepin);

        JPanel p8=new JPanel();
        p8.setBounds(400,50,190,70);
        p8.setBackground(new Color(255,253,208));
        p8.setBorder(BorderFactory.createLineBorder(new Color(0xA19B9B),4));
        p8.setLayout(null);
        p4.add(p8);





        checkbalance=new JButton("Balance Enquiry");
        checkbalance.setBounds(5,5,180,60);
        checkbalance.setFont(new Font("RALEWAY",Font.BOLD,16));
        checkbalance.setBackground(new Color(0x21A22B));
        checkbalance.setBorder(BorderFactory.createEmptyBorder());
        checkbalance.setForeground(Color.black);
        checkbalance.addActionListener(this);
        p8.add(checkbalance);








        exit=new JButton("Exit");
        exit.setBounds(570,490,100,28);
        exit.setBackground(new Color(192,192,192));
        exit.setFont(new Font("RALEWAY",Font.BOLD,18));
        exit.setForeground(Color.red);
        add(exit);
        try {
            Conect obj=new Conect();
            String query="select *from signups";
            ResultSet rs=obj.co.createStatement().executeQuery(query);
            while (rs.next()){
                lbaccountname.setText(rs.getString("Name"));
                lbdate.setText(rs.getString("Opendate"));
            }
            String queries = "select * from signuptwoe";
            ResultSet se = obj.co.createStatement().executeQuery(queries);
            while (se.next()) {
                lbaccountnumber.setText(se.getString("Cardnumber"));
                lbchoose.setText(se.getString("Accounttype"));
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }






        setVisible(true);

    }
    public static void main(String[] args) {

        new Mainmenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
        }
        if(e.getSource()==checkbalance){
            setVisible(false);
            new Balance();
        }
    }
}
