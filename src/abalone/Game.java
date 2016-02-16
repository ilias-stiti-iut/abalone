package abalone;

public class Game
{
	AbaloneGame game = new AbaloneGame();
	
	public Game()
	{
	Player p1 = new Player();
	Player p2 = new Player();
	Player first = new Player();
	Player second = new Player();
	
	double n=Math.random();
	
	if (n>=0.5)
	{
		first = p1;
		second = p2;
	}
	else
	{
		second = p1;
		first = p2;
	}
	
	
	while (game.isEnd)
	{
		if (second.nomoreBalls) {game.isEnd=true;}
		if (first.nomoreBalls) {game.isEnd=true;}
	}
	}
}
