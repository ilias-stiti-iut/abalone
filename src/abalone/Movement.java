package abalone;

import java.util.ArrayList;

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
	 * table which stores the position of balls which the player want to move
	 */
	private final Position[] myBalls;
	
	/**
	 * the way of the balls
	 */
	private final Way way;
	
	
	/**
	 * Create a movement (but the movement in not done yet)
	 */
	public Movement()
	{
		this.myBalls=null;
		this.way=null;
	}
	
	/**
	 * Direction getter
	 * @return object's direction of its way
	 */
	public Way getWay()
	{
		return this.way;
	}
	
	public Position[] getMyBalls()
	{
		return this.myBalls;
	}
}
