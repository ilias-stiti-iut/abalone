package abalone;

// TODO to avoid having this class removed, consider thinking about AbaloneGame.play() main algorithm
public class Player
{
	/**
	 * default number of player's balls
	 */
	private static int DEFAULT_BALLS = 14;
	
	/**
	 * default player's name
	 */
	private static String DEFAULT_NAME = "None";
	
	/**
	 * A player has all his balls by default
	 */
	private static boolean DEFAULT_NOMOREBALLS = false;
	
	/**
	 * number of player's balls 
	 */
	private int balls;
	
	/**
	 *  boolean which says if the player has no more balls
	 */
	private boolean nomoreBalls;
	
	/**
	 * the color of balls of the player (black or white)
	 */
	private String colorBalls;
	
	/**
	 * Create a player 
	 * @param color of the player
	 */
	public Player(String color)
	{
		this.balls = DEFAULT_BALLS;
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

	// TODO turn()
	/**
	 * Player's turn
	 * Not finished yet
	 */
	public void turn()
	{
		
	}
}
