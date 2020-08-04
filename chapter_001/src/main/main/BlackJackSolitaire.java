package main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Game logic class
 *
 * @author kosatchev
 */
public class BlackJackSolitaire {

	/**
	 * Game logic
	 */
	public void play() {
		Table table = new Table();
		Deck deck = new Deck();
		Scanner sc = new Scanner(System.in);
		Card nextCard;

		deck.shuffle();

		System.out.println("Добро пожаловать в игру. Для выхода введите \"q\"");

		System.out.println(table.showTable());

		nextCard = deck.takeNext();
		System.out.print("Ваша карта " + nextCard + " . Куда вы ее поместите: ");

		while (true) {
			String in = sc.next();
			if (!isCorrectInput(in)) {
				System.out.print("Введите число между 1 и 20: ");
			} else {
				if (in.equals("q")) {
					System.exit(0);
				}
				int pos = Integer.parseInt(in);
				if (!table.isFreeSlot(pos)) {
					System.out.print("Слот занят картой " + table.showCard(pos)
							+ " . Выберите другое место: ");
				} else {
					System.out.println(String.format("%36s", "*").replace(' ', '*') + "\n");
					table.putCard(nextCard, pos);
					System.out.println(table.showTable());
					if (table.getCardsOnTable() < 16) {
						nextCard = deck.takeNext();
						System.out.print("Ваша карта " + nextCard + " . Куда вы ее поместите: ");
					} else {
						break;
					}
				}
			}
		}

		System.out.println("\nИГРА ОКОНЧЕНА\nВаш счет: " + table.getScore());

	}

	private boolean isCorrectInput(String in) {
		boolean rsl = false;
		String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "q"};
		if (Arrays.asList(arr).contains(in)) {
			rsl = true;
		}
		return rsl;
	}
}
