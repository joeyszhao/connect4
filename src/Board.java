/* Name: Joey Zhao
 * PennKey: joeyzhao
 * Recitation: 202
 * 
 * This program creates the board for Connect 4 and functionalities
 * that check for win, draw, and whether the game is over.
 * 
 */

public class Board {
    private Chip[][] grid; // board of connect four
    private int count; // counter for chips in board
    private boolean running; // indicates if the game is running
    private int row; // row of the grid
    
    /*
     * Constructor: creates an instance of the board
     */
    public Board() {       
        grid = new Chip[6][7]; // initializes the board
    }
    
    /*
     * Description: getter method for row field
     * 
     * Input: does not take in any parameters
     * Output: returns the row field as an int
     */
    public int getRow() {
        return row;
    }
    
    /*
     * Description: One player makes a move and drops a chip
     * 
     * Input: a chip and a column number that the player wants
     *        to insert the chip at
     * Output: does not return anything
     */
    public void addMove(Chip chip, int col) {
        row = 0; // initializes row
        
        boolean nothingBelow = true; 
        
        // prevents from adding to a full column
        if (grid[0][col] == null) {
            while (row <= 5 && nothingBelow) {
                if (grid[row][col] == null) {
                    row++;
                }
                else { 
                    nothingBelow = false;
                }
            }
            
            // adds the chip in the appropriate location
            grid[row - 1][col] = chip;
            count++;
        }
        
        // so that if the column is full, does nothing
        else {
            nothingBelow = false;
        }
    }
    /*
     * Description: Checks for a win that is if there are 4 chips 
     *              in a row horizontally, vertically, or diagonally
     * 
     * Input: does not take in any parameters
     * Output: a boolean indicating if there is a win
     */
    public boolean checkForWin() {
        running = true;
        
        // checks for win horizontally
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length - 3; col++) {
                if (grid[row][col] != null && grid[row][col + 1] != null &&
                   grid[row][col + 2] != null && grid[row][col + 3] != null) {
                    
                    if (grid[row][col].getPlayer() == 
                        grid[row][col + 1].getPlayer() &&
                        grid[row][col].getPlayer() == 
                        grid[row][col + 2].getPlayer() && 
                        grid[row][col].getPlayer() == 
                        grid[row][col + 3].getPlayer()) {
                        running = false;
                        return true;
                    }
                }
            }
        }
        
        // checks for win vertically
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length - 3; row++) {
                if (grid[row][col] != null && grid[row + 1][col] != null &&
                   grid[row + 2][col] != null && grid[row + 3][col] != null) {
                    
                    if (grid[row][col].getPlayer() == 
                        grid[row + 1][col].getPlayer() &&
                        grid[row][col].getPlayer() == 
                        grid[row + 2][col].getPlayer() && 
                        grid[row][col].getPlayer() == 
                        grid[row + 3][col].getPlayer()) {
                        running = false;
                        return true;
                    }
                }
            }
        }
        
        // checks for win diagonally from top left to right
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[row].length - 3; col++) {
                if (grid[row][col] != null && grid[row + 1][col + 1] != null &&
                   grid[row + 2][col + 2] != null && 
                    grid[row + 3][col + 3] != null) {
                    
                    if (grid[row][col].getPlayer() == 
                        grid[row + 1][col + 1].getPlayer() &&
                        grid[row][col].getPlayer() == 
                        grid[row + 2][col + 2].getPlayer() && 
                        grid[row][col].getPlayer() == 
                        grid[row + 3][col + 3].getPlayer()) {
                        running = false;
                        return true;
                    }
                }
            }   
        }
        
        // checks for win diagonally from top right to left
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 3; col < grid[row].length; col++) {
                if (grid[row][col] != null && grid[row + 1][col - 1] != null &&
                   grid[row + 2][col - 2] != null && 
                    grid[row + 3][col - 3] != null) {
                    
                    if (grid[row][col].getPlayer() == 
                        grid[row + 1][col - 1].getPlayer() &&
                        grid[row][col].getPlayer() == 
                        grid[row + 2][col - 2].getPlayer() && 
                        grid[row][col].getPlayer() == 
                        grid[row + 3][col - 3].getPlayer()) {
                        running = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /*
     * Description: getter method for the grid field
     * 
     * Input: does not take in any parameters
     * Output: returns the grid as a double array of chip objects
     */
    public Chip[][] getGrid() {
        return grid;
    }
    
    /*
     * Description: getter method for count field
     * 
     * Input: does not take in any parameters
     * Output: returns the count as an int variable
     */
    public int getCount() {
        return count;
    }
    
    /*
     * Description: Checks for if there is a draw
     * 
     * Input: does not take in any parameters
     * Output: boolean indicating if the game is a draw
     */
    public boolean checkForDraw() {
        if (count == 42) {
            return true;
        }
        return false;
    }
    
    /*
     * Description: Checks if the game is over aka if there is a win
     *              or if the game is a draw
     * 
     * Input: does not take in any parameters
     * Output: boolean indicating if the game is over
     */
    public boolean isGameOver() {
        
        // checks for four in a row
        if (checkForWin() == true) {
            return true;
        }
        
        // checks for draw
        if (checkForDraw() == true) {
            return true;
        }
        return false;
    }
}
