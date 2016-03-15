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
	 * Ball's ligne position
	 */
	private int ligne;
	
	/**
	 * Ball's column position
	 */
	private int column;
	
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
	public Ball(int ligne,int column, String color)
	{
		this.ligne=ligne;
		this.column=column;
		this.color=color;
		this.isEliminated=false;
	}
}
