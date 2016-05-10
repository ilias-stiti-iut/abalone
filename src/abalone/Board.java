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
	
	/**
	 * Try to make a movement, throw ImpossibleMovementException if the player must be in position to Sumitomo, 
	 * that is to say on the powerplay or if the number of balls that the player want to move is superior to 3
	 * @param mov the mov ^^
	 */
	public void doMovement (Movement mov) throws ImpossibleMovementException
	{
		if (mov.getWay().getDirection()==0)
			{
			//if here: then it means the movement is sideways
			//throw exception is there is already a ball where the player wants to move his balls
				for (int i=0; i < mov.getMyBalls().length; i++)
				{
					if (this.board[mov.getMyBalls()[i].getLine()+mov.getWay().getLine()][mov.getMyBalls()[i].getColumn()+mov.getWay().getColumn()]!=Player.NULL_COLOR
						&&mov.getMyBalls().length>3)					
					{
						throw new ImpossibleMovementException();
					}
				}
				//do the movement
				for (int i=0; i < mov.getMyBalls().length; i++)
				{
					this.board[mov.getMyBalls()[i].getLine()+mov.getWay().getLine()][mov.getMyBalls()[i].getColumn()+mov.getWay().getColumn()]=mov.getMyColor();
					this.board[mov.getMyBalls()[i].getLine()][mov.getMyBalls()[i].getColumn()]=Player.NULL_COLOR;
				}
			}
		else
			{
			// TODO fix the problem of overflow of the board
				//Determine enemy's ball number 
				Position positemp = mov.getMyBalls()[mov.getMyBalls().length];
				int numberofEnemyBall=0;
				while (this.board[positemp.getLine()+mov.getWay().getLine()][positemp.getColumn()+mov.getWay().getColumn()]!=mov.getHisColor())
				{
					numberofEnemyBall++;
					positemp.setLine(positemp.getLine()+mov.getWay().getLine());
					positemp.setColumn(positemp.getColumn()+mov.getWay().getColumn());
				}
				//check if the movement is possible 
				if (mov.getMyBalls().length<=numberofEnemyBall||mov.getMyBalls().length>Movement.DEFAULT_MAX_LENGTH)
				{
					throw new ImpossibleMovementException();
				}
			}
	}
}
