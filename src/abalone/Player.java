package abalone;


// TODO to avoid having this class removed, consider thinking about AbaloneGame.play() main algorithm

/**
 * @author stitii
 * Class Player (defined by its number of balls, color of his balls and his statue on the game
 */

public class Player
{
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
	
	
	/**
	 * @return player's number of balls
	 */
	public int getBalls()
	{
		return this.balls;
	}
	
	/**
	 * @return player's color of balls
	 */
	public String getColorBalls()
	{
		return this.colorBalls;
	}

	// TODO turn();
	
	/**
	 * Player's turn
	 * Not finished yet
	 */
	public void turn()
	{
		
	}
}
