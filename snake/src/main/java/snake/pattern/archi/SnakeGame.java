package snake.pattern.archi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnakeGame extends  Game
{
     /**
     * Logger de classe
     */
    private static final Logger logger = LoggerFactory.getLogger(SnakeGame.class);
    
    public SnakeGame (int maxTurn, Long time)
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
        logger.info("Début de la partie");
    }


    /**    (non-Javadoc)
     * Notifier les vues d'un nouveau tour
     * @see snake.pattern.archi.Game#takeTurn()
     */
    @Override
    protected void takeTurn() 
    {
        logger.debug("Tour {} du jeu en cours", curentTurn);
        notifierObservateurs();
    }


    @Override
    public void gameOver() 
    {
        isRunning = false;
        logger.info("Fin de la partie");
    }
}
