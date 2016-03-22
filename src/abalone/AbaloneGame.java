package abalone;

/**
 * @formatter:off 
 * this class represents an Abalone game.
 * https://fr.wikipedia.org/wiki/Abalone_%28jeu%29
 *         
 *  
 *                 		                      		
 *               W W W W W       <- row 0
 *     		    W W W W W W 	 <- row 1
 *    		   X X W W W X X	 <- row 2
 *   		  X X X X X X X X    <- row 3
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
	 * Game board [row] [column]
	 */

	// TODO move the data structure in a dedicated type called Board
	private Ball[][] board;

	/**
	 * Model of the position of balls
	 * @formatter:off 
	 */
	private String[][] boardtemp = { { "W", "W", "W", "W", "W" }, 
								   { "W", "W", "W", "W", "W", "W" },
								 { "X", "X", "W", "W", "W", "X", "X" }, 
							   { "X", "X", "X", "X", "X", "X", "X", "X" },
						   { "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" }, 
						       { "X", "X", "X", "X", "X", "X", "X", "X" },
						       	 { "X", "X", "B", "B", "B", "X", "X" }, 
						       	   { "B", "B", "B", "B", "B", "B" }, 
						       	 	 { "B", "B", "B", "B", "B" } };

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

		for (int i = 0; i < boardtemp.length; i++)
		{
			for (int j = 0; j < boardtemp[i].length; i++)
			{
				if (boardtemp[i][j] != "X")
					this.board[i][j] = new Ball(i, j, boardtemp[i][j]);
			}
		}
	}

	// TODO detail algorithm (ask for advice)
	/**
	 * Plays the game (algorithm?)
	 * While the game isn't finished, play the game
	 * Each player play his turn (algorithm not finished
	 */
	public void play()
	{
		while (this.isGameFinished)
		{
			player1.turn();
			this.isGameFinished=player2.getNomoreBalls();
			player2.turn();
			this.isGameFinished=player1.getNomoreBalls();
		}
	}
}
