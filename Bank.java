import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Bank extends JFrame implements ActionListener {

       JLabel username,password;
       JTextField usernametextfield;
        JPasswordField passwordtextfield;

       JButton login,exit;
    Bank(){
        super("Banking Management System");
        setBounds(420,100,700,600);
        getContentPane().setBackground(new Color(0xB1F1D4));
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setBounds(20,160,650,300);
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
        p2.setBounds(50,30,200,140);
        p2.setBackground(new Color(0x53B6B9));
        p2.setBorder(BorderFactory.createLineBorder(new Color(0xE7B3B4BE, true),5));
        p2.setLayout(null);
        p1.add(p2);

        ImageIcon j1=new ImageIcon(ClassLoader.getSystemResource("Icon/transaction.png"));
        Image j2=j1.getImage().getScaledInstance(150,120,Image.SCALE_DEFAULT);
        ImageIcon j3=new ImageIcon(j2);
        JLabel img=new JLabel(j3);
        img.setBounds(20,0,150,120);
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
        JLabel head=new JLabel("Open Bank Account");
        head.setBounds(20,200,280,30);
        head.setForeground(new Color(0xE8063309, true));
        head.setFont(new Font("RALEWAY",Font.BOLD,28));
        p1.add(head);

            JPanel p3=new JPanel();
            p3.setBounds(290,30,350,250);
            p3.setBackground(new Color(255,253,208));
            p3.setLayout(null);
            p1.add(p3);

            JLabel user=new JLabel("UserLogin");
            user.setBounds(10,10,100,30);
            user.setForeground(new Color(0xE8063309, true));
            user.setFont(new Font("RALEWAY",Font.BOLD,20));
            p3.add(user);



            JPanel p4=new JPanel();
            p4.setBounds(10,40,330,200);
            p4.setBackground(new Color(255,253,208));
            p4.setBorder(BorderFactory.createLineBorder(new Color(0xA19B9B),4));
            p4.setLayout(null);
            p3.add(p4);

            username=new JLabel("Card No:");
            username.setBounds(20,30,100,20);
            username.setFont(new Font("RALEWAY",Font.BOLD,18));
            username.setForeground(Color.BLACK);
            p4.add(username);

            usernametextfield=new JTextField();
            usernametextfield.setBounds(130,30,180,25);
            p4.add(usernametextfield);

           password=new JLabel("Pin:");
           password.setBounds(20,80,100,20);
           password.setFont(new Font("RALEWAY",Font.BOLD,18));
           password.setForeground(Color.BLACK);
           p4.add(password);
           passwordtextfield=new JPasswordField();
           passwordtextfield.setBounds(130,80,180,25);
            p4.add(passwordtextfield);

            login=new JButton("Login");
            login.setBounds(210,140,100,28);
            login.setBackground(new Color(192,192,192));
            login.addActionListener(this);
            p4.add(login);




           exit=new JButton("Exit");
           exit.setBounds(570,480,100,28);
           exit.setBackground(new Color(192,192,192));
           exit.setFont(new Font("RALEWAY",Font.BOLD,18));
           exit.setForeground(Color.red);
           add(exit);





        setVisible(true);

    }
    public static void main(String[] args) {
        new Bank();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{

            String usernames=usernametextfield.getText();
            String passwords=new String(passwordtextfield.getPassword());
            if(e.getSource()==login){
                Conect obj=new Conect();
                String query="select * from signuptwoe where Cardnumber='"+usernames+"' and password='"+passwords+"'  ";
                ResultSet rs=obj.co.createStatement().executeQuery(query);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login successfully");
                    setVisible(false);
                    new Mainmenu();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }
            }

        }
        catch (Exception es){
            System.out.println(es.getMessage());
        }
    }
}
