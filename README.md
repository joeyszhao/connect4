# connect4
remake of the popular 2 player game connect 4 | cis 110 final project

/*********************************************************************                
 *  Project
 **********************************************************************/

Name: Joey Zhao
PennKey: joeyzhao
Recitation: 202
Project choice: Connect 4

/**********************************************************************
 *  Have you entered all help, collaboration, and outside resources
 *  in your help log?  If not, do so now.  (And in future, make sure
 *  you make your help log entries as you go, not at the end!)
 *
 *  If you did not get any help outside of TA office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/

    I used images from google to visually represent the board of the game 
    and the yellow and red chips that represent a player.
    
    Besides the images, I did not receive any help outside of TA office hours,
    did not collaborate with anyone, and I did not use any resources beyond
    the standard course materials.

/**********************************************************************
 *  How do you execute your program? Which class do you run, are there
 *  any command line arguments?
 **********************************************************************/

     To execute the game, run the Connect4.java file. There are no command line
     arguments. The game can be executed through the main function by creating an
     instance of the connect 4 object.

/**********************************************************************
 *  Did you add any additional features to your project beyond the
 *  specification that you added? If so, describe them here.
 **********************************************************************/

    Rather than clicking anywhere on a specific column to add a move,
    I created seven buttons to represent the 7 columns. To add a move, 
    the player just needs to click on the button that represents that 
    specific column. In addition, not sure if this counts as a feature, 
    more of a decoration I suppose, I added the name of the game on the
    starting menu and the game page.

/**********************************************************************
 *  List all the files in project.zip and explain their purpose.
 **********************************************************************/

     Board.java - creates an object to represent the board
     BoardTest.java - used to test the functions in Board.java
     Chip.java - creates an object to represent the chips
     Connect4.java - uses the board and chip objects to implement the 
                     game of connect 4
     
     Connect4Board.png - image of the board used in Connect4.java
     redchip.png - image of the red chip used in Connect4.java to represent
                   player 1
     yellowchip.png - image of the yellow chip used in Connect4.java to 
                      represent player 2
 
/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

     Getting the mouse click to work right was really difficult, but the
     video presented on piazza was helpful. 

/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/

     From this project, I really learned the purpose of helper functions.
     At first, I repeated the code to draw the "Player 1 Wins!" and 
     "Player 2 Wins", and "Draw!" messages under each button for each column
     and I was wondering why my code was so long. Then I realized that I could
     put all those lines of code into a help function and cut it down to one 
     line of code. I realized that I never really understood the usefulness 
     of helper functions in simplifying the code until now. 
 