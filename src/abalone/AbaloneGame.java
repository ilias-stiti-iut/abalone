package abalone;

import abalone.*;


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
	 * Game's board
	 */
	private Board board;
	
	/**
	 * @formatter:on
	 * Creates a new Abalone game, ready to be played. The first player who
	 * Begin is the one with black balls All balls are positioned on a table which has an hexagonal shape 
	 * An Abalone game is not end by default
	 */
	public AbaloneGame()
	{
		this.isGameFinished = false;
		this.player1 = new Player(Player.BLACK_COLOR);
		this.player2 = new Player(Player.WHITE_COLOR);
		this.board = new Board();	
		
	}

	// TODO detail algorithm (ask for advice)
	/**
	 * Plays the game (algorithm?)
	 * While the game isn't finished, play the game
	 * Each player plays his turn 
	 * During his turn, he has to chose a move 
	 * After the move the algorithm will check if the other player can't play anymore
	 */
	public void play()
	{
		System.out.println(this.board.toString());
		while (this.isGameFinished)
		{
			this.player1.turn();
			this.isGameFinished=this.player2.getNomoreBalls();
			this.player2.turn();
			this.isGameFinished=this.player1.getNomoreBalls();
		}
	}
	
}
