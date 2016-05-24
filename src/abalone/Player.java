package abalone;

import java.util.Scanner;


// TODO to avoid having this class removed, consider thinking about AbaloneGame.play() main algorithm

/**
 * @author stitii
 * Class Player (defined by its number of balls, color of his balls and his statue on the game
 */

public class Player
{
	/**
	 * 
	 */
	public static int BLACK_COLOR = 1;
	
	/**
	 * 
	 */
	public static int WHITE_COLOR = 2;
	
	/**
	 * 
	 */
	public static int NULL_COLOR = -1;
	
	/**
	 * 
	 */
	public static int DEAD_COLOR = -2;
	
	/**
	 * default number of player's balls
	 */
	public static int DEFAULT_BALLS = 14;
	
	/**
	 * A player has all his balls by default
	 */
	private static boolean DEFAULT_NOMOREBALLS = false;
	
	/**
	 * number of player's balls 
	 */
	private int nbBalls;
	
	/**
	 *  boolean which says if the player has no more balls
	 */
	private boolean nomoreBalls;
	
	/**
	 * Player's number
	 */
	private int number;
	
	/**
	 * the color of balls of the player (1 black / 0 white)
	 */
	private int colorBalls;
	
	/**
	 * 
	 */
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Create a player 
	 * @param color of the player
	 * @param number 
	 */
	public Player(int color, int number)
	{
		this.number=number;
		this.nbBalls = DEFAULT_BALLS;
		this.nomoreBalls = DEFAULT_NOMOREBALLS;
		this.colorBalls = color;
	}
	
	/**
	 * @return A boolean which says if the player has no more balls
	 */
	public boolean getNomoreBalls()
	{
		return this.nomoreBalls;
	}
	
	
	/**
	 * @return player's number of balls
	 */
	public int getnbBalls()
	{
		return this.nbBalls;
	}
	
	/**
	 * @return player's color of balls
	 */
	public int getColorBalls()
	{
		return this.colorBalls;
	}
	
	/**
	 * Edit the player's number of ball
	 * @param x the integer which will edit the player's number of ball
	 */
	public void setNbBalls(int x)
	{
		this.nbBalls+=x;
		if (this.nbBalls<=0) this.nomoreBalls=true;
	}

	/**
	 * Player's turn
	 * Ask the player to make a choice
	 * Then try to make the movement
	 * @param board The board where the player is playing
	 * @param game The game where the player is playing
	 */
	public void turn(Board board, AbaloneGame game)
	{
		System.out.println("Joueur "+this.number+", choisissez le deplacement a effectuer");
		Movement mov = new Movement(this.colorBalls);
		while (choice(board, mov));
		try
		{
			board.doMovement(mov);
		}
		catch (ImpossibleMovementException e)
		{
			System.out.println("Deplacement impossible (erreur de superiorite ou nombre de ball a deplacer trop grand\nVeillez recommencer");
			turn(board, game);
		}
	}
	
	/**
	 * Player's choice 
	 * @param board
	 * @param mov
	 * @return True if the balls are goodly chosen
	 */
	public boolean choice(Board board,Movement mov)
	{
		//notendchoice = false if the player finished to make his choice
		boolean notendchoice=true;
		int i=1;
		//Selection of the position of balls
		while (notendchoice)
		{
			System.out.println("Position en ligne de la balle n°"+i);
			int line = this.sc.nextInt();
			System.out.println("Position en colonne de la balle n°"+i);
			int column = this.sc.nextInt();
			System.out.println(mov.getMyColor());
			if (checkLineColumn(board,line,column)&&board.getColor(line,column)==mov.getMyColor())
			{
				mov.setPosition(line,column,i-1);
				i++;
				System.out.println("Avez vous fini votre choix de balle a deplacer?\n 0 = oui ");
				int choix = this.sc.nextInt();
				notendchoice=(choix!=0);
			}
			else 
			{
				if (checkLineColumn(board,line,column)&&board.getColor(line,column)==mov.getHisColor())
					System.out.println("Cette balle n'est pas la votre");
				else 
					System.out.println("Il n'y a aucune balle a cette position ("+line+";"+column+")");
			}		
		}
		notendchoice=true;
		boolean goodchoice=true;
		//Selection of the way of the movement
		while (notendchoice)
		{		
			System.out.println("Saisir 1 pour descendre la(les) balle(s) d'une ligne, -1 pour monter la(les) balle(s) d'une ligne");
			int line = this.sc.nextInt();
			if(line!=1&&line!=-1)
				goodchoice=false;
			System.out.println("Saisir 1 pour descendre la(les) balle(s) d'une colonne, -1 pour monter la(les) balle(s) d'une colonne");
			int column = this.sc.nextInt();
			if(column!=1&&column!=-1)
				goodchoice=false;
			System.out.println("Saisir 0 pour faire un deplacement lineaire, 1 pour faire un deplacement latteral");
			int direction = this.sc.nextInt();
			if(direction!=0&&direction!=1)
				goodchoice=false;
			if (!goodchoice)
				System.out.println("Vous avez mal saisie les donnee, veillez les resaisir");
			mov.setWay(line, column, direction);
			notendchoice=!goodchoice;
		}
		return !checkchoice(mov);
	}
	
	/**
	 * Check if the line and the column are in the table
	 * @param board
	 * @param line
	 * @param column
	 * @return true if the line and the column are in the table
	 */
	public boolean checkLineColumn(Board board, int line, int column)
	{
		try
		{
			System.out.println(board.getColor(line,column));	
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	/**
	 * Check if the order of balls are goodly chosen
	 * @param mov the movement's positions to check
	 * @return true if the order of balls are goodly chosen
	 */
	public boolean checkchoice(Movement mov)
	{
		for(int i=0;mov.getMyBalls()[i+1].getLine()!=0;i++)
		{
			if(mov.getMyBalls()[i].getLine()+mov.getWay().getLine()!=mov.getMyBalls()[i].getLine())
			{
				System.out.println("Vous avez mal saisie l'ordre des balles");
				return false;
			}
		}
		return true;
	}
}
