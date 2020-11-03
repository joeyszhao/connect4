/* Name: Joey Zhao
 * PennKey: joeyzhao
 * Recitation: 202
 * 
 * This program creates a chip to represent a player
 * 
 */
public class Chip {
    private int player; // represents a player
   
    /*
     * Constuctor: creates an instance of a chip that stores an
     *             int variable to represent the player
     */
    public Chip(int player) {
        this.player = player;
    }
    
    /*
     * Description: getter method for the player field 
     * 
     * Input: does not take in any parameters
     * Output: returns the player field as an int
     */
    public int getPlayer() {
        return player;
    }
}