package def;
import java.util.*;
public class Billing_System {
	static Scanner in=new Scanner(System.in);
	static void Home() throws Exception {
		System.out.println("1.Login\n2.SignUp\n3.LogOut");
		int n=in.nextInt();
		if(n==1)
			login();
		else if(n==2)
			signup();
		else {
			System.out.println("Thanks for visiting us!");
			System.exit(0);
		}
	}
	static void login() throws Exception
	{
		System.out.println("1.Admin\n2.Customer\n3.Back");
		int n1=in.nextInt();
		if(n1==1)
			Admin.Adminlogin();
		else if(n1==2)
			Customer.Custlogin();
		else 
			Home();
	}
	static void signup() throws Exception
	{
		System.out.println("1.Customer Signup\n2.Back");
		int n2=in.nextInt();
		if(n2==1)
			Customer.Custsignup();
		else
			Home();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                                    Billing System                                                ");
		System.out.println("------------------------------------------------------------------------------------------------------------------");

		Home();
	}

}
