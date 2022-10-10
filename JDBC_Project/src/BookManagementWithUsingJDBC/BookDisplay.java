package BookManagementWithUsingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDisplay {
// here start the bookshowAll Method for show all book from database
	public static void BookshowAll() throws Exception {
		String url = "jdbc:mysql://localhost:3306/book_management";
		String user = "root";
		String pass = "root";
		
		String display="select * from book";
		Connection con =DriverManager.getConnection(url,user,pass);
		PreparedStatement ps1 = con.prepareStatement(display);
		
		ResultSet rst = ps1.executeQuery();
		System.out.println("BookId\t\tBook Title\t\tBook Author\t\tBook Category\t\tBook Price\n");
        while(rst.next()) {
        	System.out.println();
           System.out.print(rst.getInt(1)+",");
           System.out.print("\t\t"+rst.getString(2)+",");
           System.out.print("\t\t"+rst.getString(3)+",");
           System.out.print("\t\t"+rst.getString(4)+",");
           System.out.print("\t\t"+rst.getString(5));
           System.out.println();
           
        }
		ps1.close();
		con.close();


	}
	//here end of bookshowAll Method
	
}
