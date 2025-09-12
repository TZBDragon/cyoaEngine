import java.util.ArrayList;
import java.util.List;

public class Player {
    public Player(String apper, List<Item> inv){
        appearance = apper;
        inventory = inv;
    }
    public Player(String name, List<Item> inventory, String appearance){
        this.name = name;
        this.inventory = inventory;
        this.appearance = appearance;
    }
    public void addItem(Item item){
        inventory.add(item);
    }

    public void setAppearance(String apper){
        appearance = apper;
    }
    public String getAppearance(){
        return appearance;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void removeItem(int i) {
        inventory.remove(i);
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    private String appearance;

    private String name;

    private List<Item> inventory;

}