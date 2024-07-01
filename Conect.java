import java.sql.Connection;
import java.sql.DriverManager;

public class Conect {
    Connection co;

    Conect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            co= DriverManager.getConnection("jdbc:mysql://localhost:3306/BankDatabase?useSSL=false","root","abhi@123");
            System.out.println("Success");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }




}
