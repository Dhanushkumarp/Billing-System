package def;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Customer extends User{
	static Scanner in=new Scanner(System.in);
	public Customer(String name, String email, String pass, int mobileno) {
		super(name, email, pass, mobileno);
	}
//	String mail=super.email;
	static void Custlogin() throws Exception {
		System.out.println("Email ID :");
		String email=in.next();
		System.out.println("Password :");
		String pass=in.next();
		if(Custvalid(email,pass)) {
			System.out.println("Login Successful");
		Custmenu(email);
		}
		else {
			System.out.println("Invalid input");
			Custlogin();
		}
	}
	private static boolean Custvalid(String email, String pass) throws SQLException {
		// TODO Auto-generated method stub
		getConection();
		String query4="select * from User where EmailId='"+email+"' AND password='"+pass+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query4);
		if(rs.next())
			return true;
		
		return false;
		}
	static String pass="";
	public static String ValidPassword()
    {
		System.out.print("Set Password: ");
		String password=in.next();
         String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(password);
         boolean check=m.find();
         if(!check) {
        	System.out.println("Invalid password");
        	ValidPassword();
         }
         else
        	 pass=password;
        return pass;
    }
	static void Custsignup() throws Exception {
		System.out.println("Name :");
		String name=in.next();
		System.out.println("Email Id :");
		String email=in.next();
		pass=ValidPassword();
		System.out.println("Mobile No :");
		int number=in.nextInt();
//		if(validmobileno(number))
//		{
		Customer obj=new Customer(name,email,pass,number);
			obj.cinsert();
			System.out.println("Sign up succesfully");
//		Billing_System.signup();
			Custmenu(obj.email);
			
//		}
	}
//	public  static boolean validmobileno(int number) {
//		// TODO Auto-generated method stub
//		public  long checkUserMobNo()
//	    {
//	        String mobno = sc.next();
//	        Pattern ptrn = Pattern.compile("^[6-9][0-9]{9}$");
//	        Matcher match = ptrn.matcher(mobno);
//	        boolean check = match.find();
//	        if(check) {
//	            usermob = Long.parseLong(mobno);
//	        }
//	        else {
//	            System.out.println("Enter 10 digit Correct Mobile Number which starts with 9 or 8 or 7 or 6");
//	            System.out.println("Enter Mobile Number ");
//	            checkUserMobNo();
//	        }
//	        return usermob;
//	    }
//		return false;
//	}
	public static void Custmenu(String email) throws Exception {
		System.out.println("1.View Product\n2.Add to cart\n3.Bill\n4.Back");
		int n4=in.nextInt();
		if(n4==1) {
			Product.ViewProduct();
			Custmenu(email);
		}
		else if(n4==2)
			Addcart(email);
		else if(n4==3) {
//			System.out.println(email);
			Bill.GetBill(email);
		}
		else
			Billing_System.signup();

	}
	private static void Addcart(String email) throws Exception {
		System.out.println("Enter the number of Product to add");
		int n5=in.nextInt();
		for(int i=0;i<n5;i++) {
			System.out.println("Product Id :");
			int pid=in.nextInt();
			System.out.println("Product Quantity :");
			int pquan=in.nextInt();
			if(Bill.validProductId(pid,pquan))
			{
				Bill.Billmenu(pid,pquan,email);
				Custmenu(email);
			}
			else
			{
				System.out.println("Invalid Product Id or Product Quantity");
				System.out.println();
				Addcart(email);
			}
			}
		}

}
