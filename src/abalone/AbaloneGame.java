package abalone;

import abalone.Ball;
import abalone.Player;


/**
 * @formatter:off 
 * this class represents an Abalone game.
 * https://fr.wikipedia.org/wiki/Abalone_%28jeu%29
 *         
 *  
 *                 		                      		
 *               W W W W W       <- row 0
 *              W W W W W W 	 <- row 1
 *             X X W W W X X	 <- row 2
 *            X X X X X X X X    <- row 3
 *           X X X X X X X X X   <- row 4
 *  column 0/ X X X X X X X X    <- row 5
 *   column 1/ X X B B B X X     <- row 6
 *    column 2/ B B B B B B      <- row 7
 *     column 3/ B B B B B       <- row 8
 *              / / / / /           
 *      column 4 / / / /        
 *       column 5 / / /
 *        column 6 / /
 *         column 7 /
 *          column 8
 *          
 *  
 *  
 * @author stitii
 *
 */

public class AbaloneGame{

	/** 
	 *  @formatter:on
	 * Game status (running/finished)
	 */
	private boolean isGameFinished;

	/**
	 * Player 1
	 */

	private Player player1;

	/**
	 * Player 2
	 */

	private Player player2;

	/**
	 * Game board [ligne] [column]
	 */

	// TODO move the data structure in a dedicated type called Board
	private Ball[][] board;

	// TODO use constants or an enumeration instead of hard-coded values
	/**
	 * Model of the position of balls
	 * @formatter:off 
	 */
	private int[][] boardtemp =   {{0,0,0,0,0}, 
								  {0,0,0,0,0,0},
							    {-1,-1,0,0,0,-1,-1}, 
							 {-1,-1,-1,-1,-1,-1,-1,-1},
						   {-1,-1,-1,-1,-1,-1,-1,-1,-1}, 
						      {-1,-1,-1,-1,-1,-1,-1,-1},
						        {-1,-1,1,1,1,-1,-1}, 
						       	   {1,1,1,1,1,1}, 
						       	    {1,1,1,1,1}};
	
	/**
	 * Used for displayBoard()
	 */
	private String[] spaceBoard = {"               ","              ","             ","            ","           ",
							       "            ","             ","              ","               "};
	
	/**
	 * @formatter:on
	 * Creates a new Abalone game, ready to be played. The first player who
	 * Begin is the one with black balls All balls are positioned on a table which has an hexagonal shape 
	 * An Abalone game is not end by default
	 */
	public AbaloneGame()
	{
		this.isGameFinished = false;
		this.player1 = new Player("B");
		this.player2 = new Player("W");
		this.board = new Ball[9][9];
		for (int i = 0; i < this.boardtemp.length; i++)
		{
			for (int j = 0; j < this.boardtemp[i].length; j++)
			{
				this.board[i][j] = new Ball(i, j, this.boardtemp[i][j]);
			}
		}
	}

	// TODO detail algorithm (ask for advice)
	/**
	 * Plays the game (algorithm?)
	 * While the game isn't finished, play the game
	 * Each player play his turn (algorithm not finished)
	 */
	public void play()
	{
		System.out.println(this.toString());
		this.board[0][1].setNewPos(this.board,this.board[1][0].position,2,0);
		System.out.println(this.toString());
		/*while (this.isGameFinished)
		{
			this.player1.turn();
			this.isGameFinished=this.player2.getNomoreBalls();
			this.player2.turn();
			this.isGameFinished=this.player1.getNomoreBalls();
		}*/
	}
	
	/**
	 * Get ball's feature 
	 * @param pos The position of the ball we need to view
	 * @return Ball's features
	 */
	public String getBall(Position pos)
	{
		return this.board[pos.getLine()][pos.getColumn()].toString();
	}
	
	/**
	 * Display board's current statue
	 */
	public String toString()
	{
		String display = "";
		for (int i = 0; i < this.boardtemp.length; i++)
		{
			display+=this.spaceBoard[i];
			for (int j = 0; j < this.boardtemp[i].length; j++)
			{
				display+=this.board[i][j].getColor() + " ";
			}
			display+="\n";
		}
		return display;
	}
}
