package main;

/**
 * Single playing card
 *
 * @author kosatchev
 */
public class Card {

	private Rank rank;
	private Suit suit;

	/**
	 * Creates new playing card with rank and suit
	 *
	 * @param rank select rank from card enum
	 * @param suit select suit from card enum
	 */
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	;
	
	/**
	 * Current card rank
	 */
	public enum Rank {
		ACE("A", 1),
		TWO("2", 2),
		THREE("3", 3),
		FOUR("4", 4),
		FIVE("5", 5),
		SIX("6", 6),
		SEVEN("7", 7),
		EIGHT("8", 8),
		NINE("9", 9),
		TEN("10", 10),
		JACK("J", 10),
		QUEEN("Q", 10),
		KING("K", 10);

		private String rank;
		private int score;

		private Rank(String rank, int score) {
			this.rank = rank;
			this.score = score;
		}

		private int getScore() {
			return score;
		}

		private String getRank() {
			return rank;
		}

		@Override
		public String toString() {
			return this.rank;
		}
	}

	/**
	 * Current card suit
	 */
	public enum Suit {
		CLUBS('C'),
		SPADES('S'),
		DIAMONDS('D'),
		HEARTS('H');
//		CLUBS('\u2667'),
//		SPADES('\u2664'),
//		DIAMONDS('\u2666'),
//		HEARTS('\u2665');

		private char icon;

		private Suit(char icon) {
			this.icon = icon;
		}

		@Override
		public String toString() {
			return Character.toString(this.icon);
		}
	}

	/**
	 * Get rank of current card
	 *
	 * @return card rank
	 */
	public String getRank() {
		return this.rank.getRank();
	}

	/**
	 * Get score of current card
	 *
	 * @return card score
	 */
	public int getScore() {
		return this.rank.getScore();
	}

	@Override
	public String toString() {
		return this.rank.toString() + this.suit.toString();
	}

}
