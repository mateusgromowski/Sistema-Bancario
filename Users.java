import java.util.*;
public class Users {
	Menus menus = new Menus();
	Accounts accounts = new Accounts();
	private ArrayList<String> name = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	void addUser() {
		System.out.printf("Insira o nome do usuário: ");
		String name = sc.nextLine();
		this.name.add(name);
		accounts.addMoney();
		System.out.println("Usuário adicionado com sucesso.");
	}

	void selectUser() {
		if (name.size() == 0) {
			System.out.println("Não há nenhum usuário registrado.");
		} else {
			for (int i = 0; i < name.size(); i++) {
				System.out.printf("%d - %s - R$%.2f\n", (i + 1), name.get(i), accounts.getMoney(i));		
			}
			System.out.print("Qual id você deseja escolher?: ");
			int id = sc.nextInt();
			sc.nextLine();
			if(id <= 0 || id > (name.size())) {
				System.out.println("ID inválido.");
			} else {
				id--;	
				accountChoices(id);
			}
		}
	}

	void delUser() {
		if (name.size() == 0) {
			System.out.println("Não há nenhum usuário registrado.");
		} else {
			System.out.print("Insira o ID que você deseja deletar: ");
			int id = sc.nextInt();
			sc.nextLine();
			if (id <= 0 || id > (name.size())) {
				System.out.println("ID inválido.");
			} else {
				name.remove(id - 1);
				accounts.removeIndex(id - 1);
				System.out.println("Usuário removido com sucesso.");
			}
		}

	}

	void accountChoices(int id) {
		menus.selectMenu();
		System.out.print("Sua entrada: ");
		String choice = sc.nextLine();
		switch(choice) {
			case "1":
				System.out.println(accounts.getMoney(id));
				break;
			case "2":
				accounts.deposit(id);
				break;
			case "3":
				accounts.withdraw(id);
				break;
		}		
	}
}