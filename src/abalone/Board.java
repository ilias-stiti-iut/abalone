package abalone;

/**
 * Game board
 * @author stitii
 *
 */
public class Board
{
	/**
	 * Default board's number of line 
	 */
	private static int NB_LINE=9;
	
	/**
	 * Default board's number of column 
	 */
	private static int NB_COLUMN=9;
	
	/**
	 * Game board [line] [column]
	 */
	private Ball[][] board;
	
	/**
	 * Model of the position of balls
	 * @formatter:off 
	 */
	private int[][] boardtemp =   {{0,0,0,0,0}, 
								  {0,0,0,0,0,0},
							    {-1,-1,0,0,0,-1,-1}, 
							 {-1,-1,-1,-1,-1,-1,-1,-1},
						   {-1,-1,-1,-1,-1,-1,-1,-1,-1}, 
						      {-1,-1,-1,-1,-1,-1,-1,-1},
						        {-1,-1,1,1,1,-1,-1}, 
						       	   {1,1,1,1,1,1}, 
						       	    {1,1,1,1,1}};
	
	/**
	 * Used for displayBoard()
	 */
	private String[] spaceBoard = {"               ","              ","             ","            ","           ",
							       "            ","             ","              ","               "};
	
	/**
	 * Board's constructor 
	 * Initialize the board
	 */
	public Board()
	{
		this.board = new Ball[NB_LINE][NB_COLUMN];
			
		for (int i = 0; i < this.boardtemp.length; i++)
		{
			for (int j = 0; j < this.boardtemp[i].length; j++)
			{
				this.board[i][j] = new Ball(i, j, this.boardtemp[i][j]);
			}
		}
	}
	
	/**
	 * Get ball's feature 
	 * @param pos Ball's position
	 * @return The ball in the position asked
	 */
	public Ball getBall(Position pos)
	{
		return this.board[pos.getLine()][pos.getColumn()];
	}
	
	/**
	 * Display board's current statue
	 */
	
	public String toString()
	{
		String display = "";
		for (int i = 0; i < this.boardtemp.length; i++)
		{
			display+=this.spaceBoard[i];
			for (int j = 0; j < this.boardtemp[i].length; j++)
			{
				display+=this.board[i][j].getRealColor() + " ";
			}
			display+="\n";
		}
		return display;
	}
}
