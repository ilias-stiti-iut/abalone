package abalone;

/**
 * the way of a movement (online/sideways and increase or decrease line and column (+1/-1)
 * @author stitii
 *
 */
public class Way
{
	/**
	 * The online direction is defined by 0
	 */
	public static final int ONLINE = 0;
	
	/**
	 * The sideways direction is defined by 1
	 */
	public static final int SIDEWAYS = 1;
	
	/**
	 * Line way 
	 */
	private int line;
	
	/**
	 * Column way
	 */
	private int column;
	
	/**
	 * the direction of the ball (0 for online, 1 for sideways)
	 */
	private int direction;
	
	/**
	 * create a way
	 * @param line Line way 
	 * @param column Column way
	 * @param direction the direction of the ball (0 for online, 1 for sideways)
	 */
	public Way(int line, int column,int direction)
	{
		this.line=line;
		this.column=column;
		this.direction=direction;
	}

	/** 
	 * Direction getter
	 * @return object's direction
	 * (0 for online, 1 for sideways)
	 */
	public int getDirection()
	{
		return this.direction;
	}
	
	/**
	 * Line getter
	 * @return object's line
	 */
	public int getLine()
	{
		return this.line;
	}
	
	/**
	 * Column getter
	 * @return object's column
	 */
	public int getColumn()
	{
		return this.column;
	}	
}
