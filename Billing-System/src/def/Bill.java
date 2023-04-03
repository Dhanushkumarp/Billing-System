package def;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bill extends User {

	public Bill(String name, String email, String pass, int mobileno) {
		super(name, email, pass, mobileno);
//		User.email=email;
		// TODO Auto-generated constructor stub
	}
//	static String mail=User.email;
public static int quan;
	public static void GetBill(String mail) throws Exception {
		// TODO Auto-generated method stub
		double tprice=0;
		getConection();
		String query="select * from Bill where Cust_email='"+mail+"'";
		Statement sat=con.createStatement();
		ResultSet res=sat.executeQuery(query);
//		System.out.println(mail);
		System.out.println("Product Id \t Product Name \t Product Quantity \tPrice \t Total price \t Email Id");
		System.out.println();
		while(res.next())
		{
			int pid=res.getInt(1);
			String pname=res.getString(2);
			int pquant=res.getInt(3);
			int price=res.getInt(4);
			double total=res.getInt(5);
//			String email=res.getString(6);
			tprice+=total;
			System.out.println(pid+"\t\t "+pname+"\t\t "+pquant+"\t\t\t"+price+"\t "+total+"\t\t "+mail);
		}
//		String query1="delete from Bill";
//		Statement sat1=con.createStatement();
//		sat1.executeUpdate(query1);
		System.out.println();
		System.out.println("Total Price  "+tprice);
		System.out.println();
		Customer.Custmenu(mail);
	}
	static boolean validProductId(int pid,int quan) throws SQLException {
 		getConection();
		String query4="select P_Quantity from Product where P_Id='"+pid+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query4);
		int qu=0;
		while(rs.next()) {
			qu=rs.getInt(1);
		}
//		System.out.println(qu);
		if(qu>=quan) {
			DBconnection.UptQuan(pid,quan,qu);
			return true;
		}
		else
			return false;
		}
	
	public static boolean validQuan(int quan)throws Exception {
		getConection();
		String query4="select * from Product where P_Quantity=='"+quan+"'";
//		PreparedStatement stmt1=con.prepareStatement(query4);
//		='"+quan+"'
//		stmt1.setInt(1,quan);
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery(query4);
		if(rs.next())
			return true;
		return false;
	}
	public static void Billadd(int pid,int pquan,String mail) throws Exception
	{
		getConection();
		String query="select * from Product where P_Id='"+pid+"'";
		Statement sat=con.createStatement();
		ResultSet res=sat.executeQuery(query);
		while(res.next())
		{
			String pname=res.getString(2);
			int price=res.getInt(4);
			double total=price*pquan;
			String query1="INSERT INTO Bill values('"+pid+"','"+pname+"','"+pquan+"','"+price+"','"+total+"','"+mail+"')";
			Statement sat1=(Statement)con.createStatement();
			sat1.executeUpdate(query1);
		}
	}
	public static void Billmenu(int pid,int pquan,String mail) throws Exception {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Press (y) to Add to cart");
		System.out.println();
		char ch=in.next().charAt(0);
		if(ch=='y') {
			System.out.println();
			Billadd(pid,pquan,mail);
			System.out.println("Product added to cart successfully");
			System.out.println();
		}
		else {
			Customer.Custmenu(mail);
			
		}
	}
}
