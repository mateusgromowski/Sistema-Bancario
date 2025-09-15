import java.util.*;

public class Accounts {
	private ArrayList<Double> money = new ArrayList<>();
	private double currentMoney;
	private double moneyAmount;
	private double newMoney;
	Scanner sc = new Scanner(System.in);
	double getMoney(int id) {
		return money.get(id);
	}

	void removeIndex(int id) {
		money.remove(id);
	}

	void addMoney() {
		money.add(0.0);
	}

	void withdraw(int id) {
		System.out.print("Insira a quantia de dinheiro que você deseja sacar: ");
		moneyAmount = sc.nextDouble();
		if (moneyAmount > money.get(id)) {
			System.out.println("Saldo insuficiente.");
		} else {
			currentMoney = money.get(id);
			newMoney = currentMoney - moneyAmount;
			money.set(id, newMoney);
			System.out.println("Saque efetuado com sucesso.");
		}	
	}

	void deposit(int id) {
		System.out.print("Insira a quantia de dinheiro que você deseja depositar: ");
		moneyAmount = sc.nextDouble();
		if (moneyAmount <= 0) {
			System.out.println("Valor inválido.");
		} else {
			currentMoney = money.get(id);
			newMoney = currentMoney + moneyAmount;
			money.set(id, newMoney);
			System.out.println("Depósito efetuado com sucesso.");
		}
	}
}