package finalProject;

public class Card {
    
    private String name;
    private String value;
    private int weight;

    public Card(String value, String name, int weight) {
        
        this.weight = weight;
        this.name = name;
        this.value = value;
        
    }
    
    @Override
    public String toString() {
        return value + " of " + name;
    }

    
    public int getWeight() {
        return weight;
    }

}
