package def;

import java.sql.ResultSet;
import java.sql.Statement;

public class User extends DBconnection{
	public User(String name, String email, String pass, int mobileno) {
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.Mobileno = mobileno;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	String name;
    String email;
	String pass;
	int Mobileno;
	public static boolean Adminvalid(String email,String pass)throws Exception {
		getConection();
		String query4="select * from Admin where EmailId='"+email+"' AND password='"+pass+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query4);
		if(rs.next())
			return true;
		
		return false;
	}
	public  void cinsert() throws Exception{
		getConection();
		String query="INSERT INTO User values('"+this.name+"','"+this.email+"','"+this.pass+"','"+this.Mobileno+"')";
	  	Statement sat=(Statement)con.createStatement();
	  	sat.executeUpdate(query);
	}
}
