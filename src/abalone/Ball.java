package abalone;

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
	 * @param line 
	 * @param column 
	 * @param color
	 */
	public Ball(int line,int column, int color)
	{
		this.position = new Position(line,column);
		this.color=color;
		this.isEliminated=false;
	}
	
	/**
	 * @return ball's color
	 */
	public String getColor()
	{
		if (this.color==0) return "W";
		else if (this.color==1) return "B";
		return "X";
	}
	
	

	//TODO setPos Methode here

	
	/**
	 * @return Stats of the ball
	 */
	public String toString()
	{
		return "Ball [ligne=" + this.position.toString() + ", color=" + 
					 this.color + ", isEliminated=" + this.isEliminated + "]";
	}
}
