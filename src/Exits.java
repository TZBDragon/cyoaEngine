public class Exits{
    public Exits(String name, String exitDesc, String direction, Room exitTo, Boolean isLocked, Item key, String lockDesc){
        this.name = name;
        this.exitDesc = exitDesc;
        this.direction = direction;
        this.exitTo = exitTo;
        this.isLocked = isLocked;
        this.key = key;
        this.lockDesc = lockDesc;
    }
    public Exits(String name, String exitDesc, String direction, Room exitTo){
        this.name = name;
        this.exitDesc = exitDesc;
        this.direction = direction;
        this.exitTo = exitTo;
        this.isLocked = false;
        this.key = null;
        this.lockDesc = null;
    }

    public void unlock(Item key){
        if(this.key == key){
            this.isLocked = false;
        }
    }

    public String getName(){
        return name;
    }

    public String getExitDesc() {
        return exitDesc;
    }

    public String getLockDesc() {
        return lockDesc;
    }

    public String lock(String lockDesc, Item key){
        if(this.key != null){
            if(this.key == key){
                this.isLocked = true;
                this.lockDesc = lockDesc;
                return "The door is now locked";
            }else{
                return "This key doesn't fit this door";
            }
        }
        this.isLocked = true;
        this.key = key;
        this.lockDesc = lockDesc;
        return "The door is now locked";
    }

    public Item getKey() {
        return key;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public String getDirection() {
        return direction;
    }

    public Room getExitTo() {
        return exitTo;
    }

    private String name;
    private String exitDesc;
    private String direction;
    private Room exitTo;
    private Boolean isLocked;
    private Item key;
    private String lockDesc;

}
