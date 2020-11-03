/* Name: Joey Zhao
 * PennKey: joeyzhao
 * Recitation: 202
 * 
 * Execution: java Connect 4
 * 
 * This program implements the game of Connect 4
 * 
 */
public class Connect4 {
    
    /*
     * Constructor: creates an instance of the connect 4 object
     * 
     */
    public Connect4() {
        
        // draws mode options
        PennDraw.setPenColor(PennDraw.RED);
        PennDraw.filledRectangle(0.5, 0.6, 0.15, 0.05);
        PennDraw.setPenColor(PennDraw.YELLOW);
        PennDraw.filledRectangle(0.5, 0.4, 0.15, 0.05);
        PennDraw.setPenColor(PennDraw.WHITE);
        PennDraw.setFontBold();
        PennDraw.text(0.5, 0.6, "1 Player Mode");
        PennDraw.text(0.5, 0.4, "2 Player Mode");
        
        // draws the title
        PennDraw.setFontBold();
        PennDraw.setFontSize(60);
        PennDraw.setPenColor(PennDraw.YELLOW);
        PennDraw.text(0.5, 0.8, "C O N N E C T");
        PennDraw.setFont();
        PennDraw.setFontSize(62);
        PennDraw.setPenColor(PennDraw.WHITE);
        PennDraw.text(0.5105, 0.8, "C O N N E C T");
        
        PennDraw.setFontBold();
        PennDraw.setPenColor(PennDraw.RED);
        PennDraw.setFontSize(100);
        PennDraw.text(0.5, 0.15, "4");
        PennDraw.setFontSize(95);
        PennDraw.setPenColor(PennDraw.WHITE);
        PennDraw.text(0.51, 0.15, "4");
        
        boolean twoPlayerMode = false; 
        boolean modeChosen = false;
        boolean mouseLastClicked = false;
        
        // functions as a delay
        while (PennDraw.mousePressed()) {
            mouseLastClicked = false;
        } 
        
        // starts game when a mode is chosen
        while (modeChosen == false) {
            double x = 0.0;
            double y = 0.0;
            
            // if the mouse is clicked
            if (PennDraw.mousePressed()) {                
                
                // gets the coordinates of the mouse cursor
                x = PennDraw.mouseX();
                y = PennDraw.mouseY();
                
                // if the one player button is clicked
                if ((x >= 0.35 && x <= 0.65) && (y >= 0.55 && y <= 0.65)) {
                    modeChosen = !modeChosen;
                }
                
                // if the two player button is clicked
                if ((x >= 0.35 && x <= 0.65) && (y >= 0.35 && y <= 0.45)) {
                    twoPlayerMode = true;
                    modeChosen = !modeChosen;
                }
            }
        }
        
        // functions as a delay
        while (PennDraw.mousePressed()) {
            mouseLastClicked = false;
        }
        
        Board connect4 = new Board(); // creates an instance of board
        
        Chip player1 = new Chip(1); // creates a chip to represent player 1
        Chip player2 = new Chip(2); // creates a chip to represent player 2
        
        PennDraw.setCanvasSize(640, 600); 
        PennDraw.picture(0.5, 0.5, "Connect4Board.png");
        
        // draws the title
        PennDraw.setFontBold();
        PennDraw.setFontSize(40);
        PennDraw.setPenColor(PennDraw.YELLOW);
        PennDraw.text(0.45, 0.047, "C O N N E C T");
        PennDraw.setPenColor(PennDraw.RED);
        PennDraw.setFontSize(40);
        PennDraw.text(0.73, 0.047, "4");
        
        // sets color of drop buttons
        PennDraw.setPenColor(PennDraw.BOOK_LIGHT_BLUE);
        PennDraw.setPenRadius(0.005);
        
        // draws boxes for the buttons
        PennDraw.rectangle(0.08, 0.95, 0.05, 0.025);
        PennDraw.rectangle(0.22, 0.95, 0.05, 0.025);
        PennDraw.rectangle(0.36, 0.95, 0.05, 0.025);
        PennDraw.rectangle(0.50, 0.95, 0.05, 0.025);
        PennDraw.rectangle(0.64, 0.95, 0.05, 0.025);
        PennDraw.rectangle(0.78, 0.95, 0.05, 0.025);
        PennDraw.rectangle(0.92, 0.95, 0.05, 0.025);
        
        // draws the "drop" text in the buttons
        PennDraw.setFont();
        PennDraw.text(0.08, 0.95, "Drop");
        PennDraw.text(0.22, 0.95, "Drop");
        PennDraw.text(0.36, 0.95, "Drop");
        PennDraw.text(0.50, 0.95, "Drop");
        PennDraw.text(0.64, 0.95, "Drop");
        PennDraw.text(0.78, 0.95, "Drop");
        PennDraw.text(0.92, 0.95, "Drop");
        
        boolean turn = true; // enables players to alternate turns
        double firstTurn = Math.random(); 
        
        // randomizes who starts the game
        if (firstTurn > 0.5) {
            turn = true;
        }
        else {
            turn = false;
        }
        
        // two player mode
        if (twoPlayerMode) {
            while (connect4.isGameOver() == false) {
                
                // player 1's turn
                if (turn && connect4.isGameOver() == false) {
                    double x = 0.0;
                    double y = 0.0;
                    
                    // if the mouse is clicked
                    if (PennDraw.mousePressed()) {                
                        if (!mouseLastClicked) {
                            int number = connect4.getCount();
                            
                            // gets the coordinates of the mouse cursor
                            x = PennDraw.mouseX();
                            y = PennDraw.mouseY();
                            
                            // when drop button 1 is clicked
                            if ((x >= 0.03 && x <= 0.13) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 0);
                                
                                // drops the chip in the first column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 0);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 2 is clicked
                            if ((x >= 0.17 && x <= 0.27) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 1);
                                
                                // drops the chip in the second column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 1);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 3 is clicked
                            if ((x >= 0.31 && x <= 0.41) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 2);
                                
                                // drops the chip in the third column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 2);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                       theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 4 is clicked
                            if ((x >= 0.45 && x <= 0.55) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 3);
                                
                                // drops the chip in the fourth column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 3);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 5 is clicked
                            if ((x >= 0.59 && x <= 0.69) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 4);
                                
                                // drops the chip in the fifth column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 4);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 6 is clicked
                            if ((x >= 0.73 && x <= 0.83) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 5);
                                
                                // drops the chip in the sixth column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 5);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 7 is clicked
                            if ((x >= 0.87 && x <= 0.97) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 6);
                                
                                // drops the chip in the seventh column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 6);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            mouseLastClicked = true;   
                        }  
                    }
                    else {
                        mouseLastClicked = false;
                    }
                    x = 0;
                    y = 0;
                }
                
                // player 2 turn
                if (!turn && connect4.isGameOver() == false) {
                    double x = 0.0;
                    double y = 0.0;
                    
                    // if the mouse is clicked
                    if (PennDraw.mousePressed()) {                
                        if (!mouseLastClicked) {
                            int number = connect4.getCount();
                            
                           // get the coordinates of the mouse cursor
                            x = PennDraw.mouseX();
                            y = PennDraw.mouseY();
                            
                            // when button 1 is clicked
                            if ((x >= 0.03 && x <= 0.13) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player2, 0);
                                
                                // drops the chip in the first column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player2, connect4.getRow(), 0);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player2Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 2 is clicked
                            if ((x >= 0.17 && x <= 0.27) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player2, 1);
                                
                                // drops the chip in the second column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player2, connect4.getRow(), 1);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player2Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                       theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 3 is clicked
                            if ((x >= 0.31 && x <= 0.41) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player2, 2);
                                
                                // drops the chip in the third column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player2, connect4.getRow(), 2);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player2Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 4 is clicked
                            if ((x >= 0.45 && x <= 0.55) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player2, 3);
                                
                                // drops the chip in the fourth column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player2, connect4.getRow(), 3);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player2Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 5 is clicked
                            if ((x >= 0.59 && x <= 0.69) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player2, 4);
                                
                                // drops the chip in the fifth column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player2, connect4.getRow(), 4);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                       player2Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 6 is clicked
                            if ((x >= 0.73 && x <= 0.83) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player2, 5);
                                
                                // drops the chip in the sixth column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player2, connect4.getRow(), 5);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player2Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 7 is clicked
                            if ((x >= 0.87 && x <= 0.97) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player2, 6);
                                
                                // drops the chip in the seventh column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player2, connect4.getRow(), 6);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player2Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            mouseLastClicked = true;
                        }   
                    }
                    else {
                        mouseLastClicked = false;
                    }
                    x = 0;
                    y = 0;
                }
            }
        }
        
        // one player mode
        if (!twoPlayerMode) {
            while (connect4.isGameOver() == false) {
                
                // player 1 turn
                if (turn && connect4.isGameOver() == false) {
                    double x = 0.0;
                    double y = 0.0;
                    
                    // if the mouse is clicked
                    if (PennDraw.mousePressed()) {                
                        if (!mouseLastClicked) {
                            int number = connect4.getCount();
                            
                            // get the coordinates of the mouse cursor
                            x = PennDraw.mouseX();
                            y = PennDraw.mouseY();
                            
                            // when button 1 is clicked
                            if ((x >= 0.03 && x <= 0.13) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 0);
                                
                                // drops the chip in the first column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 0);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 2 is clicked
                            if ((x >= 0.17 && x <= 0.27) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 1);
                                
                                // drops the chip in the second column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 1);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 3 is clicked
                            if ((x >= 0.31 && x <= 0.41) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 2);
                                
                                // drops the chip in the third column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 2);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 4 is clicked
                            if ((x >= 0.45 && x <= 0.55) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 3);
                                
                                // drops the chip in the fourth column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 3);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                       theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 5 is clicked
                            if ((x >= 0.59 && x <= 0.69) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 4);
                                
                                // drops the chip in the fifth column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 4);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 6 is clicked
                            if ((x >= 0.73 && x <= 0.83) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 5);
                                
                                // drops the chip in the sixth column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 5);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            
                            // when button 7 is clicked
                            if ((x >= 0.87 && x <= 0.97) && 
                                (y >= 0.925 && y <= 0.975)) {
                                connect4.addMove(player1, 6);
                                
                                // drops the chip in the seventh column
                                if (number + 1 == connect4.getCount()) {
                                    drawChip(player1, connect4.getRow(), 6);
                                    
                                    // switches turns
                                    turn = !turn;
                                    
                                    // checks for win or draw
                                    if (connect4.checkForWin() == true) {
                                        player1Wins();
                                        startOver();
                                    }
                                    else if (connect4.checkForDraw() == true) {
                                        theresADraw();
                                        startOver();
                                    }
                                }
                            }
                            mouseLastClicked = true;
                        } 
                    }
                    else {
                        mouseLastClicked = false;
                    }
                    x = 0;
                    y = 0;  
                }
                
                // to generate random column
                int randomColumn = (int) (Math.random() * 7);
                
                // AI's turn
                if (!turn && connect4.isGameOver() == false) {
                    int number = connect4.getCount();
                    connect4.addMove(player2, randomColumn);
                    
                    // drops the chip in a random column
                    if (number + 1 == connect4.getCount()) {
                        drawChip(player2, connect4.getRow(), randomColumn);
                        
                        // switches turns
                        turn = !turn;
                        
                        // checks for win or draw
                        if (connect4.checkForWin() == true) {
                            player2Wins();
                            startOver();
                        }
                        else if (connect4.checkForDraw() == true) {
                            theresADraw();
                            startOver();
                        }
                    }
                }
            }
        }
    }
    
    /*
     * Description: helper function to create the draw message box
     * 
     * Input: does not take in any parameters
     * Output: does not return anything but produces penndraw diagram
     *         as a side effect
     */
    private void theresADraw() {
        PennDraw.setPenColor(PennDraw.BOOK_BLUE);
        PennDraw.setPenRadius(0.01);
        PennDraw.rectangle(0.5, 0.5, 0.1, 0.05);
        PennDraw.text(0.5, 0.5, "Draw!");
    }
    
    /*
     * Description: helper function to create the player 2 wins
     *              message box
     * 
     * Input: does not take in any parameters
     * Output: does not return anything but produces penndraw diagram
     *         as a side effect
     */
    private void player2Wins() {
        PennDraw.setPenColor(PennDraw.YELLOW);
        PennDraw.setPenRadius(0.01);
        PennDraw.rectangle(0.5, 0.5, 0.1, 0.05);
        PennDraw.text(0.5, 0.5, "Player 2 Wins!");
    }
    
    /*
     * Description: helper function to create the player 1 wins
     *              message box
     * 
     * Input: does not take in any parameters
     * Output: does not return anything but produces penndraw diagram
     *         as a side effect
     */
    private void player1Wins() {
        PennDraw.setPenColor(PennDraw.RED);
        PennDraw.setPenRadius(0.01);
        PennDraw.rectangle(0.5, 0.5, 0.1, 0.05);
        PennDraw.text(0.5, 0.5, "Player 1 Wins!");
    }
    
    /*
     * Description: helper function to create the start over button
     * 
     * Input: does not take in any parameters
     * Output: does not return anything but produces penndraw diagram
     *         as a side effect
     */
    private void startOver() {
        boolean startOverChosen = false;
        
        // draws the button
        PennDraw.setPenColor(PennDraw.BOOK_LIGHT_BLUE);
        PennDraw.filledRectangle(0.5, 0.35, 0.1, 0.05);
        PennDraw.setPenColor(PennDraw.WHITE);
        PennDraw.text(0.5, 0.35, "Start Over");
        PennDraw.rectangle(0.5, 0.35, 0.09, 0.04);
        
        while (startOverChosen == false) {
            double x = 0.0;
            double y = 0.0;
            
            // if the mouse is clicked
            if (PennDraw.mousePressed()) {                
                
                // get the coordinates of the mouse cursor
                x = PennDraw.mouseX();
                y = PennDraw.mouseY();
                
                // when start over button is clicked
                if ((x >= 0.4 && x <= 0.6) && (y >= 0.3 && y <= 0.4)) {
                    
                    // clears the canvas
                    PennDraw.clear();
                    startOverChosen = true;
                }
            }
        }
    }
    
    /*
     * Description: draws the chip
     * 
     * Input: takes in a chip object and integer variables
     * Output: does not return anything but generates penndraw diagram
     *         as a side effect
     */
    public static void drawChip(Chip chip, int row, int col) {
        Chip player1 = new Chip(1);
        Chip player2 = new Chip(2);
        
        // gets the coordinates for the chip images when a move is made
        double xPos = col * 0.14 + 0.083;
        double yPos = (5 - row) * 0.135 + .3;
        
        // draws the chips
        // assigns player 1 to the red chip
        if (chip.getPlayer() == player1.getPlayer()) {
            PennDraw.picture(xPos, yPos, "redchip.png");
        }
        
        // assigns player 2 to the yellow chip
        else if (chip.getPlayer() == player2.getPlayer()) {
            PennDraw.picture(xPos, yPos, "yellowchip.png");
        }
    }                     
    
    public static void main(String[] args) {
        while (true) {
            Connect4 test = new Connect4();
        }
    }
}
