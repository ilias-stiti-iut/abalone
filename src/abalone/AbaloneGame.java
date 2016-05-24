package abalone;


/**
 * @formatter:off 
 * this class represents an Abalone game.
 * https://fr.wikipedia.org/wiki/Abalone_%28jeu%29
 *         
 *  
 *               N N N N N N  	   <- row 0                      		
 *              N W W W W W N      <- row 1
 *             N W W W W W W N	   <- row 2
 *            N X X W W W X X N	   <- row 3
 *           N X X X X X X X X N   <- row 4
 *          N X X X X X X X X X N  <- row 5
 * column 0/ N X X X X X X X X N   <- row 6
 *  column 1/ N X X B B B X X N    <- row 7
 *   column 2/ N B B B B B B N     <- row 8
 *    column 3/ N B B B B B N      <- row 9
 *             / N N N N N N       <- row 10
 *            / / / / / / /          
 *    column 4 / / / / / /       
 *     column 5 / / / / /
 *      column 6 / / / /
 *       column 7 / / /
          column 8 / /
 *         column 9 /
 *  	   column 10
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
	 * Creates a new Abalone game, ready to be played. The first player who begin is the one with black balls 
	 * All balls are positioned on a table which has an hexagonal shape 
	 * An Abalone game is not end by default 
	 */
	public AbaloneGame()
	{
		this.isGameFinished = false;
		this.player1 = new Player(Player.BLACK_COLOR,1);
		this.player2 = new Player(Player.WHITE_COLOR,2);
		this.board = new Board();	
	}

	// TODO detail algorithm (ask for advice)
	/**
	 * Plays the game 
	 * While the game isn't finished, play the game
	 * Each player plays his turn 
	 * During his turn, he has to chose a move 
	 * After the move the algorithm will check if the other player can't play anymore
	 */
	public void play()
	{
		System.out.println(this.board.toString());
		System.out.println(this.board.toRealString());
		while (!this.isGameFinished)
		{
			this.player1.turn(this.board,this);
			this.isGameFinished=this.player2.getNomoreBalls();
			System.out.println(this.board.toString());
			System.out.println(this.board.toRealString());
			this.player2.turn(this.board,this);
			this.isGameFinished=this.player1.getNomoreBalls();
		}
	}
	
	/**
	 * Remove 1 ball of a player
	 * @param number the player's number
	 */
	public void removeball(int number)
	{
		if (number==1) this.player1.setNbBalls(-1);
		else this.player2.setNbBalls(-1);
	}
	
}
