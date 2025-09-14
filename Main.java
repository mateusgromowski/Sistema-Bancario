import java.util.*;
public class Main {
	public static void main(String[] args) {
		String choice = "placeholder";
		Menus menus = new Menus();
		Users users = new Users();
		Scanner sc = new Scanner(System.in);
		while(!choice.equals("0")) {
			menus.mainMenu();
			System.out.print("Sua entrada: ");
			choice = sc.nextLine();
			switch(choice) {
				case "1":
					users.addUser();
					break;
				case "2":
					users.selectUser();
					break;
				case "3":
					users.delUser();
					break;
			}
		}
	}
}