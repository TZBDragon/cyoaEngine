import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
Thaddeus Z. Booraem
 */

public class Main {

    // Everything can in theory be moved here, but I want to leave it open for other purposes
    public static void main(String[] args){createScreen();}

    //THis is the main portion of everything as it sets up the swing elements then adds the action listener
    public static void createScreen(){
        //gets the monitor resolution
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screen.getWidth();
        int height = (int) screen.getHeight();
        // Creates the main window and sets it's size and to the center of the screen
        JFrame mainWin = new JFrame("Adventure");
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.setSize((width / 2),( height / 2));
        mainWin.setLocationRelativeTo(null); // Somehow sets window to center of screen
        //Creates the panel that will hold all of the components and set it to the same size as the window
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS)); // Layout is set to box because I want to kill the little people in my magic code machine /s
        mainPanel.setSize(mainWin.getWidth(),mainWin.getHeight());
        int panH = mainPanel.getHeight();
        int panW = mainPanel.getWidth();
        mainPanel.setBackground(Color.BLACK);

        // Jtext area is used for having word wrap and scroll functionality
        JTextArea log = new JTextArea("");
        log.setLineWrap(true);
        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);
        JTextField input = new JTextField();

        scrollPane.setPreferredSize(new Dimension(panW - 20, panH - 150));
        input.setPreferredSize(new Dimension(panW - 20, 100));
        log.getPreferredSize();
        log.setText(" Please type begin" + "\n");


        log.setBackground(Color.BLACK);
        input.setBackground(Color.BLACK);
        log.setForeground(Color.LIGHT_GRAY);
        input.setForeground(Color.LIGHT_GRAY);

        mainPanel.add(scrollPane);
        mainPanel.add(input);
        //Where the bulk of the game will happen
        input.addActionListener(new ActionListener() {
            Player player = new Player(null, null);
            Room currRoom = null;
            boolean invOpen;
            boolean hasDropped = false;
            boolean gameStart = false;

            // Declare Objects for game here

            // End Declare Objects

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!gameStart){
                    gameStart = true;
                    createGame();
                }
                checkCMD(input.getText());
                addText("");
            }


            // Sets the log text equal to itself and adds a response if one was provided otherwise does nothing
            public void addText(String response){
                log.setText(log.getText() + input.getText() + "\n");
                if (!response.isEmpty()){
                    log.setText(log.getText() + response + "\n");
                }
                input.setText("");
            }

            public void checkCMD(String input) {
                input = input.toLowerCase();
                String[] inputs = input.split("\\s");
                if (inputs.length == 0){
                    return;
                }
                if(inputs[0].equals("go") || inputs[0].equals("move") || inputs[0].equals("open")){
                    invOpen = false;
                    actionMove(inputs);
                }
                if(inputs[0].equals("look") || inputs[0].equals("check") || inputs[0].equals("examine")){
                    actionInspect(inputs);
                }
                if(inputs[0].equals("help")){
                    invOpen = false;
                    actionHelp();
                }
                if(inputs[0].equals("inventory") || inputs[0].equals("inv")){
                    openInventory(inputs);
                }
                if(inputs[0].equals("take")||inputs[0].equals("pick")){
                    invOpen = false;
                    actionTake(inputs);
                }
                if(inputs[0].equals("drop")){
                    actionDrop(inputs);
                }
                if(inputs[0].equals("use")||inputs[0].equals("put")){
                    actionUse(inputs);
                }

            }
            //Prints a list of commands and what they do
            private void actionHelp() {
                addText("Available actions are \n" +
                        "Go/Move: takes you places \n" +
                        "Look/Examine: looks at items and places \n" +
                        "Help: type help \n" +
                        "Inventory: allows you to look at your inventory \n" +
                        "Take: allows you to pick up an item \n" +
                        "Drop: drops an item \n" +
                        "Use: uses an item \n");
            }
            //Lets the player open their inventory and look at the contents also sets a variable to true so its easer to tell when a player is trying to interact with a item in the world or their inventory
            // Add a way to clear the screen albeit temporarily to display the inventory to make it more visually clear
            private void openInventory(String[] inputs) {
                invOpen = true;
                for(int i = 0; i < player.getInventory().size(); i++){
                    if(player.getInventory().get(i) == null){
                        return;
                    }
                    addText(player.getInventory().get(i).getName()+ " : " + player.getInventory().get(i).getItemDescription());
                }
                if(player.getInventory() == null || player.getInventory().isEmpty()){
                    addText("Your inventory is empty");
                    invOpen = false;
                }

            }

            private void actionTake(String[] inputs) {
                int place = 1;
                if(inputs[1].equals("up") || inputs.length > 2){
                    place += 1;
                }
                for(int i = 0; i < currRoom.getItems().size(); i++){
                    if(inputs[place].equals(currRoom.getItems().get(i).getName())){
                        player.addItem(currRoom.getItems().get(i));
                        addText("You picked up the " + currRoom.getItems().get(i).getName());
                        currRoom.getItems().remove(i);
                        return;
                    }
                }
            }
            //Allows the player to drop an item by searching for it then adding it to the rooms item list then deleting it from the players otherwise advises the player that it can't find the item
            private void actionDrop(String[] inputs) {
                if(invOpen){
                    for(int i = 0; i < player.getInventory().size(); i++){
                        if(player.getInventory().get(i).getName().equals(inputs[1])){
                            currRoom.getItems().add(player.getInventory().get(i));
                            addText("You drop the " + player.getInventory().get(i).getName());
                            addText(player.getInventory().get(i).getFloorDesc());
                            player.removeItem(i);
                            break;
                        }
                    }
                }else if(hasDropped){
                    addText("I can't see anything to drop");
                }else{
                    addText("You need to open your inventory to drop items");
                    hasDropped = true;
                }
            }
            private void actionUse(String[] inputs) {
                if(invOpen){
                    for(int i = 0; i < player.getInventory().size(); i++){
                        if(inputs[1].equals(player.getInventory().get(i).getName())){
                            for(int g = 0; g < currRoom.getExits().size(); g++){
                                if(player.getInventory().get(i) == currRoom.getExits().get(g).getKey()){
                                    currRoom.getExits().get(g).setLocked(false);
                                    addText("You unlocked the " + currRoom.getExits().get(g).getName() + " with " + player.getInventory().get(i).getName());
                                    player.removeItem(i);
                                    return;
                                }else{
                                    addText("I cant use that here");
                                    return;
                                }
                            }
                        }
                    }
                }else{
                    addText("Please open your inventory to use items");
                }

            }
            /*
                Allows you to look at an object that is either on the floor or in the inventory also lets you look at yourself
                You can also look at the room by just typing look
                Works by looping through the inventory or room and searching for a match
                once found it adds that text to the screen
                if you look at yourself it simply adds the text that you gave yourself in the beginning
             */
            private void actionInspect(String[] inputs) {
                int place = 1;
                if(inputs.length > 2){
                    place += 1;
                }
                if(inputs.length == 1){
                    changeRoom(currRoom);
                    return;
                }else{
                    if(invOpen){
                        for(int i = 0; i < player.getInventory().size(); i++){
                            if(inputs[place].equals(player.getInventory().get(i).getName())){
                                addText(player.getInventory().get(i).getItemDescription());
                                return;
                            }
                        }
                    }
                    for(int i =0; i < currRoom.getItems().size(); i++){
                        if(inputs[place].equals(currRoom.getItems().get(i).getName())){
                            addText(currRoom.getItems().get(i).getItemDescription());
                            return;
                        }
                    }
                }
                if(inputs[place].equals("self")|| inputs[place].equals("me") || inputs[place].equals("player")){
                    addText(player.getAppearance());
                }

            }

            /*
            attempts to change rooms by looking for a valid exit provided if ot found or if the string is to short advises the player and returns
            once a valid exit is found it attempts to change room unless it is lock in which case the player will be prompted with the need to use a key on the exit
             */
            private void actionMove(String[] inputs) {
                int place = 1;
                if(inputs.length < 2){
                    addText("Please input a location");
                    return;
                }
                if(inputs[place].equals("to")){
                    place += 1;
                }
                for(int i = 0; i < currRoom.getExits().size(); i++){
                    if(currRoom.getExits().get(i).getDirection().equals(inputs[place])){
                        if(currRoom.getExits().get(i).getLocked()){
                            addText(currRoom.getExits().get(i).getLockDesc());
                            return;
                        }else {
                            changeRoom(currRoom.getExits().get(i).getExitTo());
                        }
                        return;
                    }
                }
            }

            //Changes rooms and adds text to describe what is in the room does so by modifying a global :)
            public void changeRoom(Room room){
                currRoom = room;
                addText(room.getEnterText());
                if(room.getExits() == null || room.getExits().isEmpty()){
                    addText("You're lost. I can't save you");
                    return;
                }
                for(int i = 0; i < room.getExits().size(); i++){
                    if(!room.getExits().get(i).getExitDesc().isEmpty()){
                        addText(room.getExits().get(i).getExitDesc());}
                }
                for(int i = 0; i < room.getItems().size(); i++){
                    addText(room.getItems().get(i).getFloorDesc());
                }
            }
            //For some reason I need to add exits and other things to a list inside a function and not statically so I have to have this for that to work
            public void createGame(){

                player.setInventory(new ArrayList<Item>());
            }

        });

        mainWin.getContentPane().add(mainPanel);
        mainWin.setVisible(true);
    }
}
