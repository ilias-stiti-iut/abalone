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
	private static int NB_LINE=11;
	
	/**
	 * Default board's number of column 
	 */
	private static int NB_COLUMN=11;
	
	/**
	 * Game board [line] [column]
	 */
	private int[][] board;
	
	/**
	 * Model of the position of balls at the beginning of the game
	 * @formatter:off 
	 */
	private int[][] boardtemp =  { {-2,-2,-2,-2,-2,-2},
								   {-2,2,2,2,2,2,-2}, 
								  {-2,2,2,2,2,2,2,-2},
							    {-2,-1,-1,2,2,2,-1,-1,-2}, 
							 {-2,-1,-1,-1,-1,-1,-1,-1,-1,-2},
						    {-2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-2}, 
						      {-2,-1,-1,-1,-1,-1,-1,-1,-1,-2},
						        {-2,-1,-1,1,1,1,-1,-1,-2}, 
						       	   {-2,1,1,1,1,1,1,-2}, 
						       	    {-2,1,1,1,1,1,-2},
						       	   {-2,-2,-2,-2,-2,-2}};
	
	/**
	 * Used for displayBoard() to respect the table's shape
	 */
	private String[] spaceBoard = {"               ","              ","             ","            ","           ","          ",
							       "           ","            ","             ","              ","               "};
	
	/**
	 * Board's constructor 
	 * Initialize the board
	 */
	public Board()
	{
		this.board = new int[NB_LINE][NB_COLUMN];
			
		for (int i = 0; i < this.boardtemp.length; i++)
		{
			for (int j = 0; j < this.boardtemp[i].length; j++)
			{
				this.board[i][j] = this.boardtemp[i][j];
			}
		}
	}
	
	/**
	 * Get the real color of the ball on (i,j) position
	 * @param i line position
	 * @param j column position
	 * @return the real color of the ball on (i,j) position
	 */
	private String getRealColor(int i, int j)
	{
		if (this.board[i][j]==Player.NULL_COLOR) return "X";
		else if (this.board[i][j]==Player.WHITE_COLOR) return "W";
		else if (this.board[i][j]==Player.DEAD_COLOR) return "N";
		else return "B";
	}
	
	/**
	 * Color getter (int)
	 * @param i line 
	 * @param j column
	 * @return The color (int)
	 */
	public int getColor(int i, int j)
	{
		return this.board[i][j];
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
	 * Display the board to help the player while choosing the position of balls to move
	 * @return How looks the table in String type
	 */
	public String toRealString()
	{
		String display = "";
		for (int i = 0; i < this.boardtemp.length; i++)
		{
			for (int j = 0; j < this.boardtemp[i].length; j++)
			{
				display+=this.getColor(i,j) + " ";
			}
			display+="\n";
		}
		return display;
	}
	
	/**
	 * Try to make a movement, throw ImpossibleMovementException if the player can't make the movement, 
	 * At first the method will check if the movement is online or sideways
	 * Then checks if the movement is possible 
	 * And do the movement if it is possible
	 * @param mov the movement to do
	 * @throws ImpossibleMovementException if the number of balls that the player want to move is superior to 3
	 */
	public void doMovement (Movement mov) throws ImpossibleMovementException
	{
		if (mov.getWay().getDirection()==Way.SIDEWAYS)
			{
			//if here: then it means the movement is sideways
			//for instruction: throw exception if there is already a ball where the player wants to move his balls
				for (int i=0; i < mov.getRealLength(mov.getMyBalls()); i++)
				{
					if (this.board[mov.getMyBalls()[i].getLine()+mov.getWay().getLine()][mov.getMyBalls()[i].getColumn()+mov.getWay().getColumn()]!=Player.NULL_COLOR
						&&mov.getMyBalls().length>3)					
					{
						throw new ImpossibleMovementException();
					}
				}
				//do the movement
				for (int i=0; i < mov.getRealLength(mov.getMyBalls()); i++)
				{
					this.board[mov.getMyBalls()[i].getLine()+mov.getWay().getLine()][mov.getMyBalls()[i].getColumn()+mov.getWay().getColumn()]=mov.getMyColor();
					this.board[mov.getMyBalls()[i].getLine()][mov.getMyBalls()[i].getColumn()]=Player.NULL_COLOR;
				}
			}
		else
			{
				//Determine enemy's ball number with a Position 
				Position positemp = mov.getMyBalls()[mov.getMyBalls().length];
				int numberofEnemyBall=0;
				while (this.board[positemp.getLine()+mov.getWay().getLine()][positemp.getColumn()+mov.getWay().getColumn()]==mov.getHisColor())
				{
					numberofEnemyBall++;
					positemp.setLine(positemp.getLine()+mov.getWay().getLine());
					positemp.setColumn(positemp.getColumn()+mov.getWay().getColumn());
					// throw exception if there is an ally ball right after the enemy ball
					if (this.board[positemp.getLine()+mov.getWay().getLine()][positemp.getColumn()+mov.getWay().getColumn()]==mov.getMyColor())
					{
						throw new ImpossibleMovementException();
					}
				}
				//check if the movement is possible (if the player isn't in sumitomo)
				if (mov.getMyBalls().length<=numberofEnemyBall||mov.getMyBalls().length>Movement.DEFAULT_MAX_LENGTH)
				{
					throw new ImpossibleMovementException();
				}
				//for i = the number of all the balls that will be moved to 0
				for (int i=mov.getRealLength(mov.getMyBalls())+numberofEnemyBall;i>0;i--)
				{
					//if the ball will get out of the board
					if (this.board[positemp.getLine()+mov.getWay().getLine()][positemp.getColumn()+mov.getWay().getColumn()]==Player.DEAD_COLOR)
					{
						this.board[positemp.getLine()][positemp.getColumn()]=Player.NULL_COLOR;
					}
					//set to the next position the color of the current position and set null_color to the current position 
					else
					{
						this.board[positemp.getLine()+mov.getWay().getLine()][positemp.getColumn()+mov.getWay().getColumn()]=this.board[positemp.getLine()][positemp.getColumn()];
						this.board[positemp.getLine()][positemp.getColumn()]=Player.NULL_COLOR;
						positemp.setLine(positemp.getLine()-mov.getWay().getLine());
						positemp.setColumn(positemp.getColumn()-mov.getWay().getColumn());
					}
					
				}
			}
	}
}
