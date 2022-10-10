package BookManagementWithUsingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookSearch {
	
	// here start the search method for seach by author, title or category;
	public static void search() throws SQLException {
		String name;
	    String category = null;
		String author;
		int choose;
		char s;
		Scanner ch=new Scanner(System.in);
		
		do {
			System.out.println("Search Book Title by Press 1\nSearch Book Author by Press 2\nSearch Book By Category Press 3");
			choose=ch.nextInt();
			
			switch(choose) {
			case 1:
				String url = "jdbc:mysql://localhost:3306/book_management";
				String user = "root";
				String pass = "root";
				
				System.out.println(" Enter your Book Title :");
				name = ch.next();
				
				String query="select * from book_management.book where title=?";
				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, name);
				ResultSet rst = ps.executeQuery();
				System.out.println("BookId\t\tBook Title\t\tBook Author\t\tBook Category\t\tBook Price\n");
		        while(rst.next()) {
//		        	System.out.println();
		           System.out.print(rst.getInt(1)+",");
		           System.out.print("\t\t"+rst.getString(2)+",");
		           System.out.print("\t\t"+rst.getString(3)+",");
		           System.out.print("\t\t"+rst.getString(4)+",");
		           System.out.print("\t\t"+rst.getString(5)+"\n");
		           System.out.println();
		           
		        }
				ps.close();
				con.close();
				
			    break;	
			case 2:
				String url1 = "jdbc:mysql://localhost:3306/book_management";
				String user1 = "root";
				String pass1 = "root";
				
				System.out.println(" Enter your Book Author Name :");
				author = ch.next();
				
				String query1="select * from book_management.book where author=?";
				Connection con1 = DriverManager.getConnection(url1,user1,pass1);
				PreparedStatement ps1 = con1.prepareStatement(query1);
				ps1.setString(1, author);
				ResultSet rst1 = ps1.executeQuery();
				System.out.println("BookId\t\tBook Title\t\tBook Author\t\tBook Category\t\tBook Price\n");
		        while(rst1.next()) {
//		        	System.out.println();
		           System.out.print(rst1.getInt(1)+",");
		           System.out.print("\t\t"+rst1.getString(2)+",");
		           System.out.print("\t\t"+rst1.getString(3)+",");
		           System.out.print("\t\t"+rst1.getString(4)+",");
		           System.out.print("\t\t"+rst1.getString(5)+"\n");
		           System.out.println();
		           
		        }
				ps1.close();
				con1.close();
				
			    break;	
			case 3:
				String url11 = "jdbc:mysql://localhost:3306/book_management";
				String user11 = "root";
				String pass11 = "root";
				
//				System.out.println(" Enter your Book Author Name :");
//				category = ch.next();
				
				System.out.println("Choose which category do you want to search ");
				System.out.println("Press 1 for Comics\nPress 2 for Science\nPress 3 for Fication \nPress 4 for Technology\nPress 5 for other Category to write");
				choose=ch.nextInt();
				switch(choose) {
				case 1:
					category="Comics";
					break;
				case 2:
					category="Science";
					break;
				case 3:
					category="Fication";
					break;
				case 4:
					category="Technology";
					break;
				case 5:
					System.out.println("\nEnter your Book Category ");
					category=ch.next();
					break;
				default:
					System.out.println("Sorry ! you input wrong value :-)");
					break;
				}

				String query11="select * from book_management.book where category=?";
				Connection con11 = DriverManager.getConnection(url11,user11,pass11);
				PreparedStatement ps11 = con11.prepareStatement(query11);
				
				ps11.setString(1,category);
				ResultSet rst11 = ps11.executeQuery();
				System.out.println("BookId\t\tBook Title\t\tBook Author\t\tBook Category\t\tBook Price\n");
		        while(rst11.next()) {
//		        	System.out.println();
		           System.out.print(rst11.getInt(1)+",");
		           System.out.print("\t\t"+rst11.getString(2)+",");
		           System.out.print("\t\t"+rst11.getString(3)+",");
		           System.out.print("\t\t"+rst11.getString(4)+",");
		           System.out.print("\t\t"+rst11.getString(5)+"\n");
		           System.out.println();
		           
		        }
				ps11.close();
				con11.close();
				
			    break;	
			default :
				System.out.println("Sorry ! you input wrong value :-)");
				break;
		}
			System.out.println("Would you like to continue search so press Y / N");
			s=ch.next().charAt(0);
		}while(s=='y' || s=='Y');
		System.out.println("Thank You For Showing Student Details :-)");
		
}
	//end of search method 
}
