package finalProject;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial")
public class Deck extends LinkedList<Card>{
    
    List <String> values = List.of("2","3","4","6","7","8","9","10","Jack","Queen","King","Ace");
    List <String> names = List.of("Hearts", "Diamonds","Clubs","Spades");
    
    public Deck() {
        for (int i = 0; i < values.size(); i++) {
            int weight = i + 2;
            String value = values.get(i);
            
            for (String name: names) {
                add(new Card(value, name, weight));
            } 
        }
    }

    @Override
    public String toString() {
        
        StringBuilder sb2 = new StringBuilder();
        sb2.append("List of Cards:" + System.lineSeparator());
        
        for (Card card : this) {
            sb2.append("  ").append(card).append(System.lineSeparator());
        }
        return sb2.toString();
        
    }

    public void shuffle() {
        List<Card> card1 = new LinkedList<>(this);
        Random random = new Random();
        
        clear();
        
        while(!card1.isEmpty()) {
            add(card1.remove(random.nextInt(card1.size())));
        }
    }

    public Card draw() {
        return remove(0);
    }
    
    

}
