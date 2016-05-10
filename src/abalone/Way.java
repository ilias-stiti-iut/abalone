package abalone;

public class Way
{
	/**
	 * Line way 
	 */
	private final int line;
	
	/**
	 * Column way
	 */
	private final int column;
	
	/**
	 * the direction of the ball (0 for online, 1 for sideways)
	 */
	private final int direction;
	
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
	
	public int getLine()
	{
		return this.line;
	}
	
	public int getColumn()
	{
		return this.column;
	}
}
