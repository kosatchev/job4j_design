package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Deck of 52 playing cards
 *
 * @author kosatchev
 */
public class Deck {

	private final List<Card> deck;

	/**
	 * Creates sorted deck
	 */
	public Deck() {
		this.deck = new LinkedList<>(List.of(
				new Card(Card.Rank.ACE, Card.Suit.CLUBS),
				new Card(Card.Rank.TWO, Card.Suit.CLUBS),
				new Card(Card.Rank.THREE, Card.Suit.CLUBS),
				new Card(Card.Rank.FOUR, Card.Suit.CLUBS),
				new Card(Card.Rank.FIVE, Card.Suit.CLUBS),
				new Card(Card.Rank.SIX, Card.Suit.CLUBS),
				new Card(Card.Rank.SEVEN, Card.Suit.CLUBS),
				new Card(Card.Rank.EIGHT, Card.Suit.CLUBS),
				new Card(Card.Rank.NINE, Card.Suit.CLUBS),
				new Card(Card.Rank.TEN, Card.Suit.CLUBS),
				new Card(Card.Rank.JACK, Card.Suit.CLUBS),
				new Card(Card.Rank.QUEEN, Card.Suit.CLUBS),
				new Card(Card.Rank.KING, Card.Suit.CLUBS),
				new Card(Card.Rank.ACE, Card.Suit.SPADES),
				new Card(Card.Rank.TWO, Card.Suit.SPADES),
				new Card(Card.Rank.THREE, Card.Suit.SPADES),
				new Card(Card.Rank.FOUR, Card.Suit.SPADES),
				new Card(Card.Rank.FIVE, Card.Suit.SPADES),
				new Card(Card.Rank.SIX, Card.Suit.SPADES),
				new Card(Card.Rank.SEVEN, Card.Suit.SPADES),
				new Card(Card.Rank.EIGHT, Card.Suit.SPADES),
				new Card(Card.Rank.NINE, Card.Suit.SPADES),
				new Card(Card.Rank.TEN, Card.Suit.SPADES),
				new Card(Card.Rank.JACK, Card.Suit.SPADES),
				new Card(Card.Rank.QUEEN, Card.Suit.SPADES),
				new Card(Card.Rank.KING, Card.Suit.SPADES),
				new Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
				new Card(Card.Rank.TWO, Card.Suit.DIAMONDS),
				new Card(Card.Rank.THREE, Card.Suit.DIAMONDS),
				new Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
				new Card(Card.Rank.FIVE, Card.Suit.DIAMONDS),
				new Card(Card.Rank.SIX, Card.Suit.DIAMONDS),
				new Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS),
				new Card(Card.Rank.EIGHT, Card.Suit.DIAMONDS),
				new Card(Card.Rank.NINE, Card.Suit.DIAMONDS),
				new Card(Card.Rank.TEN, Card.Suit.DIAMONDS),
				new Card(Card.Rank.JACK, Card.Suit.DIAMONDS),
				new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS),
				new Card(Card.Rank.KING, Card.Suit.DIAMONDS),
				new Card(Card.Rank.ACE, Card.Suit.HEARTS),
				new Card(Card.Rank.TWO, Card.Suit.HEARTS),
				new Card(Card.Rank.THREE, Card.Suit.HEARTS),
				new Card(Card.Rank.FOUR, Card.Suit.HEARTS),
				new Card(Card.Rank.FIVE, Card.Suit.HEARTS),
				new Card(Card.Rank.SIX, Card.Suit.HEARTS),
				new Card(Card.Rank.SEVEN, Card.Suit.HEARTS),
				new Card(Card.Rank.EIGHT, Card.Suit.HEARTS),
				new Card(Card.Rank.NINE, Card.Suit.HEARTS),
				new Card(Card.Rank.TEN, Card.Suit.HEARTS),
				new Card(Card.Rank.JACK, Card.Suit.HEARTS),
				new Card(Card.Rank.QUEEN, Card.Suit.HEARTS),
				new Card(Card.Rank.KING, Card.Suit.HEARTS)
		));
	}

	/**
	 * Returns the number of remaining cards in the deck
	 *
	 * @return number of remaining cards
	 */
	public int getDeckSize() {
		return this.deck.size();
	}

	/**
	 * Pulls a random card from the deck and returns it. The selected card is
	 * removed from the deck.
	 *
	 * @return random card of the deck
	 */
	public Card takeRandom() {
		// нет смысла делать проверку на наличие карт в колоде
		return deck.remove((int) (Math.random() * this.getDeckSize()));
	}

	/**
	 * Pulls next card in order from the deck and returns it. The selected card
	 * is removed from the deck.
	 *
	 * @return the next card in order
	 */
	public Card takeNext() {
		return this.deck.remove(0);
	}

	/**
	 * Shuffle the deck
	 */
	public void shuffle() {
		Collections.shuffle(this.deck);
	}
}
