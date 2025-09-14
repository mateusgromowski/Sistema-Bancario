import java.util.*;

public class Accounts {
	private ArrayList<Double> money = new ArrayList<>();
	double getMoney(int i) {
		return money.get(i);
	}

	void removeIndex(int id) {
		money.remove(id);
	}

	void addMoney() {
		money.add(0.0);
	}

	double withdraw() {
		return 0;
	}

	double deposit() {
		return 0;
	}
}