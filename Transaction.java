import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction extends JFrame implements ActionListener {



   JLabel label1;
    JLabel accountname,accountnumber;
    JLabel lbaccountname,lbaccountnumber;
    JButton exit;
    Transaction(){
        setBounds(420,100,700,600);
        getContentPane().setBackground(new Color(0xB1F1D4));
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setBounds(20,160,650,350);
        p1.setBackground(new Color(0x16ECF3));
        p1.setBorder(BorderFactory.createLineBorder(new Color(0xE5AF0D),4));
        p1.setLayout(null);

        add(p1);

        label1=new JLabel();
        label1.setBounds(20,90,600,200);
        p1.add(label1);


        accountname=new JLabel("Account Name:");
        accountname.setBounds(25,10,170,30);
        accountname.setForeground(Color.BLACK);
        accountname.setFont(new Font("RALEWAY",Font.BOLD,18));
        p1.add(accountname);

        lbaccountname=new JLabel();
        lbaccountname.setBounds(200,10,200,30);
        lbaccountname.setForeground(Color.BLACK);
        lbaccountname.setFont(new Font("RALEWAY",Font.BOLD,18));
        p1.add(lbaccountname);

        accountnumber=new JLabel("Account Number:");
        accountnumber.setBounds(25,50,170,30);
        accountnumber.setForeground(Color.BLACK);
        accountnumber.setFont(new Font("RALEWAY",Font.BOLD,18));
        p1.add(accountnumber);

        lbaccountnumber=new JLabel();
        lbaccountnumber.setBounds(200,50,200,30);
        lbaccountnumber.setForeground(Color.BLACK);
        lbaccountnumber.setFont(new Font("RALEWAY",Font.BOLD,18));
        p1.add(lbaccountnumber);

        JLabel headings=new JLabel("Mini Statement:");
        headings.setBounds(25,90,170,30);
        headings.setForeground(Color.BLACK);
        headings.setFont(new Font("RALEWAY",Font.BOLD,18));
        p1.add(headings);







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



        exit=new JButton("BACK");
        exit.setBounds(570,520,100,28);
        exit.setBackground(new Color(192,192,192));
        exit.setFont(new Font("RALEWAY",Font.BOLD,18));
        exit.setForeground(Color.red);
        exit.addActionListener(this);
        add(exit);

        try{

            Conect obj=new Conect();
            String query="select * from deposits ";
            ResultSet rs=obj.co.createStatement().executeQuery(query);
            while (rs.next()){
                label1.setText(label1.getText() + "<html>"+rs.getString("Depositdate")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Name")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Accountno")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Depositamount")+ "<br><html>");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
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

        new Transaction();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       if(e.getSource()==exit){
           setVisible(false);
           new Mainmenu();
       }


    }


}
