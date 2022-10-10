package StudentProjectByUsingJDBC;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentMainMethod{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**************************Welcome in Student Managemet Application*****************************");
		StudentMainMethod obj=new StudentMainMethod();
		try {
			obj.switchmethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void switchmethod() throws Exception{
		StudentAdd obj=new StudentAdd();
		studentUpdate obj2 =new studentUpdate();
		StudentDelete obj3=new StudentDelete();
		display obj4=new display();
		char s;
		int choose;
		Scanner ch=new Scanner(System.in);

		do {
			System.out.println(" Press 1 for Add  Details \n Press 2 for Update Details \n Press 3 for Delete \n Press 4 for Display Details ");
			System.out.println("Enter a number ");
			choose=ch.nextInt();
			
			switch(choose) {
			case 1:
				obj.Add();
				break;
			case 2:
				obj2.update();
				break;
			case 3:
				obj3.studentDataDelete();
				break;
			case 4:
				obj4.show();
				break;
			default:
				System.out.println("You input wrong value plz try Again :-)");
				
			}
			
			System.out.println("Would you like to continue this procsses so press Y / N");
			s=ch.next().charAt(0);
		}while(s=='y' || s=='Y');
		System.out.println("Thank You For Adding Student :-)");
			
	}

}
