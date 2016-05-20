package abalone;


// TODO to avoid having this class removed, consider thinking about AbaloneGame.play() main algorithm

/**
 * @author stitii
 * Class Player (defined by its number of balls, color of his balls and his statue on the game
 */

public class Player
{
	/**
	 * 
	 */
	public static int BLACK_COLOR = 1;
	
	/**
	 * 
	 */
	public static int WHITE_COLOR = 0;
	
	/**
	 * 
	 */
	public static int NULL_COLOR = -1;
	
	/**
	 * 
	 */
	public static int DEAD_COLOR = -2;
	
	/**
	 * default number of player's balls
	 */
	private static int DEFAULT_BALLS = 14;
	
	/**
	 * A player has all his balls by default
	 */
	private static boolean DEFAULT_NOMOREBALLS = false;
	
	/**
	 * number of player's balls 
	 */
	private int nbBalls;
	
	/**
	 *  boolean which says if the player has no more balls
	 */
	private boolean nomoreBalls;
	
	/**
	 * the color of balls of the player (1 black / 0 white)
	 */
	private int colorBalls;
	
	/**
	 * Create a player 
	 * @param color of the player
	 */
	public Player(int color)
	{
		this.nbBalls = DEFAULT_BALLS;
		this.nomoreBalls = DEFAULT_NOMOREBALLS;
		this.colorBalls = color;
	}
	
	/**
	 * @return A boolean which says if the player has no more balls
	 */
	public boolean getNomoreBalls()
	{
		return this.nomoreBalls;
	}
	
	
	/**
	 * @return player's number of balls
	 */
	public int getnbBalls()
	{
		return this.nbBalls;
	}
	
	/**
	 * @return player's color of balls
	 */
	public int getColorBalls()
	{
		return this.colorBalls;
	}

	/**
	 * Player's turn
	 * Not finished yet
	 */
	public void turn()
	{
		System.out.println("Choisissez le déplacement à effectuer");
		if (this.colorBalls==0){Movement mov = new Movement(0,1);}
		else {if (this.colorBalls==0){Movement mov = new Movement(1,0);}}
	}
}
