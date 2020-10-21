import java.util.Scanner;

public class lab5 { //основной класс
	public static void main(String[] args) {
		System.setProperty("console.encoding","Cp1251");
		Scanner in = new Scanner(System.in);
		card money_now = new card();
		money_now.mon = 13000; // деняк на карте
		wallet wallet_now = new wallet(money_now);
		System.out.println("Hello, this program collects information about your money\n");
		wallet_now.init(29539, 35, 14, money_now);
		wallet_now.output();
		wallet_now.output(); //вывод
		wallet_now.convert();
		wallet_now.purchase();
		wallet_now.output();
	}
}

class card {
	int mon; // деньги на карте
	public card() { //конструктор
		mon = 13000;
	}
	public void purchase() { //покупка
		System.out.println("\nWhat do you want to buy?");
		System.out.println("teapot");
		System.out.println("\nHow much does it cost?");
		System.out.println("3500\n");
		int price = 3500;
		this.mon -= price;	
		System.out.println("Congratulations, you bought a kettle, now you have 9500 rubles left on your card");
	}
}

class wallet {
	card money; //деньги на карте
	int rubles;
	int dollars;
	int euros;

	public wallet(card money){ //конструктор с параметром
		money.mon = 13000;
	}

	public wallet()
	{
		rubles = 0;
		dollars = 0;
		euros = 0;
		money.mon = 13000;
	};

	public void init(int a, int b, int c, card d){
		this.rubles = a;
		this.dollars = b;
		this.euros = c;
		this.money = d;
	} 

	void output() { //вывод
		System.out.println("Now you have: ");
		System.out.printf("Rubles: %s\nDollars: %s\nEuros: %s\nIn card: %d\n", rubles, dollars, euros, money.mon);
	}
	void convert() { //концертация
		System.out.println("\nConvert");
		int rub = 0;
		rub = rubles + dollars*83 + euros*90 + money.mon;
		System.out.printf("\n In rubles: %d", rub);
	}
	void purchase() { //покупка
		this.money.purchase();
	}		
}