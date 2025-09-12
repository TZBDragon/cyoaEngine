public class Item {
    public Item(String Iname, String Idesc, String floor){
        name = Iname;
        itemDescription = Idesc;
        floorDesc = floor;
    }

    public String getName() {
        return name;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getFloorDesc() {
        return floorDesc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setFloorDesc(String floorDesc) {
        this.floorDesc = floorDesc;
    }

    private String name;
    private String itemDescription;
    private String floorDesc;

}