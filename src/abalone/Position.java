package abalone;

import abalone.*;

/**
 * Position
 * @author stitii
 *
 */
public class Position
{
	/**
	 * Line position 
	 */
	private int line;
	
	/**
	 * Column position
	 */
	private int column;
	
	/**
	 * create ball position
	 * @param line Define ball's line position
	 * @param column Define ball's column position
	 */
	public Position(int line, int column)
	{
		this.line=line;
		this.column=column;
	}
	
	/**
	 * getter line
	 * @return this.line
	 */
	public int getLine()
	{
		return this.line;
	}
	
	/**
	 * getter column 
	 * @return this.column
	 */
	public int getColumn()
	{
		return this.column;
	}

}
	

