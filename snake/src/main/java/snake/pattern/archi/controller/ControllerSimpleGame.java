package snake.pattern.archi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import snake.pattern.archi.SimpleGame;
import snake.pattern.archi.view.ViewCommand;
import snake.pattern.archi.view.ViewSimpleGame;

public class ControllerSimpleGame extends AbstractController 
{
    /**
     * Controlleur de la classe
     */
    private static final Logger logger = LoggerFactory.getLogger(ControllerSimpleGame.class);

    public ControllerSimpleGame(int maxTurn, Long time)
    {
        game = new SimpleGame(maxTurn, time);     //Hériter de game par Abstract controlleur


        ViewSimpleGame viewGame= new ViewSimpleGame(); //une vue de jeu

        ViewCommand viewCommand = new ViewCommand(this); // une vue de commandes

        //Ajouter les Observateurs
        game.enregistrerObservateur(viewGame);
        game.enregistrerObservateur(viewCommand);
        
    }

    @Override
    public void restart()
    {
        game.gameOver();
        game.init();
        logger.debug("Restart");
    }

    @Override 
    public void step()
    {
        game.step();
        logger.debug("Step");
    }

    @Override 
    public void play()
    {
        game.launch();
        logger.debug("Play");
    }

    @Override 
    public void pause()
    {
        game.pause();
        logger.debug("Pause");
    }

    @Override 
    public void setSpeed(double speed)
    {
        game.setTime((long) speed * 1000);
    }
}
