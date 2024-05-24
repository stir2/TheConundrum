import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JFrame;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

class OrderedPair{

    //Ordered Pairs represent coordinate points in 2D space on the xy plane.
    //An OrderedPair object has two instance variables: 'x' (int) and 'y' (int)

    int x;
    int y;
   
    public OrderedPair(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    //Simple get method for x
    public int x(){
        return x;
    }
    
    //Simple get method for y
    public int y(){
        return y;
    }
    
    //Returns the coordinate form of the OrderedPair object as a String: (x, y)
    //Intended to be printed in the console.
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    //Returns a new OrderedPair object that is equal to this OrderedPair object
    public OrderedPair copyOf(){
        return new OrderedPair(x, y);
    }

    //Returns true if the data represented by this OrderedPair object and the OrderedPair parameter 'other' is the same
    public boolean equals(OrderedPair other){
        return (this.x() == other.x() && this.y() == other.y());
    }

    //Returns true if the data reprented by this OrderedPair object and a new OrderedPair made up of 'x' (int) and 'y' (int) is the same
    public boolean equals(int x, int y){
        return (this.x() == x && this.y() == y);
    }

    //Sets this OrderedPair object's x and y instance variables to the passed 'x' (int) and 'y' (int) parameters
    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Sets this OrderedPair object's x and y instance variables to the passed OrderedPair object's 'x' (int) and 'y' (int) parameters
    public void set(OrderedPair other){
        x = other.x();
        y = other.y();
    }

    //Sets this OrderedPair object's x instance variable to the passed 'x'(int) parameter
    public void setX(int x){
        this.x = x;
    }

    //Sets this OrderedPair object's y instance variable to the passed 'y' (int) parameter
    public void setY(int y){
        this.y = y;
    }

    //Returns a new OrderedPair made up of this.x + dx as 'x' (int) and this.y + dy as 'y' (int)
    public OrderedPair add(int dx, int dy){
        return new OrderedPair(x + dx, y + dy);
    }

    //Returns a new OrderedPair made up of this.x + dxy as 'x' (int) and this.y + dxy as 'y' (int)
    public OrderedPair add(int dxy){
        return new OrderedPair(x + dxy, y + dxy);
    }

    //Returns a new OrderedPair made up of this.x + other.x() as 'x' (int) and this.y + other.y() as 'y' (int)
    public OrderedPair add(OrderedPair other){
        return new OrderedPair(x + other.x(), y + other.y());
    }

    //Returns a new OrderedPair made up of this.x + other.x() as 'x' (int) and this.y as 'y' (int)
    public OrderedPair addX(int dx){
        return new OrderedPair(x + dx, y);
    }

    //Returns a new OrderedPair made up of this.x as 'x' (int) and this.y + other.y() as 'y' (int)
    public OrderedPair addY(int dy){
        return new OrderedPair(x, y + dy);
    }

    //Add method with dx and dy, but sets instead of returns
    public void addAndSet(int dx, int dy){
        x += dx;
        y += dy;
    }

    //Add method with dxy, but sets instead of returns
    public void addAndSet(int dxy){
        x += dxy;
        y += dxy;
    }

    //Add method with other, but sets instead of returns
    public void addAndSet(OrderedPair other){
        x += other.x();
        y += other.y();
    }

    //Add method with dx, but sets instead of returns
    public void addXAndSet(int dx){
        x += dx;
    }

    //Add method with dy, but sets instead of returns
    public void addYAndSet(int dy){
        y += dy;
    }

    //Returns a new OrderedPair object made up of x * px as 'x' (int) and y * py as 'y' (int)
    public OrderedPair multiply(int px, int py){
        return new OrderedPair(x * px, y * py);
    }

    //Returns a new OrderedPair object made up of x * pxy as 'x' (int) and y * pxy as 'y' (int)
    public OrderedPair multiply(int pxy){
        return new OrderedPair(x * pxy, y * pxy);
    }

    //Returns a new OrderedPair object made up of x * other.x() as 'x' (int) and y * other.y() as 'y' (int)
    public OrderedPair multiply(OrderedPair other){
        return new OrderedPair(x * other.x(), y * other.y());
    }

    //Returns a new OrderedPair object made up of x * px as 'x' (int) and y as 'y' (int)
    public OrderedPair multiplyX(int px){
        return new OrderedPair(x * px, y);
    }

    //Returns a new OrderedPair object made up of x as 'x' (int) and y * py as 'y' (int)
    public OrderedPair multiplyY(int py){
        return new OrderedPair(x, y * py);
    }

    //Multiply method with px and py, but sets instead of returns.
    public void multiplyAndSet(int px, int py){
        x *= px;
        y *= py; 
    }

    //Multiply method with pxy and pxy, but sets instead of returns.
    public void multiplyAndSet(int pxy){
        x *= pxy;
        y *= pxy;
    }

    //Multiply method with other, but sets instead of returns.
    public void multiplyAndSet(OrderedPair other){
        x *= other.x();
        y *= other.y();
    }

    //Multiply method with px, but sets instead of returns.
    public void multiplyXAndSet(int px){
        x *= px;
    }

    //Multiply method with py, but sets instead of returns.
    public void multiplyYAndSet(int py){
        y *= py;
    }

    //Sets this.x to be in between minX and maxX, and sets this.y to be in between minY and maxY
    public OrderedPair clamp(int minX, int maxX, int minY, int maxY){
        return new OrderedPair(
            Math.max(minX, Math.min(x, maxX)),
            Math.max(minY, Math.min(y, maxY))
        );
    }

    //Sets this.x and this.y to be in between minXY through maxXY
    public OrderedPair clamp(int minXY, int maxXY){
        return new OrderedPair(
            Math.max(minXY, Math.min(x, maxXY)),
            Math.max(minXY, Math.min(y, maxXY))
        );
    }

    //Clamp method but only for x
    public OrderedPair clampX(int min, int max){
        return new OrderedPair(
            Math.max(min, Math.min(x, max)),
            y
        );
    }

    //Clamp method but only for y
    public OrderedPair clampY(int min, int max){
        return new OrderedPair(
            x,
            Math.max(min, Math.min(y, max))
        );
    }

    //Clamp method with minX, maxX, minY, and maxY, but sets instead of returns.
    public void clampAndSet(int minX, int maxX, int minY, int maxY){
        x = Math.max(minX, Math.min(x, maxX));
        y = Math.max(minY, Math.min(y, maxY));
    }

    //Clamp method with minXY and maxXY  but sets instead of returns.
    public void clampAndSet(int minXY, int maxXY){
        x = Math.max(minXY, Math.min(x, maxXY));
        y = Math.max(minXY, Math.min(y, maxXY));
    }

    //Clamp method for only x, but sets instead of returns
    public void clampXAndSet(int min, int max){
        x = Math.max(min, Math.min(x, max));
    }

    //Clamp method for only y, but sets instead of returns
    public void clampYAndSet(int min, int max){
        y = Math.max(min, Math.min(y, max));
    }

    //Returns a new OrderedDouble object made up of this.x casted as a double for 'x' (double) and this.y casted as a double for 'y' (double)
    public OrderedDouble toOrderedDouble(){
        return new OrderedDouble((double)x, (double)y);
    }

    //Returns true if this.x is within 0 and size.x() and this.y is within 0 and size.y()
    public boolean isWithinBounds(OrderedPair size){
        return x >= 0 && x < size.x() && y >= 0 && y < size.y();
    }

    //Returns the mathematical distance between the two points (this.x, this.y) and (other.x(), other.y())
    public double distanceTo(OrderedPair other){
        return Math.sqrt(Math.pow(other.x() - x, 2) + Math.sqrt(Math.pow(other.x() - x, 2)));
    }

    //Returns the mathematical distance between the two points (this.x, this.y) and (other.x(), other.y())
    public double distanceTo(OrderedDouble other){
        return Math.sqrt(Math.pow(other.x() - x, 2) + Math.sqrt(Math.pow(other.x() - x, 2)));
    }

    //Returns the mathematical distance between the two points (this.x, this.y) and (x, y)
    public double distanceTo(int x, int y){
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.sqrt(Math.pow(y - this.y(), 2)));   
    }

    //Returns the mathematical distance between the two points (this.x, this.y) and (x, y)
    public double distanceTo(double x, double y){
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.sqrt(Math.pow(y - this.y(), 2)));   
    }
}

class OrderedDouble{

    //Ordered Doubles represent coordinate points in 2D space on the xy plane.
    //An OrderedDouble object has two instance variables: 'x' (double) and 'y' (double)

    double x;
    double y;
   
    public OrderedDouble(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    //Simple get method for x
    public double x(){
        return x;
    }
    
    //Simple get method for y
    public double y(){
        return y;
    }
    
    //Returns the coordinate form of the OrderedDouble object as a String: (x, y)
    //Intended to be printed in the console.
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    //Returns a new OrderedDouble object that is equal to this OrderedDouble object
    public OrderedDouble copyOf(){
        return new OrderedDouble(x, y);
    }

    //Returns true if the data represented by this OrderedDouble object and the OrderedDouble parameter 'other' is the same
    public boolean equals(OrderedDouble other){
        return (this.x() == other.x() && this.y() == other.y());
    }

    //Returns true if the data reprented by this OrderedDouble object and a new OrderedDouble made up of 'x' (double) and 'y' (double) is the same
    public boolean equals(double x, double y){
        return (this.x() == x && this.y() == y);
    }

    //Sets this OrderedDouble object's x and y instance variables to the passed 'x' (double) and 'y' (double) parameters
    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    //Sets this OrderedPair object's x and y instance variables to the passed OrderedPair object's 'x' (int) and 'y' (int) parameters
    public void set(OrderedDouble other){
        x = other.x();
        y = other.y();
    }

    //Sets this OrderedDouble object's x instance variable to the passed 'x'(double) parameter
    public void setX(double x){
        this.x = x;
    }

    //Sets this OrderedDouble object's y instance variable to the passed 'y' (double) parameter
    public void setY(double y){
        this.y = y;
    }

    //Returns a new OrderedDouble made up of this.x + dx as 'x' (double) and this.y + dy as 'y' (double)
    public OrderedDouble add(double dx, double dy){
        return new OrderedDouble(x + dx, y + dy);
    }

    //Returns a new OrderedDouble made up of this.x + dxy as 'x' (double) and this.y + dxy as 'y' (double)
    public OrderedDouble add(double dxy){
        return new OrderedDouble(x + dxy, y + dxy);
    }

    //Returns a new OrderedDouble made up of this.x + other.x() as 'x' (double) and this.y + other.y() as 'y' (double)
    public OrderedDouble add(OrderedDouble other){
        return new OrderedDouble(x + other.x(), y + other.y());
    }

    //Returns a new OrderedDouble made up of this.x + other.x() as 'x' (double) and this.y as 'y' (double)
    public OrderedDouble addX(double dx){
        return new OrderedDouble(x + dx, y);
    }

    //Returns a new OrderedDouble made up of this.x as 'x' (double) and this.y + other.y() as 'y' (double)
    public OrderedDouble addY(double dy){
        return new OrderedDouble(x, y + dy);
    }

    //Add method with dx and dy, but sets instead of returns
    public void addAndSet(double dx, double dy){
        x += dx;
        y += dy;
    }

    //Add method with dxy, but sets instead of returns
    public void addAndSet(double dxy){
        x += dxy;
        y += dxy;
    }

    //Add method with other, but sets instead of returns
    public void addAndSet(OrderedDouble other){
        x += other.x();
        y += other.y();
    }

    //Add method with dx, but sets instead of returns
    public void addXAndSet(double dx){
        x += dx;
    }

    //Add method with dy, but sets instead of returns
    public void addYAndSet(double dy){
        y += dy;
    }

    //Returns a new OrderedDouble object made up of x * px as 'x' (double) and y * py as 'y' (double)
    public OrderedDouble multiply(double px, double py){
        return new OrderedDouble(x * px, y * py);
    }

    //Returns a new OrderedDouble object made up of x * pxy as 'x' (double) and y * pxy as 'y' (double)
    public OrderedDouble multiply(double pxy){
        return new OrderedDouble(x * pxy, y * pxy);
    }

    //Returns a new OrderedDouble object made up of x * other.x() as 'x' (double) and y * other.y() as 'y' (double)
    public OrderedDouble multiply(OrderedDouble other){
        return new OrderedDouble(x * other.x(), y * other.y());
    }

    //Returns a new OrderedDouble object made up of x * px as 'x' (double) and y as 'y' (double)
    public OrderedDouble multiplyX(double px){
        return new OrderedDouble(x * px, y);
    }

    //Returns a new OrderedDouble object made up of x as 'x' (double) and y * py as 'y' (double)
    public OrderedDouble multiplyY(double py){
        return new OrderedDouble(x, y * py);
    }

    //Multiply method with px and py, but sets instead of returns.
    public void multiplyAndSet(double px, double py){
        x *= px;
        y *= py; 
    }

    //Multiply method with pxy and pxy, but sets instead of returns.
    public void multiplyAndSet(double pxy){
        x *= pxy;
        y *= pxy; 
    }

    //Multiply method with other, but sets instead of returns.
    public void multiplyAndSet(OrderedDouble other){
        x *= other.x();
        y *= other.y();
    }

    //Multiply method with px, but sets instead of returns.
    public void multiplyXAndSet(double px){
        x *= px;
    }

    //Multiply method with py, but sets instead of returns.
    public void multiplyYAndSet(double py){
        y *= py;
    }

    //Returns a new OrderedDouble object with this.x in between minX and maxX, and sets this.y in between minY and maxY
    public OrderedDouble clamp(double minX, double maxX, double minY, double maxY){
        return new OrderedDouble(
            Math.max(minX, Math.min(x, maxX)),
            Math.max(minY, Math.min(y, maxY))
        );
    }

    //Returns a new OrderedDouble object with this.x in between minXY and maxXY, and sets this.y in between minXY and maxXY
    public OrderedDouble clamp(double minXY, double maxXY){
        return new OrderedDouble(
            Math.max(minXY, Math.min(x, maxXY)),
            Math.max(minXY, Math.min(y, maxXY))
        );
    }

    //Clamp method but only for x
    public OrderedDouble clampX(double min, double max){
        return new OrderedDouble(
            Math.max(min, Math.min(x, max)),
            y
        );
    }

    //Clamp method but only for y
    public OrderedDouble clampY(double min, double max){
        return new OrderedDouble(
            x,
            Math.max(min, Math.min(y, max))
        );
    }

    //Clamp method with minX, maxX, minY, and maxY, but sets instead of returns.
    public void clampAndSet(double minX, double maxX, double minY, double maxY){
        x = Math.max(minX, Math.min(x, maxX));
        y = Math.max(minY, Math.min(y, maxY));
    }

    //Clamp method with minXY and maxXY  but sets instead of returns.
    public void clampAndSet(double minXY, double maxXY){
        x = Math.max(minXY, Math.min(x, maxXY));
        y = Math.max(minXY, Math.min(y, maxXY));
    }

    //Clamp method for only x, but sets instead of returns
    public void clampXAndSet(double min, double max){
        x = Math.max(min, Math.min(x, max));
    }

    //Clamp method for only y, but sets instead of returns
    public void clampYAndSet(double min, double max){
        y = Math.max(min, Math.min(y, max));
    }

    //Returns a new OrderedPair object made up of this.x casted as a int for 'x' (int) and this.y casted as a int for 'y' (int)
    public OrderedPair toOrderedPair(){
        return new OrderedPair((int)x, (int)y);
    }

    //Returns true if this.x is within 0 and size.x() and this.y is within 0 and size.y()
    public boolean isWithinBounds(OrderedPair size){
        return x >= 0 && x < size.x() && y >= 0 && y < size.y();
    }

    //Returns the mathematical distance between the two points (this.x, this.y) and (other.x(), other.y())
    public double distanceTo(OrderedPair other){
        return Math.sqrt(Math.pow(other.x() - x, 2) + Math.sqrt(Math.pow(other.y() - y, 2)));
    }

    //Returns the mathematical distance between the two points (this.x, this.y) and (other.x(), other.y())
    public double distanceTo(OrderedDouble other){
        return Math.sqrt(Math.pow(other.x() - x, 2) + Math.sqrt(Math.pow(other.y() - y, 2)));
    }

    //Returns the mathematical distance between the two points (this.x, this.y) and (x, y)
    public double distanceTo(int x, int y){
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.sqrt(Math.pow(y - this.y(), 2)));   
    }

    //Returns the mathematical distance between the two points (this.x, this.y) and (x, y)
    public double distanceTo(double x, double y){
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.sqrt(Math.pow(y - this.y(), 2)));   
    }
}

class Room{
    //Rooms to be traveled throughout the game
    private String roomID;
    private OrderedPair position;
    private String enterSequence;
    private String roomType;
    private Challenge challenge;
    private String abilityID;
    private Item item;
    private boolean hasDialogueBeenSaid;
    private boolean hasAbilityBeenGiven;
    private boolean isDiscovered;
    private boolean isVisited;
    private boolean isLocked;

    public Room(String roomID, OrderedPair position){
        this.roomID = roomID;
        this.position = position;
        this.roomType = "Start";
        challenge = null;
        item = null;
        isLocked = false;
    }

    public OrderedPair position(){
        return position;
    }

    public Item item(){
        return item;
    }

    public Room makeChallengeRoom(Challenge challenge){
        this.challenge = challenge;
        roomType = "Challenge";
        return this;
    }

    public Room makeItemRoom(String itemID){
        this.item = new Item(itemID);
        roomType = "Item";
        return this;
    }

    public Room makeAbilityRoom(String abilityID){
        this.abilityID = abilityID;
        roomType = "Ability";
        hasAbilityBeenGiven = false;
        return this;
    }

    public Room makeDialogueRoom(){
        roomType = "Dialogue";
        hasDialogueBeenSaid = false;
        return this;
    }

    public Room makeDeathRoom(){
        roomType = "Death";
        return this;
    }
    
    public Room setRoomType(String roomtype){
        this.roomType = roomtype;
        return this;
    }

    public Room discover(){
        isDiscovered = true;
        return this;
    }

    public Room visit(){
        isVisited = true;
        return this;
    }

    public boolean isDiscovered(){
        return isDiscovered;
    }

    public boolean isVisited(){
        return isVisited;
    }

    public String roomType(){
        return roomType;
    }

    public String roomID(){
        return roomID;
    }

    public Room lock(){
        isLocked = true;
        return this;
    }

    public Room unlock(){
        isLocked = false;
        return this;
    }

    public boolean isLocked(){
        return isLocked;
    }

    public Challenge getChallenge(){
        return challenge;
    }

    public String type(){
        return roomType;
    }

    public void dialogueHasIndeedBeenSaid(){
        hasDialogueBeenSaid = true;
    }

    public boolean hasDialogueBeenSaid(){
        return hasDialogueBeenSaid;
    }

    public void abilityHasIndeedBeenGiven(){
        hasAbilityBeenGiven = true;
    }

    public boolean hasAbilityBeenGiven(){
        return hasAbilityBeenGiven;
    }

    public boolean hasItem(){
        return item != null;
    }

    public Item getItem(){
        return item;
    }

    public void collectItem(){
        item = null;
    }
}

class Door{
    //Doors connect two adjacent rooms
    private String doorID;
    private Room room1;
    private Room room2;
    public Door(String doorID, Room room1, Room room2){
        this.doorID = doorID;
        this.room1 = room1;
        this.room2 = room2;
    }
}

class LockedDoor extends Door{
    //Locked doors connect two adjacent rooms but require a key to be traveled through
    private Room room1;
    private Room room2;
    private boolean isUnlocked;
    private String keyID;
    public LockedDoor(String doorID, Room room1, Room room2, String keyID){
        super(doorID, room1, room2);
        isUnlocked = false;
        this.keyID = keyID;
    }
    
    public boolean unlock(ArrayList<Item> items){
        for(Item item : items){
            if(item.id() == keyID){
                isUnlocked = true;
                return true;
            }
        }
        return false;
    }
   
    public boolean isUnlocked(){
        return isUnlocked;
    }
}

class Item{
    //Items are able to be collected by the player, stored in the inventory, and used.
    String itemID;
    boolean isCollected;
    
    public Item(String itemID){
        this.itemID = itemID;
        isCollected = false;
    }
   
    public void collect(Map map){
        map.collectItem(this);
        isCollected = true;
    }
   
    public String id(){
        return itemID;
    }
}

class Challenge{
    //Challenges are able to be completed by the player for a reward or progression through areas
    boolean isCompleted;
    String challengeID;
    OrderedPair position;
       
    public Challenge(String challengeID){
        this.challengeID = challengeID;
    }
       
    public boolean isCompleted(){
        return isCompleted;
    }
   
    public OrderedPair position(){
        return position;
    }
   
    public String challengeID(){
        return challengeID;
    }
   
    public void complete(){
        isCompleted = true;
    }

    public void destroy(int direction){
        //Override this - Maze
    }

    public void playerMove(int direction){
        //Override this - Maze class
    }

    public void frame(){
        //Override this - Platformer and Swarm class
    }

    public boolean isEndScreenDisplayed(){
        //Override this - Swarm class
        return null;
    }

    public void endScreenFrame(){
        //Override this - Swarm class
    }

    public int health(){
        //Override this - Swarm class
        return null;
    }
}

class Maze extends Challenge{
//Mazes are randomly generated and have a start and finish point.
    private OrderedPair size;
    private OrderedPair currentPos;
    private OrderedPair finishPos;
    private boolean isCompleted;
    private int[][] blocks;
    private int distance;
    private int direction;
    private int farthestDistance;
    private OrderedPair farthestPos;
    private OrderedPair playerPos;
    private OrderedPair oldPos;
    private int playerType;
    private int numMoves;
    private int hammersLeft;
    
    public Maze(String challengeID, OrderedPair size){
        super(challengeID);
        this.size = size;
        finishPos = new OrderedPair(size.x() / 2, size.y() / 2);
        currentPos = finishPos;
        //System.out.println("Maze of size " + size.toString() + ", finish position at " + finishPos.toString());
        direction = ((int)(Math.random() * 4)) * 90;
        distance = 0;
        farthestDistance = 0;
        numMoves = 0;
        blocks = new int[size.x()][size.y()];
        blocks[currentPos.x()][currentPos.y()] = 1;
        generateMaze();
        playerPos = farthestPos;
        playerType = 1;
        hammersLeft = 3;
        //System.out.println("start position at " + farthestPos.toString());
    }
    
    private void generateMaze(){
        //Recursive method #1: Move two blocks forward and keep track of the farthest point from the finish position.
        move(direction, 1);
        blocks[currentPos.x()][currentPos.y()] = 1;
        move(direction, 1);
        blocks[currentPos.x()][currentPos.y()] = 1;
        distance++;
        if(distance > farthestDistance){
            farthestDistance = distance;
            farthestPos = currentPos;
        }
        tryDirections(direction);
        move(direction, -2);
        distance--;
    }
    
    private void tryDirections(int startDirection){
        //Recursive method #2: Try all directions until all options are exhausted.
        if((int)(Math.random() * 2) == 1){
            direction += ((int)(Math.random() * 3) - 1) * 90;
        }
        for(int i = 0; i < 4; i++){
            move(direction, 2);
            boolean canMoveForward = currentPos.x() >= 2 && currentPos.x() < blocks.length - 2 && currentPos.y() >= 2 && currentPos.y() < blocks[0].length - 2 && blocks[currentPos.x()][currentPos.y()] == 0;
            move(direction, -2);
            if(canMoveForward){
                generateMaze();
            }
            direction += 90;
        }
        direction = startDirection;
    }

    private void move(int direction, int amount){
        //Move the current selected position in the maze in a direction multiplied by an int amount 
        //The next line is for debugging purposes
        OrderedPair oldPos = currentPos;
        double directionRadians = direction * Math.PI / 180;
        double sinValue = Math.sin(directionRadians) * amount;
        double cosValue = Math.cos(directionRadians) * amount;
        if(Math.abs(sinValue) < 0.00000001){
            sinValue = 0;
        }
        if(Math.abs(cosValue) < 0.00000001){
            cosValue = 0;
        }
        currentPos = new OrderedPair((int)((currentPos.x() + cosValue)), ((int)(currentPos.y() + sinValue)));
        //The next 7 lines are for debugging purposes
        int dx = oldPos.x() - currentPos.x();
        int dy = oldPos.y() - currentPos.y();
        if(dx > 0 && dy > 0){
            System.out.print("Error generating maze, movement angle was not a multiple of 90");
            System.out.print("dx = " + dx + ", dy = " + dy);
            System.out.println(", intended angle = " + direction);
        }
    }

    public void complete(){
        isCompleted = true;
        TheConundrum.clearScreen();
        TheConundrum.feedback = challengeID + " completed in " + numMoves + " moves!";
    }

    public boolean isCompleted(){
        return isCompleted;
    }

    public void playerMove(int direction){
        //Allows the player to move throughout the maze and refreshes the screen
        //Also keeps track of the number of moves taken
        oldPos = playerPos;
        double directionRadians = direction * Math.PI / 180;
        double sinValue = Math.sin(directionRadians);
        double cosValue = Math.cos(directionRadians);
        if(Math.abs(sinValue) < 0.00000001){
            sinValue = 0;
        }
        if(Math.abs(cosValue) < 0.00000001){
            cosValue = 0;
        }
        OrderedPair newPos = new OrderedPair((int)(playerPos.x() + cosValue), (int)(playerPos.y() + sinValue));
        boolean canMoveForward = newPos.x() >= 0 && newPos.x() < blocks.length - 2 && newPos.y() + sinValue >= 0 && newPos.y() < blocks[0].length - 2 && blocks[newPos.x()][newPos.y()] > 0;
        if(canMoveForward){
            playerPos = new OrderedPair((int)((playerPos.x() + cosValue)), ((int)(playerPos.y() + sinValue)));
            blocks[oldPos.x()][oldPos.y()] = 2;
            playerType = (int)(sinValue * 2 + cosValue);
            numMoves++;
            TheConundrum.mazeMoves++;
            //TheConundrum.clearScreen();
            if(playerPos.equals(finishPos)){
                complete();
            }
        }
    }

    public void destroy(int direction){
        if(hammersLeft < 1){
            return;
        }
        double directionRadians = direction * Math.PI / 180;
        double sinValue = Math.sin(directionRadians);
        double cosValue = Math.cos(directionRadians);
        if(Math.abs(sinValue) < 0.00000001){
            sinValue = 0;
        }
        if(Math.abs(cosValue) < 0.00000001){
            cosValue = 0;
        }
        OrderedPair destroyPos = new OrderedPair((int)((playerPos.x() + cosValue)), ((int)(playerPos.y() + sinValue)));
        boolean canMoveForward = destroyPos.x() >= 0 && destroyPos.x() < blocks.length - 2 && destroyPos.y() + sinValue >= 0 && destroyPos.y() < blocks[0].length - 2 && blocks[destroyPos.x()][destroyPos.y()] > 0;
        if(!canMoveForward){
            if(destroyPos.isWithinBounds(size)){
                blocks[destroyPos.x()][destroyPos.y()] = 1;

            }
            playerType = (int)(sinValue * 2 + cosValue);
            hammersLeft--;
            //TheConundrum.clearScreen();
        }
    }

    public String toString(){
        //Used for displaying the maze
        String str = "";

        for(int i = 0; i < (40 - size.y()) / 2; i++){
            str += "\n";
        }

        for(int y = 0; y < blocks[0].length; y++){

            //Center the maze along the x-axis
            for(int i = 0; i < (100 - size.x()) / 2; i++){
                str += " ";
            }

            for(int x = 0; x < blocks.length; x++){
                if(currentPos.equals(new OrderedPair(x, y))){
                    str += "\bwin";
                } else if(playerPos.equals(new OrderedPair(x, y))){
                    if(playerType == -2){
                        str += "^^";
                    } else if(playerType == 2){
                        str += "vv";
                    } else if(playerType == -1){
                        str += "<<";
                    } else if(playerType == 1){
                        str += ">>";
                    }
                } else if(blocks[x][y] == 0){
                    str += "██";
                } else if(blocks[x][y] == 1){
                    str += "  ";
                } else {
                    str += "░░";
                }
            }
            str += "\n";
        }

        //Center the maze along the y-axis
        for(int i = 0; i < (40 - size.y()) / 2; i++){
            str += "\n";
        }

        if(TheConundrum.playerHasAbility("Pipe Hammer")){
            for(int i = 0; i < (100 - size.x()) / 2; i++){
                str += " ";
            }
            str += hammersLeft + " Hammers Left. To use a hammer: Direction + [SPACE]";
        }
        return str;
    }
}

class PlatformerObject{
    OrderedPair position;
    int type;

    public PlatformerObject(){
        this.position = new OrderedPair(0, 0);
        this.type = 0;
    }

    public PlatformerObject(OrderedPair position, int type){
        this.position = position;
        this.type = type;
    }

    public OrderedPair position(){
        return position;
    }

    public int type(){
        return type;
    }
}

class PlatformerStructure{
    OrderedPair size;
    ArrayList<PlatformerObject> objects;
    int difficulty;
    OrderedPair startPos;
    OrderedPair endPos;
    OrderedPair currentPos;
    String structureType;
    String structureCode;

    public PlatformerStructure(OrderedPair size, OrderedPair deltaPos, int difficulty){
        this.size = size;
        this.difficulty = difficulty;
        currentPos = startPos;
        objects = new ArrayList<PlatformerObject>();
        if(deltaPos.equals(new OrderedPair(4, 8))){
            structureType = "2 Slope";
        }
        if(deltaPos.equals(new OrderedPair(4, -8))){
            structureType = "-2 Slope";
        }
        if(deltaPos.equals(new OrderedPair(4, 0))){
            structureType = "Straight Line";
        }
        if(deltaPos.equals(new OrderedPair(8, 4))){
            structureType = "1/2 Slope";
        }
        if(deltaPos.equals(new OrderedPair(8, -4))){
            structureType = "-1/2 Slope";
        }
        if(deltaPos.equals(new OrderedPair(4, 4))){
            structureType = "1 Slope";
        }
        if(deltaPos.equals(new OrderedPair(4, -4))){
            structureType = "-1 Slope";
        }
        generateStructure();
        parseObjects();
    }

    public void generateStructure(){
        if(structureType.equals("Straight Line")){
            if(difficulty == 1){
                structureCode = "001 101 201 301";
            }
    
            if(difficulty == 2){
                structureCode = "001 101 201 301";
            }
    
            if(difficulty == 3){
                structureCode = "001 101 201 301 212";
            }
    
            if(difficulty == 4){
                structureCode = "001 101 201 301 112 212";
            }
        }

        if(structureType.equals("1/2 Slope")){
            if(difficulty == 1){
                structureCode ="001 101 201 301 311 411 511 611 711 721 731";
            }

            if(difficulty == 2){
                structureCode = "001 101 201 301 401 411 421 521 621 721 731 212";
            }

            if(difficulty == 3){
                structureCode = "001 103 205 301 401 501 511 611 711 721 731 622";
            }

            if(difficulty == 4){
                structureCode = "001 103 314 321 421 523 724 731";
            }
        }

        if(structureType.equals("-1/2 Slope")){
            if(difficulty == 1){
                structureCode = "031 021 121 111 211 311 411 401 501 601 701";
            }

            if(difficulty == 2){
                structureCode = "031 131 121 111 211 311 411 401 501 601 701 222";
            }

            if(difficulty == 3){
                structureCode = "031 021 011 001 101 201 301 311 321 401 501 601 611 701 112 212 412 512";
            }

            if(difficulty == 4){
                structureCode = "031 211 222 311 701";
            }
        }

        if(structureType.equals("1 Slope")){
            if(difficulty == 1){
                structureCode = "001 101 111 211 221 321 331";
            }

            if(difficulty == 2){
                structureCode = "001 101 111 121 221 321 331";
            }

            if(difficulty == 3){
                structureCode = "001 211 331";
            }

            if(difficulty == 4){
                structureCode = "001 101 201 301 311 321 331 235 021";
            }
        }

        if(structureType.equals("-1 Slope")){
            if(difficulty == 1){
                structureCode = "031 131 121 111 211 201 301";
            }

            if(difficulty == 2){
                structureCode = "031 021 011 001 101 201 301 112 212";
            }

            if(difficulty == 3){
                structureCode = "031 021 011 001 101 201 301 331 112 324";
            }

            if(difficulty == 4){
                structureCode = "031 201 301 212";
            }
        }

        if(structureType.equals("2 Slope")){
            if(difficulty == 1){
                structureCode = "001 101 201 301 311 321 331 341 351 361 371 221 041 261";
            }

            if(difficulty == 2){
                structureCode = "001 101 201 301 311 321 331 341 351 361 371 121 241 051";
            }

            if(difficulty == 3){
                structureCode = "001 105 201 301 312 321 131 031 041 051 261 271 371";
            }

            if(difficulty == 4){
                structureCode = "001 321 314 041 034 261 371 364";
            }
        }

        if(structureType.equals("-2 Slope")){
            if(difficulty == 1){
                structureCode = "001 011 021 031 041 051 061 071 101 201 301 131 351";
            }

            if(difficulty == 2){
                structureCode = "001 011 021 031 041 051 061 071 101 201 301 112 341";
            }
            
            if(difficulty == 3){
                structureCode = "001 011 021 031 041 051 061 071 101 201 301 311 112 212";
            }

            if(difficulty == 4){
                structureCode = "101 201 301 071 361 372 265";
            }
        }

        if(structureCode == null){
            System.out.println("structureCode is null! structureType = " + structureType);
        }
    }

    public void parseObjects(){
        String newStructureCode = structureCode.replaceAll(" ", "");
        for(int i = 0; i < newStructureCode.length() / 3; i++){
            int x = Integer.parseInt(newStructureCode.substring(i * 3 + 0, i * 3 + 1));
            int y = Integer.parseInt(newStructureCode.substring(i * 3 + 1, i * 3 + 2));
            int type = Integer.parseInt(newStructureCode.substring(i * 3 + 2, i * 3 + 3));
            objects.add(new PlatformerObject(new OrderedPair(x, y), type));
        }
    }

    public ArrayList<PlatformerObject> getObjects(){
        return objects;
    }
}

class Platformer extends Challenge{
    ArrayList<PlatformerObject> objects;
    OrderedPair size;
    int difficulty;
    OrderedDouble position;
    OrderedDouble velocity;
    OrderedPair gridPos;
    int jumpPower;
    int[][] blocks;
    boolean isGrounded; 
    int stage;
    int jumps;
    int coyoteTime;

    public Platformer(String challengeID, OrderedPair size, int difficulty){
        super(challengeID);
        this.size = size;
        this.difficulty = difficulty;
        coyoteTime = 0;
        stage = 1;
        jumps = 0;
        objects = new ArrayList<PlatformerObject>();
        generatePlatformer();
        position = new OrderedDouble(0.0, 1.0);
        velocity = new OrderedDouble(0.0, 0.0);
        gridPos = position.toOrderedPair();
    }

    public void placeObject(PlatformerObject object, OrderedPair startPos){
        int x = object.position().x() + startPos.x();
        int y = object.position().y() + startPos.y();
        int type = object.type();
        if(objects.isEmpty()){
            objects.add(new PlatformerObject(new OrderedPair(x, y), object.type()));
        } else {
            int i = 0;

            /*while(i < objects.size() && y > objects.get(i).position().y()){
                i++;
            }
            if(i >= objects.size()){
                objects.add(i, object);
                return;
            }
            while(x > objects.get(i).position().x() && y == objects.get(i).position().y()){
                i++;
                if(i >= objects.size()){
                    objects.add(i, object);
                    return;
                }
            }*/

            while(i < objects.size() && y > objects.get(i).position().y() || (x > objects.get(i).position().x() && y == objects.get(i).position().y())){
                i++;
                if(i >= objects.size()){
                    objects.add(i, new PlatformerObject(new OrderedPair(x, y), object.type()));
                    return;
                }
            }
            objects.add(i, new PlatformerObject(new OrderedPair(x, y), object.type()));
        }
    }

    public void placeStructure(PlatformerStructure structure, OrderedPair startPos){
        ArrayList<PlatformerObject> structureObjects = structure.getObjects();
        for(PlatformerObject object : structureObjects){
            placeObject(object, startPos);
        }
    }

    public void generatePlatformer(){
        objects.clear();
        OrderedPair currentPos = new OrderedPair(0, 0);
        OrderedPair deltaPos;
        OrderedPair[] deltas = new OrderedPair[]{
            new OrderedPair(4, 0),
            new OrderedPair(8, 4),
            new OrderedPair(8, -4),
            new OrderedPair(4, 4),
            new OrderedPair(4, -4),
            new OrderedPair(4, 8),
            new OrderedPair(4, -8)
        };
        ArrayList<OrderedPair> legalDeltas = new ArrayList<OrderedPair>();

        while(currentPos.x() < size.x()){
            legalDeltas.clear();
            for(OrderedPair delta : deltas){
                if(currentPos.y() + delta.y() > 0 && currentPos.y() + delta.y() < size.y() - 4){
                    legalDeltas.add(delta);
                }
            }
            deltaPos = legalDeltas.get((int)(Math.random() * legalDeltas.size()));
            if(deltaPos.y() < 0){
                placeStructure(new PlatformerStructure(size, deltaPos, difficulty), new OrderedPair(currentPos.x(), currentPos.y() + deltaPos.y()));
                //System.out.println(currentPos.x() + ", " + (currentPos.y() + deltaPos.y()));
            } else {
                placeStructure(new PlatformerStructure(size, deltaPos, difficulty), new OrderedPair(currentPos.x(), currentPos.y()));
                //System.out.println(currentPos.x() + ", " + (currentPos.y() + deltaPos.y()));
            }
            currentPos.addAndSet(deltaPos);
            //currentPos = currentPos.addX(1);
        }
        blocks = new int[size.x()][size.y()];
        placeBlocks();
    }

    public void respawn(){
        position = new OrderedDouble(0.0, 1.0);
        velocity = new OrderedDouble(0.0, 0.0);
        gridPos = position.toOrderedPair();
    }

    public void frame(){
        
        if(TheConundrum.playerHasAbility("Winged Boots")){
            coyoteTime = 1;
        }

        if((TheConundrum.isKeyPressed(KeyEvent.VK_UP) || TheConundrum.isKeyPressed(KeyEvent.VK_W)) && (coyoteTime > 0)){
            velocity.setY(1.2);
            jumps++;
            TheConundrum.platformerJumps++;
            coyoteTime = 0;
        }
        coyoteTime--;

        if(TheConundrum.isKeyPressed(KeyEvent.VK_RIGHT) || TheConundrum.isKeyPressed(KeyEvent.VK_D)){
            velocity.setX(.6);
        } else if(TheConundrum.isKeyPressed(KeyEvent.VK_LEFT) || TheConundrum.isKeyPressed(KeyEvent.VK_A)){
            velocity.setX(-.6);
        } else {
            velocity.setX(0);
        }                         
        velocity.addYAndSet(-.2);

        position.addXAndSet(velocity.x());
        gridPos = position.toOrderedPair();
        if(gridPos.x() < 0){
            position.setX(0);
            gridPos.setX(0);
        }
        if(gridPos.x() >= size.x()){
            if(stage < 3){
                generatePlatformer();
                respawn();
                stage++;
            } else {
                complete();
                return;
            }
        }
        if(gridPos.y() >= size.y()){
            gridPos.setY(size.y() - 1);
            position.setY(size.y() - 1);
        }
        if(gridPos.y() < 0){
            respawn();
        }
        int collidingBlock = blocks[gridPos.x()][size.y() - 1 - gridPos.y()];
        if(collidingBlock > 1){
            respawn();
        }
        if(collidingBlock == 1){
            position.addXAndSet(-1 * velocity.x());
            velocity.setX(0);
        }
            position.addYAndSet(velocity.y());
            gridPos = position.toOrderedPair();
        if(velocity.y() < -.8){
            velocity.setY(-.8);
        }
        if(gridPos.y() >= size.y()){
            gridPos.setY(size.y() - 1);
            position.setY(size.y() - 1);
        }
        if(gridPos.y() < 0){
            respawn();
        }
        collidingBlock = blocks[gridPos.x()][size.y() - 1 - gridPos.y()];
        if(collidingBlock > 1){
            respawn();
        }
        isGrounded = false;
        if(collidingBlock == 1){
            position.addYAndSet(-1.2 * velocity.y());
            gridPos = position.toOrderedPair();
            if(velocity.y() < 0){
                isGrounded = true;
                coyoteTime = 3;
            }
            velocity.setY(0);
        }
        toString();
    }

    public int search(ArrayList<PlatformerObject> objects, OrderedPair position){
        for(int i = 0; i < objects.size(); i++){
            if(objects.get(i).position().equals(position)){
                return i;
            }
        }
        return -1;
    }

    public void placeBlocks(){
        for(int y = 0; y < size.y(); y++){
            for(int x = 0; x < size.x(); x++){
                int index = search(objects, new OrderedPair(x, y));
                if(index >= 0){
                    blocks[x][size.y() - 1 - y] = objects.get(index).type();
                } else {
                    blocks[x][size.y() - 1 - y] = 0;
                }
            }
        }
    }

    public String toString(){
        String str = "\n\n\n\n\n\n\n\n";
        for(int y = 0; y < size.y(); y++){
            for(int x = 0; x < size.x(); x++){
                if(gridPos.equals(x, size.y() - 1 - y)){
                    str += ":D";
                } else if(blocks[x][y] == 1){
                    str += "██";
                } else if(blocks[x][y] == 2){
                    str += "/\\";
                } else if(blocks[x][y] == 3){
                    str += ">>";
                } else if(blocks[x][y] == 4){
                    str += "\\/";
                } else if(blocks[x][y] == 5){
                    str += "<<";
                } else {
                    int y2 = y;
                    boolean isOpen = true;
                    boolean isUnderground = true;

                    for(int i = 0; i < size.y(); i++){
                        if(blocks[x][i] == 1){
                            isOpen = false;
                        }
                    }
                    while(y2 < size.y() - 1){
                        y2++;
                        if(blocks[x][y2] == 1){
                            isUnderground = false;
                        }
                    }
                        if(isOpen){
                            str += "  ";
                        } else if(isUnderground){
                            str += "░░";
                        } else {
                            str += "  ";
                        }
                }
            }
            str += "\n";
        }
        str += "Stage (" + stage + "/3)";
        return str;
    } 

    public void complete(){
        TheConundrum.feedback = challengeID + " completed in " + jumps + " jumps!";
        isCompleted = true;
    }
}

class SwarmEnemy{
    OrderedDouble position;
    OrderedPair gridPos;
    OrderedDouble velocity;
    int health;
    boolean isAlive;
    boolean isFacingRight;

    public SwarmEnemy(OrderedDouble position, int health){
        this.position = position;
        gridPos = position.toOrderedPair();
        velocity = new OrderedDouble(0.0, 0.0);
        this.health = health;
        isAlive = true;
    }

    public void move(OrderedDouble playerPos, Swarm parentSwarm){
        OrderedDouble difference = position.add(playerPos.multiply(-1));
        double max = Math.max(Math.abs(difference.x()), Math.abs(difference.y()));
        OrderedDouble delta = new OrderedDouble(difference.x() / max, difference.y() / max);
        velocity.addAndSet(delta.multiply(-.3));
        for(SwarmEnemy enemy : parentSwarm.getEnemyList()){
            if(enemy != this){
                OrderedDouble enemyDifference = position.add(enemy.position().multiply(-1));
                double enemyDistance = position.distanceTo(enemy.position());
                double squishDistance = 2;
                if(enemyDistance < squishDistance){
                    double enemyMax = Math.max(Math.abs(enemyDifference.x()), Math.abs(enemyDifference.y()));
                    OrderedDouble squishDelta = new OrderedDouble(enemyDifference.x() / enemyMax, enemyDifference.y() / enemyMax);
                    velocity.addAndSet(squishDelta.multiply(.1));
                }
            }
        }
        if(velocity.distanceTo(0, 0) > .5){
            velocity.multiplyAndSet(.1);
        }
        position.addAndSet(velocity);
        velocity.multiplyAndSet(.95);
        position.setX(Math.max(0, Math.min(position.x(), parentSwarm.size().x() - 1)));
        position.setY(Math.max(0, Math.min(position.y(), parentSwarm.size().y() - 1)));
        gridPos = position.toOrderedPair();
        isFacingRight = difference.x() < 0;
    }

    public OrderedDouble position(){
        return position;
    }

    public OrderedPair gridPos(){
        return gridPos;
    }

    public int health(){
        return health;
    }

    public boolean isFacingRight(){
        return isFacingRight;
    }

    public void dealDamage(int amount){
        health -= amount;
        if(health <= 0){
            isAlive = false;
        }
    }

    public boolean isAlive(){
        return isAlive;
    }

    public void setGridPos(){
        gridPos = position.toOrderedPair();
    }

    public void setGridPos(OrderedPair other){
        gridPos = other;
    }

    public void setFacingRight(boolean right){
        isFacingRight = right;
    }
}

class Swarm extends Challenge{
    private String challengeID;
    private OrderedPair size;
    private int difficulty;
    private int health;
    private OrderedDouble position;
    private OrderedPair gridPos;
    private OrderedDouble velocity;
    private double direction;
    private ArrayList<SwarmEnemy> enemies;
    private int[][] blocks;
    private double spawnChance;
    private int swingCooldown;
    private int powerupMeterCapacity;
    private double powerupMeterProgress;
    private int powerupMeterFrame;
    private OrderedDouble swingPos;
    private double swingAngle;
    private int swingFrame;
    private OrderedDouble laserPos;
    private OrderedPair laserGridPos;
    private double laserAngle;
    private int laserFrame;
    private int power;
    private int playerType;
    private int killGoal;
    private int damageCooldown;
    private int kills;
    private ArrayList<OrderedPair> endMessage;
    private int endScreenFrame;
    private boolean isEndScreenDisplayed;
    
    public Swarm(String challengeID, OrderedPair size, int difficulty){
        super(challengeID);
        this.size = size;
        this.difficulty = difficulty;
        resetVars();
    }

    public void resetVars(){
        position = new OrderedDouble(size.x() / 2, size.y() / 2);
        gridPos = position.toOrderedPair();
        velocity = new OrderedDouble(0.0, 0.0);
        enemies = new ArrayList<SwarmEnemy>();
        swingCooldown = 0;
        spawnChance = (double)difficulty / 10;
        powerupMeterCapacity = 40  + (difficulty * 10);
        powerupMeterProgress = 0;
        direction = 0;
        power = 200;
        swingPos = new OrderedDouble(0.0, 0.0);
        swingAngle = 0.0;
        swingFrame = 3;
        laserAngle = 0.0;
        laserFrame = 60;
        laserPos = new OrderedDouble(0.0, 0.0);
        laserGridPos = laserPos.toOrderedPair();
        playerType = 0;
        health = 100;
        damageCooldown = 0;
        kills = 0;
        killGoal = 25 + difficulty * 150;
        endMessage = new ArrayList<OrderedPair>();
        endScreenFrame = 0;
        isEndScreenDisplayed = false;

        blocks = new int[size.x()][size.y()];
        for(int x = 0; x < size.x(); x++){
            for(int y = 0; y < size.y(); y++){
                blocks[x][y] = 0;
            }
        }
    }

    public void createRandomEnemy(){
        int t;
        OrderedDouble enemyPos;
        int edge = (int)(Math.random() * 4);
        if(edge % 2 == 0){
            t = (int)(Math.random() * size.y() - 1);
        } else {
            t = (int)(Math.random() * size.x() - 1);
        }
        if(edge == 0){
            enemyPos = new OrderedDouble(0, t);
        } else if(edge == 1){
            enemyPos = new OrderedDouble(t, 0);
        } else if(edge == 2){
            enemyPos = new OrderedDouble(size.x() - 1, t);
        } else {
            enemyPos = new OrderedDouble(t, size.y() - 1);
        }
        enemies.add(new SwarmEnemy(enemyPos, 80 + difficulty * 20));
    }

    public void frame(){

        if(Math.random() < spawnChance){
            createRandomEnemy();
        }

        boolean right = TheConundrum.isKeyPressed(KeyEvent.VK_RIGHT)  || TheConundrum.isKeyPressed(KeyEvent.VK_D);
        boolean left = TheConundrum.isKeyPressed(KeyEvent.VK_LEFT) || TheConundrum.isKeyPressed(KeyEvent.VK_A);
        boolean up = TheConundrum.isKeyPressed(KeyEvent.VK_UP) || TheConundrum.isKeyPressed(KeyEvent.VK_W);
        boolean down = TheConundrum.isKeyPressed(KeyEvent.VK_DOWN) || TheConundrum.isKeyPressed(KeyEvent.VK_S);
        boolean space = TheConundrum.isKeyPressed(KeyEvent.VK_SPACE);

        if (up && right) {
            direction = 45;
        } else if (up && left) {
            direction = 135;
        } else if (down && left) {
            direction = 225;
        } else if (down && right) {
            direction = 315;
        } else if (up) {
            direction = 90;
        } else if (down) {
            direction = 270;
        } else if (left) {
            direction = 180;
        } else if (right) {
            direction = 0;
        }
        
        if(up){
            velocity.addYAndSet(-.3);
        }
        if(down){
            velocity.addYAndSet(.3);
        }
        if(right){
            velocity.addXAndSet(.3);
        }
        if(left){
            velocity.addXAndSet(-.3);
        }
        if(space){
            if(powerupMeterProgress >= powerupMeterCapacity){
                laser();
            } else if(swingCooldown < 0){
                swing();
            }
        }

        swingCooldown --;
        position.addAndSet(velocity);

        if(position.x() > size.x() || position.x() < 0){
            position.addXAndSet(-1 * velocity.x());
            velocity.setX(0);
        }

        if(position.y() > size.y() || position.y() < 0){
            position.addYAndSet(-1 * velocity.y());
            velocity.setY(0);
        }



        velocity.multiplyAndSet(.8);
        gridPos = position.toOrderedPair();
        for(SwarmEnemy enemy : enemies){
            enemy.move(position, this);
        }
        if(damageCooldown <= 0){
            for(SwarmEnemy enemy : enemies){
                if(position.distanceTo(enemy.position()) < 2){
                    health -= difficulty;
                    TheConundrum.damageTaken += difficulty;
                    damageCooldown = 4;
                    if(health < 0){
                        position = new OrderedDouble(0, 0);
                        resetVars();
                    }
                }
            }
        } else {
            damageCooldown--;
        }
    }

    public String toString(){

        String str = "\n\n";
        for(int x = 0; x < size.x(); x++){
            for(int y = 0; y < size.y(); y++){
                blocks[x][y] = 0;
            }
        }
        
        //Render sword swing
        if(swingFrame < 4){
            blocks[swingPos.toOrderedPair().x()][swingPos.toOrderedPair().y()] = 3;
            swingAngle += 12.5;
            if(TheConundrum.playerHasAbility("Long Sword")){
                swingPos = position.add(Math.cos(Math.toRadians(swingAngle)) * 8, Math.sin(Math.toRadians(swingAngle)) * -8);
            } else {
                swingPos = position.add(Math.cos(Math.toRadians(swingAngle)) * 4, Math.sin(Math.toRadians(swingAngle)) * -4);
            }
            swingPos.clampAndSet(0, size.x() - 1, 0, size.y() - 1);
            swingFrame++;
        }

        //Render enemies
        for(SwarmEnemy enemy : enemies){
            if(enemy.isFacingRight()){
                blocks[enemy.gridPos().x()][enemy.gridPos().y()] = 1;
            } else {
                blocks[enemy.gridPos().x()][enemy.gridPos().y()] = 2;
            }
        }
        
        //Render big laser
        playerType = 0;
        if(laserFrame < 60){
            for(int i = 0; i < 3; i++){
                playerType = 1;
                laserPos = position.copyOf();
                int killsLeft = 3;
                while(laserPos.isWithinBounds(size)){
                    OrderedPair laserGridPos = laserPos.toOrderedPair();
                    if(blocks[laserGridPos.x()][laserGridPos.y()] == 1 || blocks[laserGridPos.x()][laserGridPos.y()] == 2){
                        for(int e = 0; e < enemies.size(); e++){
                            SwarmEnemy enemy = enemies.get(e);
                            if(enemy.gridPos().equals(laserGridPos)){
                                enemies.remove(e);
                                laserAngle += (360 / 60 / 3);
                                blocks[laserGridPos.x()][laserGridPos.y()] = 4;
                                powerupMeterProgress += .4;
                                killsLeft--;
                                kills++;
                                TheConundrum.enemiesKilled++;
                                if(kills >= killGoal){
                                    setEndMessage("You Win!");
                                }
                                if(killsLeft < 1){
                                    break;
                                }
                            }
                        }
                    }
                    blocks[laserGridPos.x()][laserGridPos.y()] = 4;
                    laserPos.addAndSet(Math.cos(Math.toRadians(laserAngle)) / 2, Math.sin(Math.toRadians(laserAngle)) / 2);
                }
                laserAngle += (360 / 60 / 3);
                blocks[laserGridPos.x()][laserGridPos.y()] = 4;
            }
            laserFrame ++;
        }

        for(int x = 0; x < size.x() + 2; x++){
            str += "░░";
        }
        str += "\n";
        for(int y = 0; y < size.y(); y++){
            str += "░░";
            for(int x = 0; x < size.x(); x++){
                if((blocks[x][y] == 1 || blocks[x][y] == 2) && isEndScreenDisplayed){
                    str += "X ";
                } else if(blocks[x][y] == 1){
                    str += " X";
                } else if(blocks[x][y] == 2){
                    str += "X ";
                } else if(gridPos.equals(x, y)){
                    if(playerType == 1){
                        if(TheConundrum.isKeyPressed(KeyEvent.VK_LEFT)){
                            str += "(X";
                        } else if(TheConundrum.isKeyPressed(KeyEvent.VK_RIGHT) || velocity.x() > 0){
                            str += "X)";
                        } else {
                            str += "(X";
                        }
                    } else {
                        if(TheConundrum.isKeyPressed(KeyEvent.VK_LEFT)){
                            str += "(:";
                        } else if(TheConundrum.isKeyPressed(KeyEvent.VK_RIGHT) || velocity.x() > 0){
                            str += ":)";
                        } else {
                            str += "(:";
                        }
                    }
                } else if(blocks[x][y] == 3){
                    str += "╬╬";
                } else if(blocks[x][y] == 4){
                    str += "▓▓";
                } else {
                    str += "  ";
                }
            }
            str += "░░\n";
        }
        for(int x = 0; x < size.x() + 2; x++){
            str += "░░";
        }
        str += "\n\n";
        str += "Health: " + health + " | ";
        str += "Kills: (" + kills + "/" + killGoal +") | ";
        if(powerupMeterProgress < powerupMeterCapacity){
            str += "Powerup Meter: (" + (int)powerupMeterProgress + "/" + powerupMeterCapacity + ")  ";

            int meterLength = size.x() - 25;
            for(int x = 0; x < meterLength; x++){
                double compression = (double)meterLength / powerupMeterCapacity;
                if(powerupMeterProgress * compression > x){
                    str += "▓▓";
                } else {
                str += "░░";
            }
            powerupMeterFrame = 0;                                                                                                                                                                     
        }

        } else {
            str += "Powerup Meter: READY  ";

            int meterLength = size.x() - 30;
            for(int x = 0; x < meterLength; x++){
                if((x + powerupMeterFrame / 3) % 3 == 0){
                    str += "░░";
                } else {
                    str += "▓▓";
                }
            }
            powerupMeterFrame--;
        }
    return str;
    }
    public OrderedPair size(){
        return size;
    }

    public ArrayList<SwarmEnemy> getEnemyList(){
        return enemies;
    }

    public void swing() {
        swingCooldown = 4;
        boolean right = TheConundrum.isKeyPressed(KeyEvent.VK_RIGHT);
        boolean left = TheConundrum.isKeyPressed(KeyEvent.VK_LEFT);
        boolean up = TheConundrum.isKeyPressed(KeyEvent.VK_UP);
        boolean down = TheConundrum.isKeyPressed(KeyEvent.VK_DOWN);
        
            // if(up){
            //     System.out.print("UP ");
            // }
            // if(down){
            //     System.out.print("DOWN ");
            // }
            // if(left){
            //     System.out.print("LEFT ");
            // }
            // if(right){
            //     System.out.print("RIGHT ");
            // }

        for (int e = 0; e < enemies.size(); e++) {
            SwarmEnemy enemy = enemies.get(e);
            
            boolean inRange = false;
            if (up && right) {
                direction = 45;
                inRange = (enemy.position().x() > position.x() - 1) && (enemy.position().y() < position.y() + 1);
            } else if (up && left) {
                direction = 135;
                inRange = (enemy.position().x() < position.x() + 1) && (enemy.position().y() < position.y() + 1);
            } else if (down && left) {
                direction = 225;
                inRange = (enemy.position().x() < position.x() + 1) && (enemy.position().y() > position.y() - 1);
            } else if (down && right) {
                direction = 315;
                inRange = (enemy.position().x() > position.x() - 1) && (enemy.position().y() > position.y() - 1);
            } else if (up) {
                direction = 90;
                inRange = enemy.position().y() < position.y();
            } else if (down) {
                direction = 270;
                inRange = enemy.position().y() > position.y();
            } else if (left) {
                direction = 180;
                inRange = enemy.position().x() < position.x();
            } else if (right) {
                direction = 0;
                inRange = enemy.position().x() > position.x();
            } else if (direction == 45){
                inRange = (enemy.position().x() > position.x() - 1) && (enemy.position().y() < position.y() + 1);
            } else if(direction == 135){
                inRange = (enemy.position().x() < position.x() + 1) && (enemy.position().y() < position.y() + 1);
            } else if(direction == 225){
                inRange = (enemy.position().x() < position.x() + 1) && (enemy.position().y() > position.y() - 1);
            } else if(direction == 315){
                inRange = (enemy.position().x() > position.x() - 1) && (enemy.position().y() > position.y() - 1);
            } else if(direction == 90){
                inRange = enemy.position().y() < position.y();
            } else if(direction == 270){
                inRange = enemy.position().y() > position.y();
            } else if(direction == 180){
                inRange = enemy.position().x() < position.x();
            } else if(direction == 0){
                inRange = enemy.position().x() > position.x();
            }
            
            // double playerFacingX = Math.cos(Math.toRadians(direction));
            // double playerFacingY = Math.sin(Math.toRadians(direction));
            // double differenceX = enemy.position.x() - position.x();
            // double differenceY = enemy.position.y() - position.y();
            OrderedDouble difference = position.add(enemy.position().multiply(-1));
            double distance = Math.sqrt(difference.x() * difference.x() + difference.y() * difference.y());
            //Normalize the difference vectors
            // differenceX /= distance;
            // differenceY /= distance;
            // double dotProduct = playerFacingX * differenceX + playerFacingY * differenceY;
            // double angle = Math.toDegrees(Math.acos(dotProduct)) * (differenceY < 0 ? -1 : 1);

            if ((distance < 5) || (TheConundrum.playerHasAbility("Long Sword") && distance < 10) && inRange){
                enemy.dealDamage(power);
                if (!enemy.isAlive()) {
                    enemies.remove(e);
                    powerupMeterProgress++;
                    kills++;
                    TheConundrum.enemiesKilled++;
                    if(kills >= killGoal){
                        setEndMessage("You Win!");
                    }
                }
            }
        }
        swingFrame = 0;
        swingAngle = direction - 20;
        if(TheConundrum.playerHasAbility("Long Sword")){
            swingPos = position.add(Math.cos(Math.toRadians(swingAngle)) * 8, Math.sin(Math.toRadians(swingAngle)) * -8);
        } else {
            swingPos = position.add(Math.cos(Math.toRadians(swingAngle)) * 4, Math.sin(Math.toRadians(swingAngle)) * -4);
        }
    
        swingPos.clampAndSet(0, size.x() - 1, 0, size.y() - 1);
    }      

    public void laser(){
        laserPos = position.copyOf();
        laserAngle = direction;
        laserFrame = 0;
        powerupMeterProgress = 0;
    }

    public void endScreenFrame(){
        if(enemies.size() > endMessage.size()){
            enemies.remove((int)(Math.random() * enemies.size()));
            endScreenFrame--;
        } else if(enemies.size() < endMessage.size()){
            createRandomEnemy();
            endScreenFrame--;
        }

        for(int i = 0; i < endMessage.size() - 1 && i < enemies.size(); i++){
            SwarmEnemy enemy = enemies.get(i);
            OrderedDouble myPos = endMessage.get(i).toOrderedDouble().add(size.toOrderedDouble().multiply(.3));
            OrderedDouble delta = myPos.multiply(.1).add(enemy.position().multiply(-.09));
            enemy.position().addAndSet(delta);
            if(enemy.position().y() >= 30){
                enemy.position().setY(29);
            }
            if(enemy.position().x() >= 80){
                enemy.position().setX(79);
            }
            enemy.setGridPos();
            enemy.setFacingRight(true);
        }

        endScreenFrame++;
        if(endScreenFrame > 50){
            for(int i = 0; i < endMessage.size() && i < enemies.size(); i++){
                SwarmEnemy enemy = enemies.get(i);
                OrderedDouble myPos = endMessage.get(i).toOrderedDouble().add(size.toOrderedDouble().multiply(.3));
                enemy.position().set(myPos.multiply(.1));
                if(enemy.position().y() >= size.y()){
                    enemy.position().setY(size.y() - 1);
                }
                if(enemy.position().x() >= size.x()){
                    enemy.position().setX(size.x() - 1);
                }
                enemy.setGridPos(myPos.toOrderedPair());
                enemy.setFacingRight(true);
            }
            complete();
            System.out.println(toString());
        }
    }

    public void setEndMessage(String message){
        isEndScreenDisplayed = true;
        endMessage.clear();
        String messageCode = "";
        if(message.equals("You Win!")){
            messageCode = "0 0 4 0 8 0 9 0 13 0 16 0 " +
                          "1 1 3 1 7 1 10 1 13 1 16 1 " +
                          "2 2 7 2 10 2 13 2 16 2 " +
                          "2 3 7 3 10 3 13 3 16 3 " +
                          "2 4 8 4 9 4 14 4 15 4 " +
                          "0 7 2 7 4 7 7 7 8 7 9 7 12 7 15 7 17 7 " + 
                          "0 8 2 8 4 8 8 8 12 8 13 8 15 8 17 8 " +
                          "0 9 2 9 4 9 8 9 12 9 14 9 15 9 17 9 " +
                          "0 10 2 10 4 10 8 10 12 10 15 10 " +
                          "1 11 3 11 7 11 8 11 9 11 12 11 15 11 17 11 ";
        }
        String chunk = "";
        for(int i = 0; i < messageCode.length(); i++){
            chunk = "";
            while(!messageCode.substring(i, i + 1).equals(" ") || i > messageCode.length()){
                chunk += messageCode.substring(i, i + 1);
                i++;
            }
            int x = Integer.parseInt(chunk);
            chunk = "";
            i++;
            while(!messageCode.substring(i, i + 1).equals(" ") || i > messageCode.length()){
                chunk += messageCode.substring(i, i + 1);
                i++;
            }
            int y = Integer.parseInt(chunk);
            endMessage.add(new OrderedPair(x, y));
        }
    }

    public boolean isEndScreenDisplayed(){
        return isEndScreenDisplayed;
    }

    public int health(){
        return health;
    }
}

class TimeStamp{
    OrderedPair position;
    int time;

    public TimeStamp(OrderedPair position, int time){
        this.position = position;
        this.time = time;
    }

    public OrderedPair position(){
        return position;
    }

    public int time(){
        return time;
    }

    public boolean matches(TimeStamp other){
        return position.equals(other.position()) && time == other.time();
    }
}

class Map{
    ArrayList<TimeStamp> timeStamps;
    ArrayList<Room> rooms;
    ArrayList<Door> doors;
    ArrayList<Item> items;
    ArrayList<Item> inventory;
    ArrayList<String> abilities;
    OrderedPair position;
    OrderedPair size;
    OrderedPair oldPos;

    public Map(OrderedPair size){
        this.size = size;
        position = new OrderedPair(0, 0);
        oldPos = position;
        timeStamps = new ArrayList<TimeStamp>();
        inventory = new ArrayList<Item>();
        abilities = new ArrayList<String>();
        rooms = new ArrayList<Room>();
        doors = new ArrayList<Door>();
    }

    public Map(){
        this.size = new OrderedPair(0, 0);
    }

    public Room addRoom(String roomID, int x, int y){
        Room room = new Room(roomID, new OrderedPair(x, y));
        rooms.add(room);
        return room;
    }

    public OrderedPair position(){
        return position;
    }

    public ArrayList<Item> inventory(){
        return inventory;
    }

    public void addDoor(Door door){
        doors.add(door);
    }

    public void removeItemFromMap(Item item){
        for(int r = 0; r < rooms.size(); r++){
            Room room = rooms.get(r);
            
        }
    }

    public void collectItem(Item item){
        inventory.add(item);
        getRoom(position).collectItem();
    }

    public boolean playerHasItem(String desiredItem){
        for(Item item : inventory){
            if(item.id() == desiredItem){
                return true;
            }
        }
        return false;
    }

    public void addAbility(String ability){
        abilities.add(ability);
    }

    public boolean existsRoomAtPosition(OrderedPair roomPos){
        for(Room room : rooms){
            if(room.position().equals(roomPos)){
                return true;
            }
        }
        return false;
    }

    public boolean existsRoomInDirection(String direction){
        for(Room room : rooms){
            switch(direction){
                case "NORTH":
                    if(room.position().equals(position.addY(1))){
                        return true;
                    }
                    break;
                case "SOUTH":
                    if(room.position().equals(position.addY(-1))){
                        return true;
                    }
                    break;
                case "EAST":
                    if(room.position().equals(position.addX(1))){
                        return true;
                    }
                    break;
                case "WEST":
                    if(room.position().equals(position.addX(-1))){
                        return true;
                    }
            }
        }
        return false;
    }

    public boolean existsUnlockedRoomAtPosition(OrderedPair roomPos){
        for(Room room : rooms){
            if(room.position().equals(roomPos) && !room.isLocked()){
                return true;
            }
        }
        return false;
    }

    public boolean existsUnlockedRoomInDirection(String direction){
        for(Room room : rooms){
            switch(direction){
                case "NORTH":
                    if(room.position().equals(position.addY(1)) && !room.isLocked()){
                        return true;
                    }
                    break;
                case "SOUTH":
                    if(room.position().equals(position.addY(-1)) && !room.isLocked()){
                        return true;
                    }
                    break;
                case "EAST":
                    if(room.position().equals(position.addX(1)) && !room.isLocked()){
                        return true;
                    }
                    break;
                case "WEST":
                    if(room.position().equals(position.addX(-1)) && !room.isLocked()){
                        return true;
                    }
            }
        }
        return false;
    }

    public boolean isDirectionValid(String direction){
        switch(direction){
            case "north":
                return existsUnlockedRoomAtPosition(position.addY(1));

            case "south":
                return existsUnlockedRoomAtPosition(position.addY(-1));

            case "east":
                return existsUnlockedRoomAtPosition(position.addX(1));

            case "west":
                return existsUnlockedRoomAtPosition(position.addX(-1));
        }
        return false;
    }

    public ArrayList<String> abilities(){
        return abilities;
    }

    public String roomDescription(){
        switch(getRoom(position).roomID()){
            case "GO":
                return "A rusty, musty, crusty, (insert other -usty words here) room. Definitely an abandoned factory.";
            case "T1":
                return "A room with many pipes going this way and that. Reminds me of an old screensaver from the 1990s.";
            case "P1":
                return "A room with not many pipes, but also not pipeless either. A pipe maze indeed.";
            case "P2":
                return "A room -- well, is it really a room if you're just inside a tube? I couldn't be sure.";
            case "P3":
                return "A pipe system, winding and winding, and hard to make sense of. Your brain is hardly braining.";
            case "P4":
                return "So many pipes that you feel like a protagonist in an action movie, infiltrating an evil lair.";
            case "A1":
                return "The light at the end of the tunnel, your arms and legs feel like jelly.";
            case "S1":
                return "Piles and piles of rubble, each piece probably 100 years old.";
            case "S2":
                return "More structures and poky things. Are you sure this place is OSHA certified?";
            case "S3":
                return "Many broken gears and rusty nails, and I'm not sure why they needed so many spikes.";
            case "S4":
                return "New trend among youth - or just you - Try Not To Contract Tetanus Challenge!";
            case "A2":
                return "No more spikes, only fountain. Too bad for the guy who lost his shoes.";
            case "F1":
                return "A basement lined with grime, smells like sewer water.";
            case "F2":
                return "Too much grime, not enough light. Hey, where did you get that laser?";
            case "F3":
                return "A basement so dark you can't see your hand in front of your face, only the red eyes.";
            case "F4":
                return "Where are these guys even coming from? They seem to be just coming out of the walls like silverfish";
            case "A3":
                return "A Sword Room, cool!";
            case "K1":
                return "An old security room with a typewriter in the center and corroding steel bars covering the walls.";
            case "D1":
                return "Used to be a claustrophobic place. Now it's an acrophobic place.";
            case "T2":
                return "The base of a long and high climb.";
            case "K2":
                return "An old watchtower looking over the entire factory floor, now partially collapsed.";
            case "D2":
                return "A side room used for contruction materials and tools.";
            case "T3":
                return "Just down the stairs from your previous adventure. It's only downhill from here. (in a bad way)";
            case "K3":
                return "Does anyone even read these?";
            case "D3":
                return "A room to not mess with unless you have a death wish.";
            case "T4":
                return "A damp and musty chamber. Rain tends to collect above here, and drip down.";
        }
        return "";
    }

    public String toString(){
        String[][] blocks = new String[size.x()][size.y()];
        String[][] output = new String[size.x() * 3][size.y() * 3];

        for(int y = 0; y < blocks[0].length; y++){
            for(int x = 0; x < blocks.length; x++){
                blocks[x][y] = "Nothing";
            }
        }

        ArrayList<Room> visitedRooms = new ArrayList<Room>();

        for(Room room : rooms){
            if(room.isVisited()){
                blocks[size.x() / 2 + room.position().x()][size.y() / 2 - room.position().y()] = room.roomType();
                visitedRooms.add(room);
            } else if(room.isDiscovered()){
                if(room.isLocked()){
                    blocks[size.x() / 2 + room.position().x()][size.y() / 2 - room.position().y()] = "Locked";
                } else {
                    blocks[size.x() / 2 + room.position().x()][size.y() / 2 - room.position().y()] = "Unknown";
                }
            }
        }
        String str2 = "";

        ArrayList<String> sidebar = new ArrayList<String>();
        sidebar.add("╠═════════════════════════════════════════╣ Position ╠════════════════════════════════════════╣");
        sidebar.add("Your Position: " + getRoom(position).roomID());
        str2 = "On Path: ";
        if(position.x() == 0 && position.y() > 0){
            str2 += "Pipes";
        } else if(position.x() < 0 && position.y() == 0){
            str2 += "Spikes";
        } else if(position.x() == 0 && position.y() < 0){
            str2 += "Pikes";
        } else {
            str2 += "None";
        }
        sidebar.add(str2);
        sidebar.add("--");
        sidebar.add("╠═════════════════════════════════════╣ Room Description ╠════════════════════════════════════╣");
        sidebar.add(roomDescription());
        if(getRoom(position).hasItem()){
            sidebar.add("There is a(n) " + getRoom(position).getItem().id() + " here. (You can pick it up)");
        }
        sidebar.add("╠══════════════════════════════════════════╣ Status ╠═════════════════════════════════════════╣");
        
        str2 = "Valid Directions: [";
        if(existsUnlockedRoomInDirection("NORTH")){
            str2 += "NORTH, ";
        }
        if(existsUnlockedRoomInDirection("SOUTH")){
            str2 += "SOUTH, ";
        }
        if(existsUnlockedRoomInDirection("EAST")){
            str2 += "EAST, ";
        }
        if(existsUnlockedRoomInDirection("WEST")){
            str2 += "WEST, ";
        }
        str2 += "\b\b]";
        sidebar.add(str2);

        str2 = "Inventory: ";
        if(inventory.isEmpty()){
            str2 += "EMPTY";
        } else {
            for(Item item : inventory){
                str2 += item.id() + ", ";
            }
            str2 += "\b\b ";
        }
        sidebar.add(str2);

        str2 = "Abilities: ";
        if(abilities.isEmpty()){
            str2 += "NONE";
        } else {
            for(String ability : abilities){
                str2 += ability + ", ";
            }
            str2 += "\b\b ";
        }
        sidebar.add(str2);

        sidebar.add("Lives: " + TheConundrum.lives);

        sidebar.add("--");
        sidebar.add("--");
        sidebar.add("--");
        sidebar.add("--");

        sidebar.add("╠═════════════════════════════════════════╣ System ╠═══════════════════════════════════════════╣");
        sidebar.add(TheConundrum.feedback);


        for(int y = 0; y < blocks[0].length; y++){
            for(int x = 0; x < blocks.length; x++){
                switch(blocks[x][y]){
                    case "Nothing":
                        for(int y2 = 0; y2 < 3; y2++){
                            for(int x2 = 0; x2 < 3; x2++){
                                output[x * 3 + x2][y * 3 + y2] = "  ";
                            }
                        }
                        break;

                    case "Unknown":
                        output[x * 3][y * 3] = "┌─";
                        output[x * 3 + 1][y * 3] = "──";
                        output[x * 3 + 2][y * 3] = "─┐";

                        output[x * 3][y * 3 + 1] = "│ ";
                        output[x * 3 + 1][y * 3 + 1] = "??";
                        output[x * 3 + 2][y * 3 + 1] = " │";

                        output[x * 3][y * 3 + 2] = "└─";
                        output[x * 3 + 1][y * 3 + 2] = "──";
                        output[x * 3 + 2][y * 3 + 2] = "─┘";
                        break;
                    case "Locked":
                        output[x * 3][y * 3] = "┌─";
                        output[x * 3 + 1][y * 3] = "  ";
                        output[x * 3 + 2][y * 3] = "─┐";

                        output[x * 3][y * 3 + 1] = "  ";
                        output[x * 3 + 1][y * 3 + 1] = "XX";
                        output[x * 3 + 2][y * 3 + 1] = "  ";

                        output[x * 3][y * 3 + 2] = "└─";
                        output[x * 3 + 1][y * 3 + 2] = "  ";
                        output[x * 3 + 2][y * 3 + 2] = "─┘";
                        break;

                    case "Challenge":
                    case "Dialogue":
                    case "Death":
                    case "Item":
                    case "Ability":
                    case "Start":
                        OrderedPair roomPos = new OrderedPair(x - size.x() / 2, -1 * y + size.y() / 2);
                        if(position.equals(roomPos)){
                            output[x * 3][y * 3] = "╔═";
                            output[x * 3 + 1][y * 3] = "══";
                            output[x * 3 + 2][y * 3] = "═╗";

                            output[x * 3][y * 3 + 1] = "║ ";
                            output[x * 3 + 1][y * 3 + 1] = getRoom(roomPos).roomID();
                            output[x * 3 + 2][y * 3 + 1] = " ║";

                            output[x * 3][y * 3 + 2] = "╚═";
                            output[x * 3 + 1][y * 3 + 2] = "══";
                            output[x * 3 + 2][y * 3 + 2] = "═╝";
                        } else {
                            output[x * 3][y * 3] = "┌─";
                            output[x * 3 + 1][y * 3] = "──";
                            output[x * 3 + 2][y * 3] = "─┐";

                            output[x * 3][y * 3 + 1] = "│ ";
                            output[x * 3 + 1][y * 3 + 1] = getRoom(roomPos).roomID();
                            output[x * 3 + 2][y * 3 + 1] = " │";

                            output[x * 3][y * 3 + 2] = "└─";
                            output[x * 3 + 1][y * 3 + 2] = "──";
                            output[x * 3 + 2][y * 3 + 2] = "─┘";
                        }
                        break;
                }
            }
        }
        String str = "";
        for(int y = 0; y < output[0].length; y++){
            for(int x = 0; x < output.length; x++){
                str += output[x][y];
            }
            if(y == 0 || y == 19){
                str += "        ╦         ";
            }else if(y == 35 || y == 15){
                str += "        ╩         ";
            } else if(y == 16){
                str += "        M         ";
            } else if(y == 17){
                str += "        A         ";
            } else if(y == 18){
                str += "        P         ";
            } else {
                str += "        ║         ";
            }
            if(y < sidebar.size() * 2 && y % 2 == 0){
                str += sidebar.get(y / 2);
            }
            str += "\n";
        }
        return str;
    }

    public ArrayList<Room> getAllRooms(){
        return rooms;
    }

    public Room getRoom(int r){
        return rooms.get(r);
    }

    public Room getRoom(int roomX, int roomY){
        for(Room room : rooms){
            if(room.position().equals(new OrderedPair(roomX, roomY))){
                return room;
            }
        }
        return null;
    }

    public Room getRoom(OrderedPair position){
        for(Room room : rooms){
            if(room.position().equals(position)){
                return room;
            }
        }
        return null;
    }

    public Room getRoomInDirection(String direction){
        switch(direction){
            case "NORTH":
                for(Room room : rooms){
                    if(room.position().equals(position.addY(1))){
                        return room;
                    }
                }
                return null;
            case "SOUTH":
                for(Room room : rooms){
                    if(room.position().equals(position.addY(-1))){
                        return room;
                    }
                }
                return null;
            case "EAST":
                for(Room room : rooms){
                    if(room.position().equals(position.addX(1))){
                        return room;
                    }
                }
                return null;
            case "WEST":
                for(Room room : rooms){
                    if(room.position().equals(position.addX(-1))){
                        return room;
                    }
                }
                return null;
        }
        return null;
    }

    public void removeRoom(int roomX, int roomY){
        for(int r = 0; r < rooms.size(); r++){
            if(rooms.get(r).position().equals(roomX, roomY)){
                rooms.remove(r);
            }
        }
    }

    public void resetPath(String path){
        switch(path){
            case "Pipes":
                removeRoom(0, 2);
                removeRoom(0, 3);
                removeRoom(0, 4);
                removeRoom(0, 5);

                addRoom("P1", 0, 2).makeChallengeRoom(new Maze("Pipes: Level 1", new OrderedPair(49, 25))).visit();
                addRoom("P2", 0, 3).makeChallengeRoom(new Maze("Pipes: Level 2", new OrderedPair(59, 29))).visit();
                addRoom("P3", 0, 4).makeChallengeRoom(new Maze("Pipes: Level 3", new OrderedPair(69, 35))).visit();
                addRoom("P4", 0, 5).makeChallengeRoom(new Maze("Pipes: Level 4", new OrderedPair(79, 39))).visit();
                break;

            case "Spikes":
                removeRoom(-2, 0);
                removeRoom(-3, 0);
                removeRoom(-4, 0);
                removeRoom(-5, 0);

                addRoom("S1", -2, 0).makeChallengeRoom(new Platformer("Spikes: Level 1", new OrderedPair(80, 30), 1)).visit();
                addRoom("S2", -3, 0).makeChallengeRoom(new Platformer("Spikes: Level 2", new OrderedPair(80, 30), 2)).visit();
                addRoom("S3", -4, 0).makeChallengeRoom(new Platformer("Spikes: Level 3", new OrderedPair(80, 30), 3)).visit();
                addRoom("S4", -5, 0).makeChallengeRoom(new Platformer("Spikes: Level 4", new OrderedPair(80, 30), 4)).visit();
                break;

            case "Pikes":
                removeRoom(0, -2);
                removeRoom(0 ,-3);
                removeRoom(0, -4);
                removeRoom(0, -5);

                addRoom("F1", 0, -2).makeChallengeRoom(new Swarm("Pikes: Level 1", new OrderedPair(80, 30), 1)).visit();
                addRoom("F2", 0, -3).makeChallengeRoom(new Swarm("Pikes: Level 2", new OrderedPair(80, 30), 2)).visit();
                addRoom("F3", 0, -4).makeChallengeRoom(new Swarm("Pikes: Level 3", new OrderedPair(80, 30), 3)).visit();
                addRoom("F4", 0, -5).makeChallengeRoom(new Swarm("Pikes: Level 4", new OrderedPair(80, 30), 4)).visit();
                break;
        }
    }

    public void enterRoom(){
        Room room = getRoom(position);

        if(existsRoomInDirection("NORTH")){
            getRoomInDirection("NORTH").discover();
        }
        if(existsRoomInDirection("SOUTH")){
            getRoomInDirection("SOUTH").discover();
        }
        if(existsRoomInDirection("EAST")){
            getRoomInDirection("EAST").discover();
        }
        if(existsRoomInDirection("WEST")){
            getRoomInDirection("WEST").discover();
        }

        room.visit();
        if(room.type().equals("Challenge")){
            if(room.getChallenge().isCompleted()){
                return;
            }
            TheConundrum.feedback = "You are about to enter a 'Challenge Room!' Proceed? (Y/N)";
            TheConundrum.clearScreen();
            System.out.print(toString());
            String answer = TheConundrum.nextBoolean();

            if(answer.equals("Y")){
                Challenge challenge = getRoom(position).getChallenge();
                if(challenge instanceof Maze){
                    TheConundrum.mazeLoop(challenge);
                } else if(challenge instanceof Platformer){
                    TheConundrum.platformerLoop(challenge);
                } else if(challenge instanceof Swarm){
                    TheConundrum.swarmLoop(challenge);
                }
            } else {
                position = oldPos.copyOf();
                TheConundrum.feedback = "You couldn't bring yourself to begin the challenge. Aww...";
            }
        } else if(room.type() == "Dialogue"){
            if(room.hasDialogueBeenSaid()){
                return;
            }

            TheConundrum.clearScreen();
            if(room.position().equals(0, 1)){

                TheConundrum.printElement("Pipe");
                TheConundrum.printElement("Cutscene Header");
                TheConundrum.println("You enter into a room containing a vast aggregation of pipes, running over a dark chasm.");
                TheConundrum.sleep(1000);
                TheConundrum.println("\nIt seems the only way to make it to the other side is to crawl through the pipes.");
                TheConundrum.printElement("Enter Reminder");

                TheConundrum.println("System: To move though the pipes, use WASD or the arrow keys. The aim is to reach the center.");
                TheConundrum.sleep(1000);
                TheConundrum.println("\nSystem: The challenge begins in the next room [NORTH]. Good Luck!");
                TheConundrum.printElement("Enter Reminder");

            } else if(room.position().equals(-1, 0)){

                TheConundrum.printElement("Gears");
                TheConundrum.printElement("Cutscene Header");
                TheConundrum.println("You find yourself in a great assemling hall. There are massive structures of gears and spikes.");
                TheConundrum.sleep(1000);
                TheConundrum.println("\nYou will have to jump over and under these structures, avoiding any pitfalls along the way.");
                TheConundrum.printElement("Enter Reminder");

                TheConundrum.println("System: To navigate yourself through these structures, user WASD or the arrow keys.");
                TheConundrum.sleep(1000);
                TheConundrum.println("\nSystem: The challenge begins in the next room [WEST]. Good Luck!");
                TheConundrum.printElement("Enter Reminder");

            } else if(room.position().equals(0, -1)){

                TheConundrum.printElement("Cutscene Header");
                TheConundrum.println("You drop into a dark basement covered in rust and grime. You see two red lights close by.");
                TheConundrum.sleep(1000);
                TheConundrum.println("\nAs your eyes adjust, you realize that those aren't lights.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.clearScreen();
                TheConundrum.printElement("Eyes");
                TheConundrum.printElement("Cutscene Header");
                TheConundrum.println("They're EYES.");
                TheConundrum.sleep(1000);
                TheConundrum.println("\nI guess that sword you picked up is going to come in handy.");
                TheConundrum.printElement("Enter Reminder");

                TheConundrum.println("System: To fight your way through, use space to attack, and WASD or the arrow keys to move.");
                TheConundrum.sleep(1000);
                TheConundrum.println("\nSystem: The challenge begins in the next room [SOUTH]. Good Luck!");
                TheConundrum.printElement("Enter Reminder");
            } else if(room.position().equals(-1, 1)){

                TheConundrum.printElement("Cutscene Header");
                TheConundrum.println("The door creaks as you enter. You can hear the faint drip-drip of water.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("You pick up a slight dialogue in a nearby room. Is there someone else here? You hold your ear to the wall.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.clearScreen();
                TheConundrum.println("-- -- The subject? ---- -- ----- -- Im not sure.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("Trust me, -- ---- -- ----- -- I know. -- ---");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("--- ------ Do you think -- ---- -- -- - train?");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("Not yet.");
                TheConundrum.printElement("Enter Reminder");
            }

            room.dialogueHasIndeedBeenSaid();
        } else if(room.type().equals("Ability")){
            if(room.hasAbilityBeenGiven()){
                return;
            }
            TheConundrum.clearScreen();
            if(room.position().equals(1, 5)){

                TheConundrum.printElement("Hammer");
                TheConundrum.printElement("Cutscene Header");
                TheConundrum.println("You finally exit the pipes, phew! It seems that this room used to be a tool storage room.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("There are a variety of broken down tools to see, but one special Hammer catches your eye.");
                TheConundrum.printElement("Enter Reminder");
                addAbility("Pipe Hammer");
                TheConundrum.println("You pick up the hammer, it looks way too shiny to be in an abandoned factory. Why is this here?");
                TheConundrum.printElement("Enter Reminder");

                resetPath("Pipes");

                getRoom(-1, 4).unlock();
                getRoom(1, 3).unlock();
                TheConundrum.feedback = "1 new room has been unlocked!";
                
                if(getRoom(0, -1).isLocked()){
                    getRoom(0, -1).unlock();
                    TheConundrum.feedback = "2 new rooms have been unlocked!";
                }

            } else if(room.position().equals(-5, -1)){

                TheConundrum.printElement("Winged Boots");
                TheConundrum.printElement("Cutscene Header");
                TheConundrum.println("You finally climb your way over the last mound of rubble, and you find a fountain.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("You look into the fountain, and there is a pair of winged boots inside.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("You reach in and pick up the boots. When you put them on, you immediately feel lighter.");
                addAbility("Winged Boots");
                TheConundrum.printElement("Enter Reminder");

                resetPath("Spikes");

                getRoom(-4, 1).unlock();
                getRoom(-4, 2).unlock();
                TheConundrum.feedback = "1 new room has been unlocked!";

                if(getRoom(0, -1).isLocked()){
                    getRoom(0, -1).unlock();
                    TheConundrum.feedback = "2 new rooms have been unlocked!";
                }

            } else if(room.position().equals(1, -5)){
                TheConundrum.printElement("Sword");
                TheConundrum.printElement("Cutscene Header");
                TheConundrum.println("Creature blood still dripping from your hands, you climb down into the deepest basement level.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("As soon as you do, the light from an exceptional sword illuminates the room.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("You take the sword, and it is heavy than expected, but is muuch better than your old weapon.");
                TheConundrum.sleep(100);
                TheConundrum.println("It's still not better than that laser, though.");
                addAbility("Long Sword");
                TheConundrum.printElement("Enter Reminder");

                resetPath("Pikes");

                getRoom(-1, -3).unlock();
                getRoom(1, -1).unlock();
                TheConundrum.feedback = "3 new rooms have been unlocked!";
            }

            room.abilityHasIndeedBeenGiven();
        } else if(room.type().equals("Death")){
            TheConundrum.clearScreen();
            if(room.position().equals(1, 3)){

                TheConundrum.printElement("Cutscene Header");
                TheConundrum.println("As you crawl through this tube section, you notice thick rust coated on the inside.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("You feel the pipes collapsing under your weight.");
                TheConundrum.printElement("Enter Reminder");
                int roll = TheConundrum.RollTheDice();
                if(roll < TheConundrum.numberToRoll){
                    TheConundrum.println("You rolled a " + roll + ". You don't move out of the way fast enough and the pipe breaks off.");
                    TheConundrum.printElement("Enter Reminder");
                    TheConundrum.println("You fall with the pipe for what feels like 10 seconds. Eventually, it stops, and you stop.");
                    TheConundrum.resetVars();
                    TheConundrum.main(new String[]{"You Died"});
                    System.exit(0);
                } else {
                    TheConundrum.println("You rolled a(n) " + roll + ". You are quick enough to get out of the way before the pipe falls.");
                    TheConundrum.printElement("Enter Reminder");
                    TheConundrum.println("Next time you roll the dice, you will need to roll a " + (TheConundrum.numberToRoll + 2) + " to survive.");
                    TheConundrum.printElement("Enter Reminder");
                }
            } else if(room.position().equals(-4, 2)){

                TheConundrum.printElement("Rubble");
                TheConundrum.printElement("Cutscene Header");
                TheConundrum.println("As you walk to the side, you cause a mass of rubble to fall from the ceiling.");
                TheConundrum.printElement("Enter Reminder");
                int roll = TheConundrum.RollTheDice();
                if(roll < TheConundrum.numberToRoll){
                    TheConundrum.println("You rolled a " + roll + ". You don't move out of the way fast enough and are crushed by the falling rubble.");
                    TheConundrum.printElement("Enter Reminder");
                    TheConundrum.resetVars();
                    TheConundrum.main(new String[]{"You Died"});
                    System.exit(0);
                } else {
                    TheConundrum.println("You rolled a(n) " + roll + ". You are quick enough to avoid the falling rubble.");
                    TheConundrum.printElement("Enter Reminder");
                    TheConundrum.println("Next time you roll the dice, you will need to roll a " + (TheConundrum.numberToRoll + 2) + " to survive.");
                    TheConundrum.printElement("Enter Reminder");
                }
            } else {

                TheConundrum.printElement("Lock");
                TheConundrum.printElement("Cutscene Header");
                TheConundrum.printElement("As you walk into the room, you nose notices a pungent smell emanating from within.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.printElement("There is something very big and very dangerous nearby, but you have no idea what.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.printElement("You run out of the room and start closing the door. However, that wakes up the beast.");
                int roll = TheConundrum.RollTheDice();
                if(roll < TheConundrum.numberToRoll){
                    TheConundrum.println("You rolled a " + roll + ". You struggle to figure out the complex lock that would protect you from the beast.");
                    TheConundrum.printElement("Enter Reminder");
                    TheConundrum.println("The beast smashes open the door and consequently devours you.");
                    TheConundrum.printElement("Enter Reminder");
                    TheConundrum.resetVars();
                    TheConundrum.main(new String[]{"You Died"});
                    System.exit(0);
                } else {
                    TheConundrum.println("You rolled a(n) " + roll + ". You are able to decipher the complex lock protecting you from the beast.");
                    TheConundrum.printElement("Enter Reminder");
                    TheConundrum.println("The beast smashes on the door a second after you inset the final segment into the lock. The door holds still as a rock.");
                    TheConundrum.printElement("Enter Reminder");
                    TheConundrum.println("Next time you roll the dice, you will need to roll a " + (TheConundrum.numberToRoll + 2) + " to survive.");
                    TheConundrum.printElement("Enter Reminder");
                }
            }
        } else if(room.type().equals("Start")){
            if(!(playerHasItem("Red Key") && playerHasItem("Green Key") && playerHasItem("Blue Key"))){
                return;
            }

            TheConundrum.feedback = "Now that you have all 3 keys, you can enter the elevator! Proceed?";
            System.out.println(toString());
            if(TheConundrum.nextBoolean() == "N"){
                return;
            }

            TheConundrum.printElement("Elevator Buttons");
            TheConundrum.clearScreen();
            TheConundrum.println("You insert your red key, blue key, and green key into the elevator, and enter inside.");
            TheConundrum.printElement("Enter Reminder");
            TheConundrum.println("Watson: Glad you could finally make it, " + TheConundrum.name + ". It was a rough journey, but you finished regardless.");
            TheConundrum.printElement("Enter Reminder");
            TheConundrum.println("As the elevator jolts to life, you realize that you know absolutely nothing about how you got here.");
            TheConundrum.printElement("Enter Reminder");

            TheConundrum.clearScreen();
            TheConundrum.println("You emerge into a room with a grand glass display case containing The Microchip.");
            TheConundrum.printElement("Enter Reminder");
            TheConundrum.println("The door to the elevator never closes as it should. You pause for a second. Watson: Go on. Take it.");
            TheConundrum.printElement("Enter Reminder");
            TheConundrum.println("You unlock the case with your Blue Key and pocket The Microchip.");
            TheConundrum.printElement("Enter Reminder");
            TheConundrum.println("As you take the elevator back down, it begins to shake violently. The elevator lights shut off, and it falls.");
            TheConundrum.printElement("Enter Reminder");
            TheConundrum.println("You sense an opportunity to jump from the elevator door, still open, to the room in which you awoke.");
            TheConundrum.printElement("Enter Reminder");
            TheConundrum.println("You take a leap of faith.");
            TheConundrum.printElement("Enter Reminder");
            int roll = TheConundrum.RollTheDice();
            if(roll < TheConundrum.numberToRoll){
                TheConundrum.println("You rolled a " + roll + ". You mistime your jump and hit your head on the wall right after the gap closes.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("The mechanism is still hurtling towards an impending doom at a high speed.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("You turn your thoughts to a higher power. You want to pray to all of the gods, but you only have time for one.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.clearScreen();

                TheConundrum.printElement("Cutscene Header");
                TheConundrum.println("Which god would you like to pray to?");
                TheConundrum.println("(1) Allah");
                TheConundrum.println("(2) Jesus");
                TheConundrum.println("(3) Science");
                TheConundrum.println("(4) Tao");
                TheConundrum.println("(5) The Universe");
                TheConundrum.println("(6) Vajrapāṇi");
                TheConundrum.println("(7) Vishnu");
                TheConundrum.println("(8) Yahweh");
                TheConundrum.println("Type your own");
                String god = TheConundrum.nextString(true, true);
                switch(god){
                    case "1":
                        god = "Allah";
                        break;
                    case "2":
                        god = "Jesus";
                        break;
                    case "3":
                        god = "Science";
                        break;
                    case "4":
                        god = "Tao";
                        break;
                    case "5":
                        god = "The Universe";
                        break;
                    case "6":
                        god = "Vajrapāṇi";
                        break;
                    case "7":
                        god = "Vishnu";
                        break;
                    case "8":
                        god = "Yahweh";
                        break;
                }
                TheConundrum.newLine();
                TheConundrum.println("You ask " + god + " to save you.");
                TheConundrum.printElement("Enter Reminder");
                if(Math.random() > 0.5){
                    TheConundrum.println("The elevator slows to a halt, then rises up to the first floor.");
                    TheConundrum.printElement("Enter Reminder");
                    TheConundrum.println("You step out and, immediately after, the elevator continues to fall down with a crash.");
                    TheConundrum.printElement("Enter Reminder");
                } else {
                    TheConundrum.println("Nothing happens for a second, and then the elevator hits the ground hard and you cease to exist.");
                    TheConundrum.printElement("Enter Reminder");
                    TheConundrum.resetVars();
                    TheConundrum.main(new String[]{"You Died"});
                    System.exit(0);
                }
            } else {
                TheConundrum.println("You make it.");
                TheConundrum.printElement("Enter Reminder");
            }

            TheConundrum.clearScreen();
            TheConundrum.printElement("Cutscene Header");
            TheConundrum.println("You are now standing where you awoke a few hours ago.");
            TheConundrum.printElement("Enter Reminder");
            TheConundrum.println("You insert The Microchip into the giant rusty door's slot. You hear loud clanks and the screeching of metal.");
            TheConundrum.printElement("Enter Reminder");
            TheConundrum.println("It opens after many loud factory noises have passed, and you finally see the light.");
            TheConundrum.printElement("Enter Reminder");
            TheConundrum.clearScreen();
            TheConundrum.printElement("You Win");
            TheConundrum.waitForEnter();
            System.exit(0);
        }
    }

    public void playerMove(String direction){
        TheConundrum.timesMoved++;
        oldPos = position.copyOf();
        switch(direction){
            case "NORTH":
                TheConundrum.feedback = "You moved north from the " + getRoom(position).roomType() + " Room " + getRoom(position).roomID() + ".";
                position.addYAndSet(1);
                enterRoom();
                break;
            case "SOUTH":
                TheConundrum.feedback = "You moved south.";
                position.addYAndSet(-1);
                enterRoom();
                break;
            case "EAST":
                TheConundrum.feedback = "You moved east.";
                position.addXAndSet(1);
                enterRoom();
                break;
            case "WEST":
                TheConundrum.feedback = "You moved west.";
                position.addXAndSet(-1);
                enterRoom();
                break;
        }
    }
}

public class TheConundrum{

    public static JFrame keyChecker = new JFrame();
    public static ArrayList<Integer> keysPressed = new ArrayList<Integer>();
    public static String name;
    public static ArrayList<String> linesPrinted = new ArrayList<String>();
    public static String feedback = "Enter a command below:";

    public static boolean playerHasWon = false;
    public static boolean playerHasDied = false;
    public static int lives = 1;
    public static String arg = "";
    public static int deathRoomsEncountered = 0;
    public static int numberToRoll = 0;

    public static Map map = new Map();

    //Statistic tracking variables
    public static int challengesCompleted = 0;
    public static int timesRanIntoWall = 0;
    public static int platformerJumps = 0;
    public static int enemiesKilled = 0;
    public static int damageTaken = 0;
    public static int timesMoved = 0;
    public static int mazeMoves = 0;

    public static void resetVars(){
        JFrame keyChecker = new JFrame();
        ArrayList<Integer> keysPressed = new ArrayList<Integer>();
        String name;
        ArrayList<String> linesPrinted = new ArrayList<String>();
        feedback = "Enter a command below:";

        playerHasWon = false;
        playerHasDied = false;
        lives = 1;
        deathRoomsEncountered = 0;
        numberToRoll = 0;

        //Statistic tracking variables
        challengesCompleted = 0;
        timesRanIntoWall = 0;
        platformerJumps = 0;
        enemiesKilled = 0;
        damageTaken = 0;
        timesMoved = 0;
    }

    public static String toCommand(String input){
        input = input.toUpperCase();
        input = input.replaceAll(" ", "");
        if(input.contains("NORTH")){
            return "NORTH";
        }
        if(input.contains("EAST")){
            return "EAST";
        }
        if(input.contains("SOUTH")){
            return "SOUTH";
        }
        if(input.contains("WEST")){
            return "WEST";
        }
        if(input.contains("KEY") || input.contains("PICKUP")){
            return "KEY";
        }
        input = input.replaceAll("PICKUP", "");
        switch(input){
            case "N":
            case "NO":
            case "NOR":
            case "NORT":
            case "NORTH":
                return "NORTH";
            case "E":
            case "EA":
            case "EAS":
            case "EAST":
                return "EAST";
            case "W":
            case "WE":
            case "WES":
            case "WEST":
                return "WEST";
            case "S":
            case "SO":
            case "SOU":
            case "SOUT":
            case "SOUTH":
                return "SOUTH";
        }
        return "INVALID";
    }


    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void removeKey(int keyCode){
        for(int i = 0; i < keysPressed.size(); i++){
            if(keysPressed.get(i) == keyCode){
                keysPressed.remove(i);
                i--;
            }
        }
    }

    public static boolean isKeyPressed(int keyCode){
        for(int k = 0; k < keysPressed.size(); k++){
            if(keysPressed.get(k) == keyCode){
                return true;
            }
        }
        return false;
    }

    public static void mazeLoop(Challenge maze){
        System.out.println(maze.toString());
        Timer gameLoop = new Timer();
    
        TimerTask frame = new TimerTask(){
            public void run(){
                keyChecker.setVisible(true);
                boolean playerHasMoved = false;

                if(!maze.isCompleted()){
                    if (isKeyPressed(KeyEvent.VK_UP) || isKeyPressed(KeyEvent.VK_W)) {
                        maze.playerMove(270);
                        if (isKeyPressed(KeyEvent.VK_SPACE) && TheConundrum.playerHasAbility("Pipe Hammer")) {
                            maze.destroy(270);
                        }
                        playerHasMoved = true;
                    } else if (isKeyPressed(KeyEvent.VK_DOWN) || isKeyPressed(KeyEvent.VK_S)) {
                        maze.playerMove(90);
                        if (isKeyPressed(KeyEvent.VK_SPACE) && TheConundrum.playerHasAbility("Pipe Hammer")) {
                            maze.destroy(90);
                        }
                        playerHasMoved = true;
                    }
                    if (isKeyPressed(KeyEvent.VK_LEFT) || isKeyPressed(KeyEvent.VK_A)) {
                        maze.playerMove(180);
                        if (isKeyPressed(KeyEvent.VK_SPACE) && TheConundrum.playerHasAbility("Pipe Hammer")) {
                            maze.destroy(180);
                        }
                        playerHasMoved = true;
                    } else if (isKeyPressed(KeyEvent.VK_RIGHT) || isKeyPressed(KeyEvent.VK_D)) {
                        maze.playerMove(0);
                        if (isKeyPressed(KeyEvent.VK_SPACE) && TheConundrum.playerHasAbility("Pipe Hammer")) {
                            maze.destroy(0);
                        }
                        playerHasMoved = true;
                    }

                    if(!maze.isCompleted()){
                        if(playerHasMoved){
                            System.out.println(maze.toString());
                        }
                    } else {
                        challengesCompleted++;
                        gameLoop.cancel();
                        gameLoop.purge();
                    }
                }
            }
        };
        gameLoop.schedule(frame, 0, 60);
        waitUntilComplete(maze);
        keyChecker.setVisible(false);
    }
    
    public static void platformerLoop(Challenge platformer){
        Timer gameLoop = new Timer();
        TimerTask frame = new TimerTask(){
            public void run(){
                keyChecker.setVisible(true);
                platformer.frame();
                if(platformer.isCompleted){
                    challengesCompleted++;
                    gameLoop.cancel();
                    gameLoop.purge();
                } else {
                    System.out.println(platformer.toString());
                }
            }
        };
        gameLoop.scheduleAtFixedRate(frame, 0, 60);
        waitUntilComplete(platformer);
        keyChecker.setVisible(false);
    }

    public static void swarmLoop(Challenge swarm){
        Timer gameLoop = new Timer();
        TimerTask frame = new TimerTask(){
            public void run(){
                keyChecker.setVisible(true);
                if(swarm.isEndScreenDisplayed()){
                    swarm.endScreenFrame();
                    if(swarm.isCompleted()){
                        TheConundrum.feedback = swarm.challengeID() + " completed with " + swarm.health() + " health left!";
                        challengesCompleted++;
                        gameLoop.cancel();
                        gameLoop.purge();
                    } else {
                        System.out.println(swarm.toString());
                    }
                } else {
                    swarm.frame();
                    System.out.println(swarm.toString());
                }
            }
        };
        gameLoop.scheduleAtFixedRate(frame, 0, 60);
        waitUntilComplete(swarm);
        keyChecker.setVisible(false);
    }

    public static void waitUntilComplete(Challenge challenge){
        while(!challenge.isCompleted()){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void waitForKeyPressed(int keyCode){
        keyChecker.setVisible(true);
        while(!isKeyPressed(keyCode)){
            try{
                Thread.sleep(60);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        keyChecker.setVisible(false);
    }

    public static void waitForEnter(){
        keyChecker.setVisible(true);
        while(!isKeyPressed(KeyEvent.VK_ENTER)){
            try{
                Thread.sleep(60);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        keyChecker.setVisible(false);
        removeKey(KeyEvent.VK_ENTER);
    }

    public static void sleep(long millis){
        try{
            Thread.sleep(millis);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static int nextInt(){
        System.out.print("\nYou: ");
        keysPressed.clear();
        ArrayList<String> nums = new ArrayList<String>();
        keyChecker.setVisible(true);
        while(!isKeyPressed(KeyEvent.VK_ENTER)){
            try{
                for(int i = 0; i < keysPressed.size(); i++){
                    int key = keysPressed.get(i);
                    if(Character.isDigit((char)key)){
                        String num = KeyEvent.getKeyText(key);
                        nums.add(num);
                        removeKey(key);
                        System.out.print(num);
                    }
                    if(key == KeyEvent.VK_BACK_SPACE){
                        if(!nums.isEmpty()){
                            nums.remove(nums.size() - 1);
                            System.out.print("\b \b");
                            removeKey(key);
                        }
                    }
                }
                Thread.sleep(5);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        keyChecker.setVisible(false);
        System.out.print("\n");
        return Integer.parseInt(String.join("", nums));
    }

    public static String nextString(boolean allowNumbers, boolean allowSpace){
        System.out.print("\nYou: ");
        keysPressed.clear();
        ArrayList<String> letters = new ArrayList<String>();
        keyChecker.setVisible(true);
        while(!isKeyPressed(KeyEvent.VK_ENTER) || letters.isEmpty()){
            try{
                for(int i = 0; i < keysPressed.size(); i++){

                    boolean isShiftPressed = isKeyPressed(KeyEvent.VK_SHIFT);
                    boolean isControlPressed = isKeyPressed(KeyEvent.VK_CONTROL);

                    int key = keysPressed.get(i);
                    if(Character.isLetter((char)key)){
                        String letter = isShiftPressed ? KeyEvent.getKeyText(key) : KeyEvent.getKeyText(key).toLowerCase();
                        letters.add(letter);
                        removeKey(key);
                        System.out.print(letter);
                    } else if(allowNumbers && Character.isDigit((char)key) && !isShiftPressed){
                        String num = KeyEvent.getKeyText(key);
                        letters.add(num);
                        removeKey(key);
                        System.out.print(num);
                    } else if(allowSpace && key == KeyEvent.VK_SPACE){
                        String num = " ";
                        letters.add(num);
                        removeKey(key);
                        System.out.print(num);
                    } else if(key == KeyEvent.VK_BACK_SPACE){
                        if(isControlPressed){
                            while(letters.get(letters.size() - 1) != " "){
                                    letters.remove(letters.size() - 1);
                                    System.out.print("\b \b");
                                    removeKey(key);
                                if(letters.isEmpty()){
                                    break;
                                }
                            }
                            removeKey(KeyEvent.VK_CONTROL);
                        } else {
                            if(!letters.isEmpty()){
                                letters.remove(letters.size() - 1);
                                System.out.print("\b \b");
                                removeKey(key);
                            }
                        }
                    }
                }
                Thread.sleep(5);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
        removeKey(KeyEvent.VK_ENTER);
        keyChecker.setVisible(false);
        System.out.print("\n");
        return String.join("", letters);
    }

    public static String nextDirection(){
        String directions = "NEWS"; // <---- I really enjoyed writing this lol
        System.out.print("\nYou: ");
        keysPressed.clear();
        ArrayList<String> nums = new ArrayList<String>();
        keyChecker.setVisible(true);
        while(!isKeyPressed(KeyEvent.VK_ENTER)){
            try{
                for(int i = 0; i < keysPressed.size(); i++){
                    int key = keysPressed.get(i);
                    if(directions.contains(key)){
                        String num = KeyEvent.getKeyText(key);
                        nums.add(num);
                        removeKey(key);
                        System.out.print(num);
                    }
                    if(key == KeyEvent.VK_BACK_SPACE){
                        if(!nums.isEmpty()){
                            nums.remove(nums.size() - 1);
                            System.out.print("\b \b");
                            removeKey(key);
                        }
                    }
                }
                Thread.sleep(5);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        keyChecker.setVisible(false);
        System.out.print("\n");
        return Integer.parseInt(String.join("", nums));
    }
    
    public static String nextBoolean(){
        System.out.print("\nYou: ");
        keysPressed.clear();
        String bool = "";
        keyChecker.setVisible(true);
        while(!isKeyPressed(KeyEvent.VK_ENTER)){
            try{
                for(int i = 0; i < keysPressed.size(); i++){
                    int key = keysPressed.get(i);
                    if((key == KeyEvent.VK_Y || key == KeyEvent.VK_N) && bool.equals("")){
                        bool = KeyEvent.getKeyText(key);
                        System.out.print(bool);
                    }
                    if(key == KeyEvent.VK_BACK_SPACE){
                        if(!bool.equals("")){
                            bool = "";
                            System.out.print("\b \b");
                            removeKey(key);
                        }
                    }
                }
                Thread.sleep(5);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        keyChecker.setVisible(false);
        System.out.print("\n");
        return bool;
    }

    public static void println(String str){
        System.out.println(str);
        linesPrinted.add(str);
    }

    public static void rePrintLines(){
        clearScreen();
        clearScreen();
        for(String str : linesPrinted){
            println(str);
        }
    }

    public static void newLine(){
        System.out.print("\n");
    }

    public static void printElement(String id){
        String theConundrumTitle = "▄▄▄█████▓ ██░ ██ ▓█████     ▄████▄   ▒█████   ███▄    █  █    ██  ███▄    █ ▓█████▄  ██▀███   █    ██  ███▄ ▄███▓\n▓  ██▒ ▓▒▓██░ ██▒▓█   ▀    ▒██▀ ▀█  ▒██▒  ██▒ ██ ▀█   █  ██  ▓██▒ ██ ▀█   █ ▒██▀ ██▌▓██ ▒ ██▒ ██  ▓██▒▓██▒▀█▀ ██▒\n▒ ▓██░ ▒░▒██▀▀██░▒███      ▒▓█    ▄ ▒██░  ██▒▓██  ▀█ ██▒▓██  ▒██░▓██  ▀█ ██▒░██   █▌▓██ ░▄█ ▒▓██  ▒██░▓██    ▓██░\n░ ▓██▓ ░ ░▓█ ░██ ▒▓█  ▄    ▒▓▓▄ ▄██▒▒██   ██░▓██▒  ▐▌██▒▓▓█  ░██░▓██▒  ▐▌██▒░▓█▄   ▌▒██▀▀█▄  ▓▓█  ░██░▒██    ▒██ \n  ▒██▒ ░ ░▓█▒░██▓░▒████▒   ▒ ▓███▀ ░░ ████▓▒░▒██░   ▓██░▒▒█████▓ ▒██░   ▓██░░▒████▓ ░██▓ ▒██▒▒▒█████▓ ▒██▒   ░██▒\n  ▒ ░░    ▒ ░░▒░▒░░ ▒░ ░   ░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ▒ ▒ ░▒▓▒ ▒ ▒ ░ ▒░   ▒ ▒  ▒▒▓  ▒ ░ ▒▓ ░▒▓░░▒▓▒ ▒ ▒ ░ ▒░   ░  ░\n    ░     ▒ ░▒░ ░ ░ ░  ░     ░  ▒     ░ ▒ ▒░ ░ ░░   ░ ▒░░░▒░ ░ ░ ░ ░░   ░ ▒░ ░ ▒  ▒   ░▒ ░ ▒░░░▒░ ░ ░ ░  ░      ░\n  ░       ░  ░░ ░   ░      ░        ░ ░ ░ ▒     ░   ░ ░  ░░░ ░ ░    ░   ░ ░  ░ ░  ░   ░░   ░  ░░░ ░ ░ ░      ░   \n          ░  ░  ░   ░  ░   ░ ░          ░ ░           ░    ░              ░    ░       ░        ░            ░   \n                           ░                                                 ░                                   ";
        switch(id){
            case "Title Screen":
                clearScreen();
                System.out.print("\t\t\t\t\t\t");
                System.out.println("Welcome To...\n");
                System.out.println(theConundrumTitle);

                if(arg == "You Died"){
                    System.out.print("\t\t\t\t\t\t ");
                    System.out.println("YOU DIED!");
                    System.out.print("\t\t\t\t\t");
                    System.out.println("Press ENTER to restart Part I");
                    
                    break;
                } else {
                    System.out.print("\t\t\t\t\t");
                    System.out.println("Press ENTER to begin Part I");
                    break;
                }

            case "Enter Reminder":
                System.out.print("Press ENTER to continue");
                removeKey(KeyEvent.VK_ENTER);
                waitForEnter();
                printElement("Unline");
                break;

            case "Unline":
                System.out.println("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b                       ");
                break;
                
            case "Cutscene Header":
                System.out.println("╠═══════════════════════════════════╣ The Conundrum ╠═══════════════════════════════════╣\n");
                break;

            case "Hammer":
                System.out.println("                                                        \n                     @@@@@@@@@   @@@                    \n                  @@           @   .@ @@                \n                         @   @-     @=  @@              \n                          @@@         @@  @@            \n                          @             @@  @@          \n                           @             .@@@ @         \n                            @@                 @        \n                             @@@   :     @@  @@         \n                           @@  %@@      @#@    @  @@    \n                          @@  :  #@%  @@@   @@      @@  \n                        @@      @@       @@@ =@@@@    @ \n                      @@       @@         @  @@      @  \n                     @@       @@          @@       @@   \n                   @@       @@              @+  @@@     \n                  @#       @@                           \n                @@        @@                            \n              @@         @                              \n             @@        @@                               \n           @@         @@                                \n         @@          @                                  \n        @@         @@                                   \n      @@          @@                                    \n    @@          @@@@@@@@@@@@@@@@@@@@@                   \n   @@          @@        @@@@@@@@@@@@@@@@@@@@           \n  @@-        *@@      @@@@@@@@@@@@@@@@@@@@@@@@@@@@      \n @@        -@@ @@@@@@@@@@@@                             \n @@     @@@@@@@@@@@@@                                   \n @@@@@@@@@@@@@@                                         \n  @@@@@@@                                               \n                ");
                break;
            case "Dice":
                System.out.println("                                        -+***+-         \n                                  :=***=:   .-*#+-.     \n                             .-+#%*-         :====*#+.  \n                           -%#=+@@@-        :%@@*:+%@@: \n                           #@@=.::           :+#@#+:.#+ \n                           -@:*@*.       :=#@#=: :+=.=* \n                            %= .+%#=--+#%#=:    :@@@=-# \n                            :%    +@@@#:        .##- :% \n  .#@@#*@@@*+++%@#*=.        #=    =@%               .%.\n  +#.=%%#++-   .=++-+#+:     :#:##. %%       =@@*     %:\n .*+=- :+@#- :++-    =#@@*-   *+-@- -@.      %@@=     %-\n :%+@%:   -#@#%@%=---=#@%*@@#::#-    @*       .      :@:\n =*.+-   -- =@@@#++++++++===@# :#+.  *@   -++.     :*#- \n #*@%:  :@@=-@#. :.     -+: @:   =#- .@= =@@@:  -*#=.   \n.@-%%:  .@@--%-:%@@.   =@@=*#     .+#:%% :++:=#*=.      \n=%=*.  .#* .#* =@@+    :=::@.       .#@@=-+#*-          \n*#%@=  -@@::@-     *%+    #=          .**+:             \n-%-:   .++ *#     *@@=   -#                             \n -#=  -@@ .@+      ..-*+:#-                             \n   =*-.#@ +% -%@=   .@@++*.                             \n    .**: .@# +@#:    .-*#:                              \n      :*+#@- .:-=+****=:                                \n        :*%#*+=-.                                       \n                                                         ");
                break;
            case "Sword":
                System.out.print("                                                        \n                                              ::        \n                                         :+-:=*-        \n                                     :#:::::#-+.        \n                                    =-::::-+--*         \n                                   #:::::+----*         \n                                 .#:::::+-----+         \n                                -=::::=-----+=          \n                               +:::::*-----%            \n                              #::::-+----*=             \n                            :=::::*-----#.              \n                           =::::-+----*:                \n                          +::::*----=#                  \n                        .=::::*----#:                   \n                       -::::==---=#                     \n            .-.       =::::+----#.                      \n          .*-=@:    .=:::==---++                        \n           =%##+-=#*::::*----%.                         \n               %**---%=+---++                           \n                .%#*+--+*-#.                            \n                 -@@%**--*:                             \n                .@#%@@%**=-*                            \n               +##@+    =%#+%*#                         \n             :@#%%         *==@                         \n           .@@@@*           --                          \n       =*+#%%%@+                                        \n       :#---=@*                                         \n         *#=-++                                         \n           .+*:                                         \n                                                        \n                ");
                break;
            case "Rubble":
                System.out.println("                                                        \n                         =####=                         \n                        ########                        \n                       ##########                       \n                      #####  #####                      \n                     #####    #####                     \n                   .#####      #####                    \n                   #####        #####                   \n                 :####*          *####:                 \n                .#####  @         #####.                \n               =####= :@@@%*       =####=               \n              =####+ .@@@@:-@       +####=              \n             +####: +@@@@@@.  -@%:   :####+             \n            *####: =@@@@@@@  #@@@@+   :####*            \n           *####. #@@@@@@@@#  @@@@%    .####*           \n          #####  #@@@@@@@@@@   ##   -@@+ #####          \n         #####. %@@@@@@@@@@@@ -@@.  #@@@ .#####         \n        #####  @@@@@@@@@@@@@@@ :      +#+- #####        \n       #####  %@@@@@@@@@@@@@@@   @@ =@@@@@@.#####       \n      #####  @@@@@@@@@@@@@@@@@@#  - #@@@@@@+ #####      \n    .####*  @@@@@@@@@@@@@@@@@@@@@-   #@@@@@   *####.    \n   :#####  @@@@@@@@@@@@@@@@@@@@@@@:            #####:   \n   #####                                        #####   \n  .##################################################.  \n   :################################################:   \n                                                        \n                ");
                break;
            case "Pipe":
                System.out.println("                                                        \n                                                                       \n.%@@@@@@@@@@@@:                                         \n@@.          *@.                                  -@@@@:\n#@@@@@@@@@@@@@#                  .#@@@@@@@@@@@@@@@@%  %@\n #@*=-----:=@%                -@@@+..  .         :@#  %@\n #@+-::::  -@%              -@@+...::::::.......:=@#  %@\n #@+-::::  -@%             #@+..:::::::::::::::::=@#  %@\n #@+-:::.  :@%           .%@-..:::::::-----------=@%  %@\n #@+-:::.  :@%          .%@-.::::::-=+#%%%@@@@@@@@@@. @@\n #@+-:::.  :@%          +@+..::::--*@@#=:.........=@@@@-\n #@+-:::.  :@%          %%:.:::::-*@%                   \n #@+=::::. -@%         .@#..::::-=%@.                   \n @@@@@@@@@@@@@         =@@@@@@@@@@@@-                   \n@@:          #@.      +@+.         *@-                  \n%@%*********#@%       -@@#*********@@:                  \n %@##*****+*@@         :@@#******#@@:                   \n #@+-:::.  -@%         .@%=-::::-=%@.                   \n #@+-:::.  :@%         :@%=-::::-=%@.                   \n =@#=::::   *@=       .%@+-:::::-+@#                    \n  @@=-::::   +@@#@@@@%@%+-:::::-=#@-                    \n  =@%=-::::    =@* :@@+--:::::--*@#                     \n   +@%=-:::::..=@* :@%-::::::-=*@%                      \n    -@@+=-:::::+@* :@%-:::::-=%@*                       \n      %@@==-:::+@* :@%-::-==#@@:                        \n        +@@@*==*@* -@@==+%@@#.                          \n           =@@@@@# -@@@@@+.                             \n                -@@@*                                   \n                                                        \n                                                        \n                ");
                break;
            case "Eyes":
                System.out.println("                                                                                      \n                &&&                                        &&&                        \n                &&&&&&&&&&&&&&                              &&&&&&&&&&&&&&            \n                &&&&&  X&&&&&&&&&&.                          &&&&&&&&&&&  :&&&&&         \n           &&&&         &&&&&&&&& &                      &  &&&&&&&&&&     &&&&       \n         &&&&           &&&&&&&&&& X                  & &   $&&&&&&&&&&      &&&&     \n          &&            &&&&&&&&&&&                         &&&&&&&&&&&       &&      \n           &       &&&&& &&&&&&&&&&                    &&&&&&&&&&    &&      &&       \n            &      &     &&&&& X&&&                    &&+  &&&&&    &&      &        \n             &     &&    +&&&&   x&                   &&    &&&&     &&     &         \n              &     &     &&&     &&                  &&     &&$    :&     x          \n                     &    &       &                    &&      X    &                 \n                  +   &                                 &&             :              \n                    &&&&&&&&&&&&$                         &&&&&&&&&&&&&               \n                                                                                      \n                ");
                break;
            case "Lock":
                System.out.println("                .........               \n            ..+&x:....;x&x.             \n           .Xx.:;+xxxx+;;+$+.           \n          .&::+X$;.. ..X+;;X+.          \n         .X::x&;        x+;x&.          \n         +x.+$;.        ;+;+&:          \n         X+:x$.         ;x++&;          \n         X+:x$...::;;++xXx+x&+..        \n       +X&x;X&+;;;;::;:;+x$$XX$:        \n       ++X+xxxxxxx+;;::::;;;++$:        \n       +;x;++;;;;;:::;;+++++++$:        \n       ++X;+++;;;;;::;;+++++++$:        \n       x+X;+++;;;;;$&&x;++++++$:        \n       x+$;+++;;;;;+&$;+++++++$:        \n       x+X++++;;;;;X&&;+++++++$:        \n       xxX++++;;;;;;;;;++++++x$:        \n       xXX++++;;;;;::;;++xxxX$&+..      \n       :x&$XXXXXXXXX$&&&&&Xx+;;;;;:..   \n                                        \n                ");
                break;
            case "Winged Boots":
                System.out.println("                ..                               .      \n                .;.::                              .;.+.\n                ..;.;:                            .;.;..\n                .::X;x;.                         :x;x;.:\n                .;;.$x$x.:                    :.;$x$;:+.\n                ..;x;XX$++:.                ..++XxX;x+..\n                .;:.X$$$x$Xx..             .+$$x$$XX::;.\n                 .;$x+&$+X&&&:            .$&&$+X&x+$+. \n                  :;:x&$xX$&XX:   ..::.  :X$&$X+$&X;;;. \n                   .+$$$$X$&$$+.;+:...X+ ;$$&$X$&$$x.   \n                .:.:;;;xXxxXXx:.:;x+++x;::xXXxxXx;:;;::.\n                ..:::;+xXX+xXX;:;x+;;x++:;xXXxXXx+;::.:.\n                     ..+X$$X$&$$X+;xxx;X$$&$$X&X+:.     \n                       .;x&xx$&&$x;xx+xX&&&Xx&x;.       \n                         .:+X$x+$&Xx:+xXxx$Xx;.         \n                           ..;:.;X:;++;;::;:.           \n                                ;&:;+++xX.              \n                                +$xx+;;+X;              \n                                :$X.   ..x.             \n                                :$&&&$XX&&;             \n                                .;$&&$$&&X.             \n                                    ..                  \n                ");
                break;
            case "Gears":
                System.out.println("                                                        \n                             :;;:                       \n                             ;;;;.    .;;;:             \n                             ;;;;;:..;;;;;:             \n                      ::.   .;;;;;;;;;;;;;              \n                    .;;;;;;;;;;;;;;;;;;;;;              \n                      :;;;;;;;        .;;;;;;;;;.       \n                        ;;;;:          .;;;;;;;;:       \n                        ;;;;            :;;;;:.         \n                     .:;;;;;            :;;;.           \n                   .;;;;;;;;;          .;;;;:           \n              ..    :;;;;;;;;;:.     .;;;;;;;;:         \n             ;XX+.    .;:..;;;;;;;;;;;;;;;;;;;;.        \n             ;XXX;. .;XXX;.;;;;;;;;;;;;;.   ::.         \n       ..   .+XXXXXXXXXX+.;;;;;...;;;;;.                \n      ;XXXXxXXXXXxxXXXXX+.;;;:     :;;;;                \n      .;XXXXXX;.     :xXXXxxXX; .::::;:.:::.            \n         +XXX.        .+XXXXXX+  :;;::::;;:             \n         xXX+          ;XXX;.    :;;;;;;;;:. ...        \n     .+XXXXXx          ;XXx.:;;:;;::.  ..:;;;;;:.       \n     +XXXXXXX+        :XXXX;..:;;:.       :;;:.         \n          .xXXXx.  .+XXXXXXXXx.:;:.       .:;.          \n           :XXXXXXXXXXX:  .xx.:;;:.      .:;;;;:        \n          .XXXX;..xXXX+     .;;;;;;:....:;;;::;:.       \n          .XX+.    xXXx.         .:;;;;;;;:.            \n                    ;;.          .:;:...:;;.            \n                                 .::.   .::.            \n                                                        \n                ");
                break;
            case "Elevator Buttons":
                System.out.println("                                                    \n                        ..::..                          \n                .;+x$$$X$$x+;.                  \n                  ;+$+:. .. .:+Xx;.                \n                 XXx.   ;&&;   .xXx                \n                Xxx    x&&&&x    xxX               \n                +&.  :$&&&&&&X:  .$+               \n                ;&. ;&&&&&&&&&&; .$;               \n                xX+.;++++++++++;.+XX               \n                .xX+............+Xx.               \n                 .+xX;.      .;xx+.                \n                   :+xXXx++xXXx+:                  \n                      .:;;;;:.                     \n                      .:;;;;:.                     \n                   .;xXXxxxxxXx;:                  \n                 .+xX;.      .;Xx+.                \n                .xX+............+Xx.               \n                xX+.;++++++++++;.+XX               \n                ;&. ;&&&&&&&&&&+ .$;               \n                ;&.  :$&&&&&&$:  .$+               \n                Xxx    x&&&&X    xxX               \n                 XXx.   ;&&+   .xXX                \n                  ;+$+..  . ..+$x;.                \n                   .;+x$$$$$$x+;.                  \n                       ..::..                      \n                                                   \n                   ");
                break;
            case "You Win":
                System.out.println(theConundrumTitle);
                System.out.print("\t\t\t\t\t");
                System.out.print("THANKS FOR PLAYING :)");
                System.out.print("\n\n\n");
                System.out.println("╠═══════════════════════════════════╣ Statistics ╠═══════════════════════════════════╣");
                System.out.print("\n");
                System.out.println("Challenges Completed: " + challengesCompleted);
                System.out.println("Moves Taken In Maze: " + mazeMoves);
                System.out.println("Times Jumped: " + platformerJumps);
                System.out.println("Enemies Killed: " + enemiesKilled);
                System.out.println("Damage Taken From Enemies: " + damageTaken);
                System.out.println("Moves Taken In Map: " + timesMoved);
                System.out.println("Times Ran Into Wall: " + timesRanIntoWall);
        }
    }

    @SuppressWarnings("unused")
    public static void createMap(Map map){
        //Start room
        Room start = map.addRoom("GO", 0, 0).setRoomType("Start");
        start.visit();

        //Path #1: Pipes
        Room talk1 = map.addRoom("T1", 0, 1).makeDialogueRoom().discover();
        Room pipes1 = map.addRoom("P1", 0, 2).makeChallengeRoom(new Maze("Pipes: Level 1", new OrderedPair(49, 25)));
        Room pipes2 = map.addRoom("P2", 0, 3).makeChallengeRoom(new Maze("Pipes: Level 2", new OrderedPair(59, 29)));
        Room pipes3 = map.addRoom("P3", 0, 4).makeChallengeRoom(new Maze("Pipes: Level 3", new OrderedPair(69, 35)));
        Room pipes4 = map.addRoom("P4", 0, 5).makeChallengeRoom(new Maze("Pipes: Level 4", new OrderedPair(79, 39)));
        Room power1 = map.addRoom("A1", 1, 5).makeAbilityRoom("Pipe Hammer");
        Room key1 = map.addRoom("K1", -1, 4).makeItemRoom("Blue Key").lock();
        Room death1 = map.addRoom("D1", 1, 3).makeDeathRoom();

        //Path #2: Spikes
        Room talk2 = map.addRoom("T2", -1, 0).makeDialogueRoom().discover();
        Room spike1 = map.addRoom("S1", -2, 0).makeChallengeRoom(new Platformer("Spikes: Level 1", new OrderedPair(80, 30), 1));
        Room spike2 = map.addRoom("S2", -3, 0).makeChallengeRoom(new Platformer("Spikes: Level 2", new OrderedPair(80, 30), 2));
        Room spike3 = map.addRoom("S3", -4, 0).makeChallengeRoom(new Platformer("Spikes: Level 3", new OrderedPair(80, 30), 3));
        Room spike4 = map.addRoom("S4", -5, 0).makeChallengeRoom(new Platformer("Spikes: Level 4", new OrderedPair(80, 30), 4));
        Room power2 = map.addRoom("A2", -5, -1).makeAbilityRoom("Winged Boots");
        Room key2 = map.addRoom("K1", -4, 1).makeItemRoom("Green Key").lock();
        Room death2 = map.addRoom("D2", -4, 2).makeDeathRoom().lock();
        Room talk3 = map.addRoom("T3", -1, 1).makeDialogueRoom();

        //Path #3: Pikes
        Room talk4 = map.addRoom("T4", 0, -1).makeDialogueRoom().lock();
        talk4.discover();
        Room pikes1 = map.addRoom("F1", 0, -2).makeChallengeRoom(new Swarm("Pikes: Level 1", new OrderedPair(80, 30), 1));
        Room pieks2 = map.addRoom("F2", 0, -3).makeChallengeRoom(new Swarm("Pikes: Level 2", new OrderedPair(80, 30), 2));
        Room pikes3 = map.addRoom("F3", 0, -4).makeChallengeRoom(new Swarm("Pikes: Level 3", new OrderedPair(80, 30), 3));
        Room pikes4 = map.addRoom("F4", 0, -5).makeChallengeRoom(new Swarm("Pikes: Level 4", new OrderedPair(80, 30), 4));
        Room power3 = map.addRoom("A3", 1, -5).makeAbilityRoom("Long Sword");
        Room key3 = map.addRoom("K3", -1, -3).makeItemRoom("Red Key").lock();
        Room death3 = map.addRoom("D3", 1, -1).makeDeathRoom().lock();
    }

    public static void gameTurn(Map map){

        clearScreen();
        System.out.println(map.toString());
        String input = nextString(false, true);
        String command = toCommand(input);
        if("NORTH SOUTH EAST WEST".contains(command)){
            if(map.existsUnlockedRoomInDirection(command)){
                map.playerMove(command);
            } else {
                feedback = "You cannot move " + command.toLowerCase() + "!";
                timesRanIntoWall++;
            }
        }
        if(command.equals("KEY")){
            Room room = map.getRoom(map.position());
            if(room.hasItem()){
                map.collectItem(room.getItem());
                feedback = "You now have a shiny new " + map.inventory().get(map.inventory().size() - 1).id() + "!";
            } else {
                feedback = "There is nothing to pick up!";
            }
        }
    }

    public static int RollTheDice(){
        numberToRoll = 0;

        if(!map.position().equals(0, 0)){
            TheConundrum.println("To evade the danger, you must ROLL THE DICE!");
        }
        TheConundrum.printElement("Enter Reminder");
        TheConundrum.clearScreen();
        TheConundrum.printElement("Cutscene Header");
        TheConundrum.printElement("Dice");
        switch(TheConundrum.deathRoomsEncountered){
            case 0:
                TheConundrum.println("Each time you roll the dice, your chance of survival decreases.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("Since you haven't rolled the dice before, you must roll a 5 or higher to survive.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("Chance of Survival: 83%. Good Luck! :)");
                TheConundrum.printElement("Enter Reminder");
                numberToRoll = 5;
                break;
            case 1:
            TheConundrum.println("Each time you roll the dice, your chance of survival decreases.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("Since you've rolled the dice once before, you must roll a 7 or higher to survive this time.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("Chance of Survival: 58%. Good Luck! :/");
                TheConundrum.printElement("Enter Reminder");
                numberToRoll = 7;
                break;

            case 2:
                TheConundrum.println("Each time you roll the dice, your chance of survival decreases.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("Since you've rolled the dice twice before, you must roll a 9 or higher to survive this time.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("Chance of Survival: 28%. Good Luck! :(");
                TheConundrum.printElement("Enter Reminder");
                numberToRoll = 9;
                break;

            case 3:
                TheConundrum.println("Each time you roll the dice, your chance of survival decreases.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("Since you've rolled the dice thrice before, you must roll an 11 or higher to survive this time.");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("Chance of Survival: 8%. Good Luck! :((");
                TheConundrum.printElement("Enter Reminder");
                numberToRoll = 11;
                break;

            default:
                TheConundrum.println("Each time you roll the dice, your chance of survival decreases.");
                TheConundrum.printElement("Enter Reminder");
                numberToRoll += 2;
                TheConundrum.println("Why you've come back here again, I don't know. You need to roll a(n) " + numberToRoll +".");
                TheConundrum.printElement("Enter Reminder");
                TheConundrum.println("Chance of Survival: 0%. You don't win this.");
                TheConundrum.printElement("Enter Reminder");
                break;
        }

        int rolls = 0;
        OrderedPair roll = new OrderedPair(0, 0);
        String[][] blocks = new String[21][62];
        while(rolls < 30){
            for(int y = 0; y < blocks[0].length; y++){
                for(int x = 0; x < blocks.length; x++){
                    blocks[x][y] = " ";
                }
            }

            roll = new OrderedPair((int)(Math.random() * 6 + 1), (int)(Math.random() * 6 + 1));

            blocks[10] = "    ╠══════════════════ Roll The Dice ════════════════════╣   ".split("");

            blocks[12] = "          ╔══════════════╗          ╔══════════════╗          ".split("");
            blocks[13] = "          ║              ║          ║              ║          ".split("");
            blocks[14] = "          ║              ║          ║              ║          ".split("");
            blocks[15] = "          ║              ║          ║              ║          ".split("");
            blocks[16] = "          ║              ║          ║              ║          ".split("");
            blocks[17] = "          ║              ║          ║              ║          ".split("");
            blocks[18] = "          ╚══════════════╝          ╚══════════════╝          ".split("");

            blocks[20] = ("    ╠═══════════════════════╣ " + (roll.x() + roll.y()) + " ╠══" + (roll.x() + roll.y() > 9 ? "\b" : "") + "════════════════════════╣   ").split("");

            String diceCode = "";
            
            switch(roll.x()){
                case 1:
                    diceCode = "15 17";
                    break;
                case 2:
                    diceCode = "17 13 13 21";
                    break;
                case 3:
                    diceCode = "17 13 15 17 13 21";
                    break;
                case 4:
                    diceCode = "13 13 17 13 13 21 17 21";
                    break;
                case 5:
                    diceCode = "13 13 17 13 13 21 17 21 15 17";
                    break;
                case 6:
                    diceCode = "13 13 15 13 17 13 13 21 15 21 17 21";
            }
            diceCode = diceCode.replaceAll(" ", "");
            for(int i = 0; i < roll.x(); i++){
                int x = Integer.parseInt(diceCode.substring(i * 4, i * 4 + 2));
                int y = Integer.parseInt(diceCode.substring(i * 4 + 2, i * 4 + 4));

                blocks[x][y] = "█";
                blocks[x][y + 1] = "█";
            }

            switch(roll.y()){
                case 1:
                    diceCode = "15 17";
                    break;
                case 2:
                    diceCode = "17 13 13 21";
                    break;
                case 3:
                    diceCode = "17 13 15 17 13 21";
                    break;
                case 4:
                    diceCode = "13 13 17 13 13 21 17 21";
                    break;
                case 5:
                    diceCode = "13 13 17 13 13 21 17 21 15 17";
                    break;
                case 6:
                    diceCode = "13 13 15 13 17 13 13 21 15 21 17 21";
            }
            diceCode = diceCode.replaceAll(" ", "");
            for(int i = 0; i < roll.y(); i++){
                int x = Integer.parseInt(diceCode.substring(i * 4, i * 4 + 2));
                int y = Integer.parseInt(diceCode.substring(i * 4 + 2, i * 4 + 4));

                blocks[x][y + 26] = "█";
                blocks[x][y + 27] = "█";
            }

            String str = "";
            str += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
            for(int x = 0; x < blocks.length; x++){
                for(int y = 0; y < blocks[0].length; y++){
                    str += blocks[x][y];
                }
                str += "\n";
            }
            println(str);
            sleep(rolls * 15);
            rolls++;
        }
        int total = roll.x() + roll.y();
        deathRoomsEncountered++;
        return total;
    }

    public static boolean playerHasAbility(String ability){
        for(String a : map.abilities()){
            if(a.equals(ability)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){

        /**
         * Sample Challenge object instantiations
         * Maze maze1 = new Maze("amazing maze", new OrderedPair(0, 0), new OrderedPair(79, 39));
         * Platformer platformer1 = new Platformer("amazing platformer", new OrderedPair(0, 0), new OrderedPair(80, 30), 1, 1);
         * Swarm swarm1 = new Swarm("amazing swarm", new OrderedPair(0, 0), new OrderedPair(80, 30), 1);
        */
        if(args.length > 0){
            arg = args[0];
        } else {
            arg = "";
        }

        map = new Map(new OrderedPair(10, 12));
        keyChecker.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent k) {
                    keysPressed.add(k.getKeyCode());
            }
            public void keyReleased(KeyEvent k){
                for(int i = 0; i < keysPressed.size(); i++){
                    if(keysPressed.get(i) == k.getKeyCode()){
                        keysPressed.remove(i);
                        i--;
                    }
                }
            }
        });

        printElement("Title Screen");
        waitForEnter();
        
        clearScreen();
        sleep(500);
        println("You find yourself lying awake in a rusty, abandoned factory. You possess a strange sensation, like there is someone watching.");
        sleep(500);
        printElement("Enter Reminder");

        println("An electronic voice echoes throughout the ruins: \n'Hello, human, my name is Watson. Who are you?'");
        name = nextString(false, false);
        sleep(500);

        println("Watson: Ah, nice to meet you, " + name + ".");
        sleep(500);
        println("It seems you have been asleep for quite awhile. I'm glad you finally awoke.");
        sleep(500);
        printElement("Enter Reminder");

        println("You start to get up and walk away.");
        sleep(500);
        println("\nWatson: Wait! I've got to explain something before you start exploring.");
        sleep(500);
        printElement("Enter Reminder");

        println("Watson: See that door to the east? It's locked, and the only way to open it is to insert a special microchip into its keyhole.");
        sleep(500);
        printElement("Enter Reminder");

        println("Watson: If you look over there, you'll see an elevator.");
        sleep(500);
        println("There are three keys to the elevator, Red, Green, and Blue, respectively.");
        sleep(500);
        printElement("Enter Reminder");

        println("Watson: Other than that, there are three paths to choose from.");
        println("Each path will push your physical ability to the limit, in different ways.");
        sleep(500);
        printElement("Enter Reminder");

        println("Each key color is located in one of the paths. Good Luck!");
        sleep(500);
        //println("I can't tell you why right now, but you should probably finish as fast as possible.");
        printElement("Enter Reminder");
        println("System: Type 'North', 'South', 'East', or 'West' to move through the map.'");
        printElement("Enter Reminder");
        println("System: You can also say 'Pick up <item>' to pick up an item.");
        printElement("Enter Reminder");
        println("System: As you move in the map, you will unlock new rooms.");
        printElement("Enter Reminder");

        createMap(map);
        while(!playerHasWon && !playerHasDied){
            gameTurn(map);
        }
    }                                 
}