package finalProject;

import java.util.LinkedList;
import java.util.List;

public class Player {
    
    private String name;
    private List<Card> hand =  new LinkedList<>();
    private int score = 0;
    
    

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void draw(Deck deck) {
        getHand().add(deck.draw());
    }
    
    @Override
    public String toString() {
        StringBuilder sb3 =  new StringBuilder();
        
        sb3.append("Player ").append(name).append("'s hand: ").append(System.lineSeparator());
        
        for (Card card: getHand()) {
            sb3.append(" ").append(card).append("\n");
        }
        return sb3.toString();
    }

    public List<Card> getHand() {
        return hand;
    }

    public Card flip() {
        
        return hand.remove(0);
    }

    public void incrementScore() {
        score = getScore() + 1;
    }

    public int getScore() {
        return score;
    }

}
