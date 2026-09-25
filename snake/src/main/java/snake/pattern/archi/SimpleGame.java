package snake.pattern.archi;

public class SimpleGame extends Game
{

    public SimpleGame (int maxTurn, Long time)
    {
        super(maxTurn, time);
    }

    @Override
    protected boolean isGameOver()
    {
        return false;
    }


    @Override
    protected void initializeGame() {
        System.out.println("Début dfe la partie");
    }


    @Override
    protected void takeTurn() 
    {
        System.out.println("Tour " + curentTurn + " du jeu en cours");
    }


    @Override
    protected void gameOver() 
    {
        System.out.println("Fin de la partie");
    }
}
