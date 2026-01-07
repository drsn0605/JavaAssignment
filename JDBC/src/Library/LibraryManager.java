package Library;

import java.util.Scanner;

public class LibraryManager {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
//			Scanner sc = new Scanner(System.in);
			System.out.println("Enter opeartion : ");
			System.out.println("1 : Add Book");
			System.out.println("2 : View Book");
			System.out.println("3 : Delete Book");
			System.out.println("4 : Issue Book");
			System.out.println("5 : Exit");
			choice = sc.nextInt();

			LibraryOperation lp = new LibraryOperation();

			if (choice == 1) {
				System.out.println("----ADD BOOK----");
				lp.addbook();
			} else if (choice == 2) {
				System.out.println("----VIEW BOOK----");
				lp.viewbook();
			} else if (choice == 3) {
				System.out.println("----DELETE BOOK----");
				lp.deletebook();
			} else if (choice == 4) {
				System.out.println("----ISSUE BOOK----");
				lp.issuebook();
			} else if (choice == 5) {
				System.out.println("----EXIT----");
			} else {
				System.out.println("Invalid Choice");
			}
//			sc.close();
		} while (choice != 5);
		sc.close();

	}

}
