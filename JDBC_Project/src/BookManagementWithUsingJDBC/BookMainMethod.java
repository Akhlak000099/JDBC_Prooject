package BookManagementWithUsingJDBC;
import java.sql.SQLException;
import java.util.Scanner;

public class BookMainMethod{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookMainMethod obj=new BookMainMethod();
		try {
			obj.manage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// start the make manage method for to manage all method to call
	public void manage() throws Exception {
		// here make object of bookAdd, bookSearchor BookDisplay for call the all the method and variables 
	BookAdd add=new BookAdd();
	BookSearch search=new BookSearch();
	BookDisplay show=new BookDisplay();
	int choose;
	Scanner ch=new Scanner(System.in);
	char s;
	do {
		System.out.println("Book Add By Press 1\nAll Book Show By Press 2\nBook Search By Author, Category Or Title Press 3");
		choose=ch.nextInt();
		switch(choose) {
		
		case 1:
			add.Add();
			break;
		case 2:
			show.BookshowAll();
     		break;
		case 3:
			search.search();
			break;
		default:
			System.out.println("Sorry Try Again ! You Input Wrong Value");
			break;
		}
		System.out.println("Would you like to continue this procsses so press Y / N");
		s=ch.next().charAt(0);
	}while(s=='y' || s=='Y');
	System.out.println("Thank You For Using Application :-)");
	}
//end of manage method
}
