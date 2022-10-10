package BookManagementWithUsingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookAdd  extends book{

// here I call constuctor with using super method
	public BookAdd() throws SQLException {
		super(title, author, category, price);
		// TODO Auto-generated constructor stub
	}
	//here start the book add method
	public  void Add() throws Exception {
		int choose;
		char s;
		// do-while loop use for continue this process when condition is true or false
		do {
			String url = "jdbc:mysql://localhost:3306/book_management";
			String user = "root";
			String pass = "root";
			
			Scanner ch=new Scanner(System.in);
			System.out.println("Enter your Book Title :");
			title = ch.nextLine();
			
			System.out.println("Enter your Book Author :");
			author = ch.nextLine();
			
			System.out.println("Choose which category do you want to add ");
			System.out.println("Press 1 for Comics\nPress 2 for Science\nPress 3 for Fication \nPress 4 for Technology\nPress 5 for other Category to write");
			choose=ch.nextInt();
			// here switch case use for give option of category
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

			System.out.println("Enter your Book Price :");
			price = ch.nextFloat();
			
			String query = " insert into book(title,author,category,price) values(?,?,?,?)";

			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,title);
			ps.setString(2,author);
			ps.setString(3,category);
			ps.setFloat(4, price);
			
			
			System.out.println("Your Inserted Book Details is :\n\t"+"Book Title : "+title+"\n\tBook Author : "+author+"\n\tBook Category: "+category+"\n\tBook Price : "+price);
			
			int res = ps.executeUpdate();
			System.out.println("Result : "+res);
			ps.close();
			con.close();
			
			System.out.println("Would you like to continue add student so press Y / N");
			s=ch.next().charAt(0);
		}while(s=='y' || s=='Y');
		System.out.println("Thank You For Adding Student :-)");
			
	}
}