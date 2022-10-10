package StudentProjectByUsingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDelete{

	static void studentDataDelete() throws Exception {
		int  id;
		String name;
		
		char s;
		do {
		String url = "jdbc:mysql://localhost:3306/student_data";
		String user = "root";
		String pass = "root";
		
		Scanner ch=new Scanner(System.in);
		System.out.println("Enter your student id :");
		id = ch.nextInt();
		
		String query = " delete from student_table where s_id=?";
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement ps = con.prepareStatement(query);
		System.out.println(query);
		ps.setInt(1,id);
		int res = ps.executeUpdate();
		System.out.println("Result : "+res);
		ps.close();
		con.close();
		
		System.out.println("Would you like to continue this procsses so press Y / N");
		s=ch.next().charAt(0);
	}while(s=='y' || s=='Y');
	System.out.println("Thank You For Deleting Student :-)");

	}
	public static void main(String[] args) throws Exception {
		studentDataDelete();
	}

}
