package finalProject;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class War {
    
    private List<String> members = List.of("Amy", "Stephen", "Michael", "John");
    
    private Random random = new Random();

    public static void main(String[] args) {
        
        new War().run();

    }

    private void run() {
        
        List<String> names = new LinkedList<>(members);
        Player player1 = findPlayer(names);
        Player player2 = findPlayer(names);
        
        System.out.println(player1.getName() + " is playing " + player2.getName());
        
        Deck deck = new Deck();
        deck.shuffle();
        //System.out.println(deck);
        
        
        deal(deck, player1, player2);
        System.out.println(player1);
        System.out.println(player2);
        play(player1, player2);
        declareWinner(player1, player2);
        
    }

    private void declareWinner(Player player1, Player player2) {
        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " is the winner with a score of " + player1.getScore());
        }
        else if (player2.getScore() > player1.getScore()) {
            System.out.println(player2.getName() + " is the winner with a score of " + player2.getScore());
        }
        else if (player1.getScore() == player2.getScore()) {
            System.out.println("It is a Draw. Both players had a score of " + player1.getScore());
        }
    }

    private void play(Player player1, Player player2) {
        int turns = player1.getHand().size();
        
        for (int turn =0; turn < turns; turn++) {
            Card card1 = player1.flip();
            Card card2 = player2.flip();
            
            if (card1.getWeight() > card2.getWeight()) {
                player1.incrementScore();
            }
            else if (card2.getWeight() > card1.getWeight()) {
                player2.incrementScore();
            }
        }
          
        }
    
    private void deal(Deck deck, Player player1, Player player2) {
        int size = deck.size();
        
        for (int index = 0; index < size; index++) {
            if (index % 2 == 0) {
                player1.draw(deck);
             }
            else {
                player2.draw(deck);
            }
        }
    }

    private Player findPlayer(List<String> names) {
        
        int position = random.nextInt(names.size());
        String playerName = names.remove(position);
        return new Player(playerName);
    }
}
