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
	private int[][] board;
	
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
		this.board[NB_LINE][NB_COLUMN] = 0;
			
		for (int i = 0; i < this.boardtemp.length; i++)
		{
			for (int j = 0; j < this.boardtemp[i].length; j++)
			{
				this.board[i][j] = this.boardtemp[i][j];
			}
		}
	}
	
	/**
	 * get the real color of the ball on (i,j) position
	 * @param i line position
	 * @param j column position
	 * @return the real color of the ball on (i,j) position
	 */
	private String getRealColor(int i, int j)
	{
		if (this.board[i][j]==-1) return "X";
		else if (this.board[i][j]==0) return "W";
		else return "B";
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
				display+=this.getRealColor(i,j) + " ";
			}
			display+="\n";
		}
		return display;
	}
}
