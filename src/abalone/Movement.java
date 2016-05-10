package abalone;


/**
 * Player's movement possible
 * this class will enable to make movements (Ball.setNewPos and Position.setPos may be useless now)
 * A player can move 1,2 or 3 balls of a movement to neighboring squares the movement is online or sideways.
 * To push the balls of the opponent the player must be in position to Sumitomo, that is to say on the powerplay.
 * A line of 3 or more balls can never be pushed by the opponent.
 * @author stitii
 *
 */
public class Movement
{
	/**
	 * The maximum number of ball that a player can move
	 */
	public static final int DEFAULT_MAX_LENGTH = 3; 
	
	/**
	 * table which stores the position of balls which the player want to move
	 */
	private final Position[] myBalls;
	
	/**
	 * the way of the balls
	 */
	private final Way way;
	
	/**
	 * Player's color of balls  
	 */
	private final int myColor;
	
	/**
	 * Enemy's color of balls 
	 */
	private final int hisColor;
	/**
	 * Create a movement (but the movement in not done yet)
	 */
	public Movement(int myColor, int hisColor)
	{
		this.myBalls=null;
		this.way=null;
		this.myColor=myColor;
		this.hisColor=hisColor;
	}
	
	/**
	 * Direction getter
	 * @return object's direction of its way
	 */
	public Way getWay()
	{
		return this.way;
	}
	
	/**
	 * get the position of balls which the player want to move
	 * @return the position of balls which the player want to move
	 */
	public Position[] getMyBalls()
	{
		return this.myBalls;
	}
	
	/**
	 * get player's color of balls 
	 * @return player's color of balls
	 */
	public int getMyColor()
	{
		return this.myColor;
	}
	
	/**
	 * get enemy's color of balls 
	 * @return Enemy's color of balls 
	 */
	public int getHisColor()
	{
		return this.hisColor;
	}
}
