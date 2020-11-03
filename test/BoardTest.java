/* Name: Joey Zhao
 * PennKey: joeyzhao
 * Recitation: 202
 * 
 * Execution: java BoardTest
 * 
 * Tests all the methods in Board.Java
 * 
 */
public class BoardTest {
    
    /* 
     * Description: prints the values in the double array to 
     *              visualize the grid
     * 
     * Input: a double array of chip objects
     * Output: does not return anything
     */
    public static void draw(Chip[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                
                // uses numbers to represent a player's move
                if (grid[row][col] != null) {
                    System.out.print(grid[row][col].getPlayer());
                }
                
                // represents empty slots
                else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        
        // creates board and chip instances
        Board test = new Board();
        Chip player1 = new Chip(1);
        Chip player2 = new Chip(2);
        
        // checks for empty board draw
        //draw(test.getGrid());
        
        // checks for horizontal win
//        test.addMove(player2, 1);
//        test.addMove(player2, 2);
//        test.addMove(player2, 3);
//        test.addMove(player2, 4);
//        draw(test.getGrid());
//        System.out.println(test.checkForWin());
//        System.out.println(test.checkForDraw());        
//        System.out.println(test.isGameOver());
        
        // checks for vertical win
//        test.addMove(player1, 1);
//        test.addMove(player1, 1);
//        test.addMove(player1, 1);
//        test.addMove(player1, 1);
//        draw(test.getGrid());
//        System.out.println(test.checkForWin());
//        System.out.println(test.checkForDraw());        
//        System.out.println(test.isGameOver());
        
        // checks for diagonal win from top left to right
//        test.addMove(player1, 0);
//        test.addMove(player1, 0);
//        test.addMove(player1, 0);
//        test.addMove(player2, 0);
//        test.addMove(player1, 1);
//        test.addMove(player1, 1);
//        test.addMove(player2, 1);
//        test.addMove(player1, 2);
//        test.addMove(player2, 2);
//        test.addMove(player2, 3);
//        draw(test.getGrid());
//        System.out.println(test.checkForWin());
//        System.out.println(test.checkForDraw());        
//        System.out.println(test.isGameOver());
        
        // checks for diagonal win from top right to left
//        test.addMove(player1, 6);
//        test.addMove(player1, 6);
//        test.addMove(player1, 6);
//        test.addMove(player2, 6);
//        test.addMove(player1, 5);
//        test.addMove(player1, 5);
//        test.addMove(player2, 5);
//        test.addMove(player1, 4);
//        test.addMove(player2, 4);
//        test.addMove(player2, 3);
//        draw(test.getGrid());
//        System.out.println(test.checkForWin());
//        System.out.println(test.checkForDraw());        
//        System.out.println(test.isGameOver());
        
        // checks for draw
//        test.addMove(player1, 0);
//        test.addMove(player2, 0);
//        test.addMove(player1, 0);
//        test.addMove(player2, 0);
//        test.addMove(player1, 0);
//        test.addMove(player2, 0);
//        test.addMove(player1, 1);
//        test.addMove(player2, 1);
//        test.addMove(player1, 1);
//        test.addMove(player1, 1);
//        test.addMove(player2, 1);
//        test.addMove(player1, 1);
//        test.addMove(player2, 2);
//        test.addMove(player1, 2);
//        test.addMove(player2, 2);
//        test.addMove(player2, 2);
//        test.addMove(player1, 2);
//        test.addMove(player2, 2);
//        test.addMove(player2, 3);
//        test.addMove(player2, 3);
//        test.addMove(player1, 3);
//        test.addMove(player1, 3);
//        test.addMove(player1, 3);
//        test.addMove(player2, 3);
//        test.addMove(player1, 4);
//        test.addMove(player1, 4);
//        test.addMove(player2, 4);
//        test.addMove(player2, 4);
//        test.addMove(player2, 4);
//        test.addMove(player1, 4);
//        test.addMove(player1, 5);
//        test.addMove(player2, 5);
//        test.addMove(player1, 5);
//        test.addMove(player1, 5);
//        test.addMove(player1, 5);
//        test.addMove(player2, 5);
//        test.addMove(player2, 6);
//        test.addMove(player1, 6);
//        test.addMove(player2, 6);
//        test.addMove(player1, 6);
//        test.addMove(player2, 6);
//        test.addMove(player1, 6);
//        draw(test.getGrid());
//        System.out.println(test.checkForWin());
//        System.out.println(test.checkForDraw());
//        System.out.println(test.getCount());
//        System.out.println(test.isGameOver());
    }
}
