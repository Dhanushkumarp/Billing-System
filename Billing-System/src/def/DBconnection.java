package def;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {

	 static Connection con=null;
	 static Statement stmt;
	static void getConection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Billing", "root", "#321@toorymlqs");
            stmt=con.createStatement();
//            System.out.println("Connected");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
	public static void Add(int pid, String pname, int pquan, int price,String exp,String brand) throws SQLException {
		getConection();
		String query="INSERT INTO Product values('"+pid+"','"+pname+"','"+pquan+"','"+price+"','"+exp+"','"+brand+"')";
	  	Statement sat=(Statement)con.createStatement();
	  	System.out.println("Product added successfully");
	  	sat.executeUpdate(query);
	}
	public static void UptQuan(int pid,int pquan,int cqu) throws SQLException {
		getConection();
		String query4="UPDATE Product set P_Quantity='"+(cqu-pquan)+"' where P_Id='"+pid+"'";
	  	Statement sat4=(Statement)con.createStatement();
	  	sat4.executeUpdate(query4);	  	 
	}

}
