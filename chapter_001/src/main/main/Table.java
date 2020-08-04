package main;

/**
 * Playing table
 *
 * @author kosatchev
 */
public class Table {

	private Card[] table = new Card[20];
	private int cardsOnTable = 0;
	private int cardsInTrash = 0;

	/**
	 * Returns number of playing cards on the table
	 *
	 * @return number of playing cards on the table
	 */
	public int getCardsOnTable() {
		return this.cardsOnTable;
	}

	/**
	 * Returns number of playing cards in discard
	 *
	 * @return number of playing cards in discard
	 */
	public int getCardsInTrash() {
		return this.cardsInTrash;
	}

	/**
	 * Check card slot
	 *
	 * @param pos position card on the table
	 * @return true if slot is free and false is not
	 */
	public boolean isFreeSlot(int pos) {
		boolean rsl = false;
		if (this.table[pos - 1] == null) {
			rsl = true;
		}
		return rsl;
	}

	/**
	 * Puts card on selected slot on the table
	 *
	 * @param card card to put on the table
	 * @param pos position card on the table
	 */
	public void putCard(Card card, int pos) {
		table[pos - 1] = card;
		if (pos > 16) {
			this.cardsInTrash += 1;
		} else {
			this.cardsOnTable += 1;
		}
	}

	/**
	 * Returns rank of selected card
	 *
	 * @param pos position card on the table
	 * @return rank of selected card
	 */
	public String getCardRank(int pos) {
		try {
			return table[pos - 1].getRank();
		} catch (NullPointerException e) {
			return "";
		}
	}

	/**
	 * Returns score of selected card
	 *
	 * @param pos position card on the table
	 * @return score of selected card
	 */
	public int getCardScore(int pos) {
		try {
			return table[pos - 1].getScore();
		} catch (NullPointerException e) {
			return 0;
		}
	}

	private int getRowScore(int... pos) {
		int rsl = 0;
		int score = 0;
		boolean aceFlag = false;
		for (int i : pos) {
			score += getCardScore(i);
			if (getCardRank(i).equals("A")) {
				aceFlag = true;
			}
		}
		if (aceFlag && score <= 11) {
			score += 10;
		}
		if (score <= 16) {
			rsl = 1;
		} else if (score == 21 && pos.length == 2) {
			rsl = 10;
		} else {
			switch (score) {
				case 21:
					rsl = 7;
					break;
				case 20:
					rsl = 5;
					break;
				case 19:
					rsl = 4;
					break;
				case 18:
					rsl = 3;
					break;
				case 17:
					rsl = 2;
					break;
				default:
					rsl = 0;
			}
		}
		return rsl;
	}

	/**
	 * total points earned during the game
	 *
	 * @return total points
	 */
	public int getScore() {
		int rsl = 0;
		rsl += getRowScore(1, 2, 3, 4, 5);
		rsl += getRowScore(6, 7, 8, 9, 10);
		rsl += getRowScore(11, 12, 13);
		rsl += getRowScore(14, 15, 16);
		rsl += getRowScore(1, 6);
		rsl += getRowScore(2, 7, 11, 14);
		rsl += getRowScore(3, 8, 12, 15);
		rsl += getRowScore(4, 9, 13, 16);
		rsl += getRowScore(5, 10);
		return rsl;
	}

	/**
	 *
	 * @param pos position card on the table
	 * @return
	 */
	public String showCard(int pos) {
		try {
			return table[pos - 1].toString();
		} catch (NullPointerException e) {
			return Integer.toString(pos) + " ";
		}
	}

	/**
	 *
	 * @return
	 */
	public String showTable() {
		return String.format("Стол:\n"
				+ "%-8s%-8s%-8s%-8s%-8s\n"
				+ "%-8s%-8s%-8s%-8s%-8s\n"
				+ "        %-8s%-8s%-8s\n"
				+ "        %-8s%-8s%-8s\n"
				+ "Сброс:\n"
				+ "    %-8s%-8s%-8s%-8s",
				this.showCard(1), this.showCard(2), this.showCard(3),
				this.showCard(4), this.showCard(5),
				this.showCard(6), this.showCard(7), this.showCard(8),
				this.showCard(9), this.showCard(10),
				this.showCard(11), this.showCard(12), this.showCard(13),
				this.showCard(14), this.showCard(15), this.showCard(16),
				this.showCard(17), this.showCard(18),
				this.showCard(19), this.showCard(20)
		);
	}
}
