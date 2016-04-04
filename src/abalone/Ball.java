package abalone;

import abalone.Ball;
import abalone.BallException;
import abalone.Position;

/**
 * 
 * @author stitii
 * A ball is defined by its position (x and y), his color and its state (eliminated or not) 
 * Balls will be positionned on an orthonormal mark (the axe 0y will be rotated)
 */
public class Ball
	{
	/**
	 * Ball's position	
	 */
	Position position;
	
	/**
	 * Ball's color
	 */
	private int color;

	/**
	 * Ball's sate
	 */
	private boolean isEliminated;

	/**
	 * Create a Ball
	 * @param line Ball's line position
	 * @param column Ball's colum position 
	 * @param color Ball's color (1 = Black, 0 = White , -1 = NULL)
	 */
	public Ball(int line,int column, int color)
	{
		this.position = new Position(line,column);
		this.color=color;
		this.isEliminated=false;
	}
	
	// TODO getColor should return a color, not a string
	// advice: make an enumeration for colors which overrides toString
	/**
	 * Get ball's color 
	 * @return ball's color
	 */
	public String getColor()
	{
		if (this.color==0) return "W";
		else if (this.color==1) return "B";
		return "X";
	}
	
	/**
	 * Set ball to a new position
	 * @param board
	 * @param p0 ball's initial position
	 * @param line 
	 * @param column 
	 */
	public void setNewPos(Ball[][] board,Position p0,int line,int column)
	{
		try
		{
			this.position.setPos(board,line,column);
			board[line][column].color=board[p0.getLine()][p0.getColumn()].color;
			board[p0.getLine()][p0.getColumn()].color=-1;
			System.out.println("NewPos");
		}
		catch (BallException e)
		{
			System.out.println("Can't set to this position");
		}
	}
	
	/**
	 * Get ball's feature 
	 * @return Ball's feature
	 */
	public String toString()
	{
		return "Ball [ligne=" + this.position.getLine() + ", column=" + this.position.getColumn() +", color=" + 
					 this.getColor() + ", isEliminated=" + this.isEliminated + "]";
	}
}
