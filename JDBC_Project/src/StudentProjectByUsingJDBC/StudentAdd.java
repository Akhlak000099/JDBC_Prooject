package StudentProjectByUsingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class StudentAdd extends student {

	public StudentAdd() throws SQLException {
		super(name, ph, address, email);
		// TODO Auto-generated constructor stub
	
	}
	
	public static void Add() throws Exception {
		char s;
		do {
			String url = "jdbc:mysql://localhost:3306/student_data";
			String user = "root";
			String pass = "root";
			
			Scanner ch=new Scanner(System.in);
			System.out.println("Enter your name :");
			name = ch.nextLine();
			
			System.out.println("Enter your phone number :");
			ph = ch.nextLine();
			
			System.out.println("Enter your address :");
			address = ch.nextLine();

			System.out.println("Enter your email :");
			email = ch.nextLine();
			
			String query = " insert into student_table(s_name,s_ph,s_address,s_email) values(?,?,?,?)";

			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,name);
			ps.setString(2,ph);
			ps.setString(3,address);
			ps.setString(4, email);
			
			
			System.out.println("You Inserted Student Details is :\n\t"+"Student Name : "+name+"\n\tStudent Phone Number : "+ph+"\n\tStudent Address : "+address+"\n\tStudent Email : "+email);
			
			int res = ps.executeUpdate();
			System.out.println("Result : "+res);
			ps.close();
			con.close();
			
			System.out.println("Would you like to continue this procsses so press Y / N");
			s=ch.next().charAt(0);
		}while(s=='y' || s=='Y');
		System.out.println("Thank You For Adding Student :-)");
			
	}
	

}
