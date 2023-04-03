package def;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Admin extends User{
	static Scanner in=new Scanner(System.in);
	public Admin(String name, String email, String pass, int mobileno) {
		super(name, email, pass, mobileno);
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	static void Adminlogin() throws Exception {
		System.out.println("Email ID :");
		String email=in.next();
		System.out.println("Password :");
		String pass=in.next();
		if(Adminvalid(email,pass))
			System.out.println("Login Successful");
		else {
			System.out.println("Invalid input");
			Adminlogin();
		}
		AdminMenu();
	}
	public static void AdminMenu() throws Exception {
		System.out.println("1.View Product\n2.Add Product\n3.Update Product\n4.View sales Count\n5.Back");
		int n3=in.nextInt();
		if(n3==1) {
			Product.ViewProduct();
			Admin.AdminMenu();
		}
		else if(n3==2)
			Product.AddProduct();
		else if(n3==3)
			UpdateProduct();
		else if(n3==4)
			ViewSales();
		else
			Billing_System.login();
	}
	public static void UpdateProduct()throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.print("1.Product Name\n2.Quantity\n3.Price\n4.EXP Date");
		int n=sc.nextInt();
		sc.nextLine();
 		if(n==1) {
			System.out.print("Product Name: ");
			String strb=sc.nextLine();
			System.out.print("New Product name: ");
			String pname=sc.nextLine();
			DBconnection.getConection();
			String query1="UPDATE Product set P_name='"+pname+"' where P_name='"+strb+"'";
		  	Statement sat1=(Statement)con.createStatement();
		  	sat1.executeUpdate(query1);
		  	System.out.println("New Product Name updated");
		  	AdminMenu();
		}
		else if(n==2) {
			System.out.print("Enter Product Id: ");
			int pid=sc.nextInt();
			System.out.print("Quantity: ");
			int quan=sc.nextInt();
			DBconnection.getConection();
			String query2="UPDATE Product set P_Quantity='"+quan+"' where P_Id='"+pid+"'";
		  	Statement sat2=(Statement)con.createStatement();
		  	sat2.executeUpdate(query2);
		  	System.out.println("New Product Quantity updated");
		  	AdminMenu();
		}
		else if(n==3) {
			System.out.print("Enter Product ID: ");
			int pid=sc.nextInt();
			System.out.print("New Price: ");
			int price=sc.nextInt();
			DBconnection.getConection();
			String query3="UPDATE Product set P_Price='"+price+"' where P_Id='"+pid+"'";
		  	Statement sat3=(Statement)con.createStatement();
		  	sat3.executeUpdate(query3);
		  	System.out.print("New Price is updated");
		  	AdminMenu();
		}
		else if(n==4){
			System.out.print("Enter Product ID: ");
			int pid=sc.nextInt();
			System.out.print("New EXP date: ");
			String expdate=sc.nextLine();
			DBconnection.getConection();
			String query4="UPDATE Product set exp_date='"+expdate+"' where P_Id='"+pid+"'";
		  	Statement sat4=(Statement)con.createStatement();
		  	sat4.executeUpdate(query4);
		  	System.out.println();
		  	System.out.print("New EXP date updated");
		  	AdminMenu();
		}
	}

	public static void ViewSales() throws Exception {
		// TODO Auto-generated method stub
		Product.ViewBill();
//		getConection();
//		String query="select * from Bill";
//		Statement sat3=con.createStatement();
//		ResultSet res3=sat3.executeQuery(query);
//		int count=0;
//		while(res3.next())
//		{
//			
//			 count=res3.getInt(1);
//		}
//		System.out.println();
//		System.out.println("Total sales is "+count);
//		System.out.println();
		AdminMenu();
	}
	

}
