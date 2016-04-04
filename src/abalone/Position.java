package abalone;

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
	
	// TODO finish writing comment (parameters should be documented-
	/**
	 * create ball position
	 * @param line
	 * @param column
	 */
	public Position(int line, int column)
	{
		this.line=line;
		this.column=column;
	}

	// TODO finish writing comment (parameters should be documented-
	/**
	 * Set new position
	 * @param board 
	 * @param line 
	 * @param column 
	 */
	public void setNewPos(Ball[][] board,int line,int column) throws BallException
	{
		if (board[line][column].getColor()!="X") throw new BallException();
		this.line=line;
		this.column=column;
	}
	
}
