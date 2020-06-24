package rain;

import java.util.Random;

public class Shuffle {

    public static void main(String[] args) {


        String [] cards = {"2","3","4","5","6","7","8","9","10","J", "Q","K", "A"};

        String[] suits = {"club", "diamonds", "hearts", "spades"};

        String [] deck = getDeck(cards, suits);

        printDeck(deck);

        String[] shuffledDeck = getShuffledDeck(deck);

        System.out.println("shuffled");

        printDeck(deck);

    }

    private static String[] getShuffledDeck(String[] deck) {

        Random random = new Random();
        String temp;
        int r;

        for (int k=0; k< deck.length; k++) {

            r = random.nextInt(deck.length - k);

            temp = deck[k];
            deck[k] = deck[r];
            deck[r] = temp;
        }

        return deck;
    }

    private static void printDeck(String[] deck) {
        for (String c : deck) {
            System.out.println(c);
        }
    }

    private static String[] getDeck(String[] cards, String[] suits) {

        String[] deck = new String[52];
        int count = 0;
        for (int i=0; i < cards.length ;i++) {
            for (int j =0;j< suits.length;j++) {
                deck[count] = cards[i].concat(suits[j]);
                count++;
            }
        }

        return deck;
    }
}
