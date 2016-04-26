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
	 * table which stores the position of balls to move
	 */
	private final Position[] balls;
	
	/**
	 * the way of the balls
	 */
	private final Way way;
	
	/**
	 * Create a movement (but the movement in not done yet)
	 * @param way the way of the movement (exemple way: +1;+1)
	 * @param balls table which stores the position of balls to move
	 */
	public Movement(Position[] balls,Way way)
	{
		this.balls=balls;
		this.way=way;
	}
	
	/**
	 * 
	 * @param board the board where we make the movement
	 * @throws ImpossibleMovementException 
	 * throw exception if the number of ball > 3 or if the player isn't in position to Sumitomo 
	 */
	public void doMovement(Board board) throws ImpossibleMovementException
	{
		if (this.balls.length>3) throw new ImpossibleMovementException();
	}
}
