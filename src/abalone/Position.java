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
	 * Set new position
	 * @param board 
	 * @param line Line position we need to move the ball on
	 * @param column Column position we need to move the ball on 
	 */
	public void setPos(Ball[][] board,int line,int column) throws BallException
	{
		if (board[line][column].getColor()!=Ball.NULL_COLOR||outOfRange(board,line,column)) throw new BallException();
		this.line=line;
		this.column=column;
	}
	
	/**
	 * setter line
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
	
	/**
	 * boolean which check if the position gets out of the table 
	 * @param board 
	 * @param line
	 * @param column
	 * @return false if the position doesn't get out of the table
	 */
	public boolean outOfRange(Ball[][] board,int line,int column)
	{
		return line > board.length || line < 0 || column > board[line].length|| column < 0 ;
	}
	
	
}
	

