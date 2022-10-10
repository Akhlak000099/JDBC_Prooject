package JDBC;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) throws Exception{
		accept();
//		insert();
//		delete();
//		update();
	}
	
	public static void accept() throws Exception {
		String url="jdbc:mysql://localhost:3306/Demo3";
		String user="root";
		String password="root";
		
		String qur="select * from  stud";
		
//		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,user,password);
		PreparedStatement ps = con.prepareStatement(qur);
		
		ResultSet rs=((java.sql.Statement) ps).executeQuery(qur);
		
		String disp="";
		while(rs.next()) {
			disp=rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3)+", "+rs.getString(4);
			System.out.println(disp);
		}
		((Connection) ps).close();
		con.close();
		
		
	}
	static void insert() throws Exception {

		String url = "jdbc:mysql://localhost:3306/Demo3";
		String user = "root";
		String pass = "root";
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Student name : " );
		String st = sc.next();
		
		System.out.println("Enter your Student Phone number :  " );
		int phNo = sc.nextInt();
		
		System.out.println("Enter your Student Email : " );
		String email = sc.next();
		
		String query = " insert into stud(s_name,s_phNo,s_email) values(?,?,?)";
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,st);
		ps.setInt(2,phNo);
		ps.setString(3, email);
		int res = ps.executeUpdate();
		System.out.println("Result : "+res);
		ps.close();
		con.close();
	}
	
	static void delete() throws Exception {
		String url = "jdbc:mysql://localhost:3306/Demo3";
		String user = "root";
		String pass = "root";
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Student name : " );
		String st = sc.next();
		
		String query = "delete from stud where s_name=?";
		
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1,st);
		int res = ps.executeUpdate();
		System.out.println("Result : "+res);
		ps.close();
		con.close();

	}
	
	static void update() throws Exception {
		
  		String url = "jdbc:mysql://localhost:3306/Demo3";
		String user = "root";
		String pass = "root";
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Student name : " );
		String st = sc.next();
		
		System.out.println("Enter your Student id: " );
		int id = sc.nextInt();
		
		String query = " update stud set s_name = ? where s_id= ?";
		
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1,st);
		ps.setInt(2,id);
		int res = ps.executeUpdate();
		
		System.out.println("Result : "+res);
		ps.close();
		con.close();
		
	}
}
