package def;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Product extends Tableformat {
	public Product(int pid, String pname, int pquan, int price, String brand, String exp_date) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pquan = pquan;
		this.price = price;
		this.brand = brand;
		this.exp_date = exp_date;
	}

	int pid;
	String pname;
	int pquan;
	int price;
	String brand;
	String exp_date;
	static Scanner in=new Scanner(System.in);
	public static void ViewProduct() throws Exception {
		new printTable().printResult("Product");
	}
	public static void ViewBill() throws Exception {
		new printTable().printResult("Bill");
	}

	public static void AddProduct() throws Exception {
		System.out.println("Product Id: ");
		int pid=in.nextInt();
		in.nextLine();
		System.out.println("Product Name :");
		String pname=in.next();
		System.out.println("Product Quantity :");
		int pquan=in.nextInt();
		System.out.println("Product Price :");
		int price=in.nextInt();
		in.nextLine();
		System.out.println("Expired Date");
		String expdate=in.next();
		System.out.println("Brand name");
		String brand=in.next();
		DBconnection.Add(pid,pname,pquan,price,expdate,brand);
		Admin.AdminMenu();
	}

//	public static void UpdateProduct() {
//		// TODO Auto-generated method stub
//		
//	}
	



	}


