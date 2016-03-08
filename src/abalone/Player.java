package abalone;

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
	 * Player's name
	 */
	private String name;
	
	/**
	 * Create a player 
	 * @param color of the player
	 * @param name of the player
	 */
	public Player(String color, String name)
	{
		this.balls = DEFAULT_BALLS;
		this.nomoreBalls = DEFAULT_NOMOREBALLS;
		this.colorBalls = color;
		this.name = name;
	}
	
	/**
	 * @return A boolean which says if the player has no more balls
	 */
	public boolean getNomoreBalls()
	{
		return this.nomoreBalls;
	}
	
	public String getName()
	{
		return this.name;
	}

	
}
