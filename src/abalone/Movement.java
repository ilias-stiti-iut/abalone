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
	private Way way;
	
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
	 * @param myColor The ally'color of ball
	 */
	public Movement(int myColor)
	{
		this.myBalls= new Position[Player.DEFAULT_BALLS];
		this.way=null;
		if (myColor==Player.BLACK_COLOR)
		{
			this.myColor=Player.BLACK_COLOR;
			this.hisColor=Player.WHITE_COLOR;
		}
		else
		{
			this.hisColor=Player.BLACK_COLOR;
			this.myColor=Player.WHITE_COLOR;
		}
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
	 * get a table of position of balls which the player want to move
	 * @return a table of of balls which the player want to move
	 */
	public Position[] getMyBalls()
	{
		return this.myBalls;
	}
	
	/**
	 * Get the real length of Movement.myBalls
	 * @param position
	 * @return the real length of Movement.myBalls	 
	 */
	public int getRealLength(Position[] position)
	{
		int i=0;
		while (position[i].getLine()!=0)
			i++;
		return i;
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
	
	/**
	 * Add a position to Movement.myBalls
	 * @param line the line to add
	 * @param column the column to add
	 * @param i index of the table
	 */
	public void setPosition(int line, int column,int i)
	{
		this.myBalls[i]= new Position(line,column);
		this.myBalls[i+1]= new Position(0,0);
	}
	
	/**
	 * Way setter
	 * @param line the line to set
	 * @param column the column to set
	 * @param direction the direction to set
	 */
	public void setWay(int line, int column,int direction)
	{
		this.way=new Way(line,column,direction);
	}
}
