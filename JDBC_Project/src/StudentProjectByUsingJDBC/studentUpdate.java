package StudentProjectByUsingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class studentUpdate  {

	public static void update() throws Exception {
		String name;
		String ph;
		String address;
		String email;
		
		
		Scanner ch=new Scanner(System.in);

		int id;
		int choose;
		char s;
		do {
		System.out.println(" Press 1 for update name \n Press 2 for update phone number \n Press 3 for update Address \n Press 4 for update Email ");
		
		System.out.println("Enter a number :");
		choose = ch.nextInt();
		
		switch(choose) {
		 case 1:
			 String url = "jdbc:mysql://localhost:3306/student_data";
				String user = "root";
				String pass = "root";
				
			System.out.println("Enter student name :");
			name=ch.next();
			 
			System.out.println("Enter student Id :");
			id=ch.nextInt();
			
			String query = " update student_table set s_name = ? where s_id= ?";
			
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,name);
			ps.setInt(2,id);
			
			int res = ps.executeUpdate();
			
			System.out.println("Result : "+res);
			ps.close();
			con.close();
			
			break;
		 
		 case 2:
			 String url1 = "jdbc:mysql://localhost:3306/student_data";
				String user1 = "root";
				String pass1 = "root";
				
			System.out.println("Enter student phone number :");
			ph=ch.next();
			 
			 System.out.println("Enter student Id :");
				id=ch.nextInt();
				
				String query1 = " update student_table set s_ph = ? where s_id= ?";
				
				Connection con1 = DriverManager.getConnection(url1,user1,pass1);
				PreparedStatement ps1 = con1.prepareStatement(query1);
				
				ps1.setString(1,ph);
				ps1.setInt(2,id);
				
				int res1 = ps1.executeUpdate();
				
				System.out.println("Result : "+res1);
				ps1.close();
				con1.close();
				
			    break;
		 case 3:
			   String url2 = "jdbc:mysql://localhost:3306/student_data";
				String user2 = "root";
				String pass2 = "root";
				
			 System.out.println("Enter student Adress :");
			 address=ch.next();
				
			 System.out.println("Enter student Id :");
				id=ch.nextInt();
		
				
				String query2 = " update student_table set s_address = ? where s_id= ?";
				
				Connection con2 = DriverManager.getConnection(url2,user2,pass2);
				PreparedStatement ps2 = con2.prepareStatement(query2);
				
				ps2.setString(1,address);
				ps2.setInt(2,id);
				
				int res2 = ps2.executeUpdate();
				
				System.out.println("Result : "+res2);
				ps2.close();
				con2.close();

			    break;
		 case 4:
			 String url3 = "jdbc:mysql://localhost:3306/student_data";
				String user3 = "root";
				String pass3 = "root";
			 System.out.println("Enter student phone number :");
				email=ch.next();
				
			 System.out.println("Enter student Id :");
				id=ch.nextInt();
				
				String query3 = " update student_table set s_email = ? where s_id= ?";
				
				Connection con3 = DriverManager.getConnection(url3,user3,pass3);
				PreparedStatement ps3 = con3.prepareStatement(query3);
				
				ps3.setString(1,email);
				ps3.setInt(2,id);
				
				int res3 = ps3.executeUpdate();
				
				System.out.println("Result : "+res3);
				ps3.close();
				con3.close();
				
				break;
		default:
			System.out.println("your input wrong value :-)");
		 }
		
		System.out.println("Would you like to continue this procsses so press Y / N");
		s=ch.next().charAt(0);
	}while(s=='y' || s=='Y');
		
	System.out.println("Thank You For Using This Application");
}

}
