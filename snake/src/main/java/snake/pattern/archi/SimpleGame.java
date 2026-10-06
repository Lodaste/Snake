package snake.pattern.archi;

import snake.pattern.utils.Observateur;

/**
 * Classe concrète implémentant un patron de méthode, exemple textuel du déroulement du jeu
 */
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


    /**    (non-Javadoc)
     * Notifier les vues d'un nouveau tour
     * @see snake.pattern.archi.Game#takeTurn()
     */
    @Override
    protected void takeTurn() 
    {
        System.out.println("Tour " + curentTurn + " du jeu en cours");
        notifierObservateurs();
    }


    @Override
    protected void gameOver() 
    {
        System.out.println("Fin de la partie");
    }
}
