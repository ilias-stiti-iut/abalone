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
	 * Ball's x position
	 */
	private int x;
	
	/**
	 * Ball's y position
	 */
	private int y;
	
	/**
	 * Ball's color
	 */
	private String color;
	
	/**
	 * Ball's sate
	 */
	private boolean isEliminated;
	
	/**
	 * Create a Ball
	 * @param x
	 * @param y
	 * @param color
	 */
	public Ball(int x,int y, String color)
	{
		this.x=x;
		this.y=y;
		this.color=color;
		this.isEliminated=false;
	}
}
