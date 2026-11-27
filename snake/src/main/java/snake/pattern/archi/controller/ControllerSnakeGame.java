package snake.pattern.archi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import snake.pattern.archi.SnakeGame;
import snake.pattern.archi.view.ViewCommand;
import snake.pattern.archi.view.ViewSnakeGame;

/**
 * Controlleur concret pour le SnakeGame
 * ControllerSnakeGame
 */
public class ControllerSnakeGame extends AbstractController
{
    /**
     * Controlleur de la classe
     */
    private static final Logger logger = LoggerFactory.getLogger(ControllerSnakeGame.class);

    public ControllerSnakeGame(SnakeGame game)
    {
       this.game = game;    //Hériter de game par Abstract controlleur

        ViewSnakeGame viewGame= new ViewSnakeGame(game.getInputMap(), this, game); //une vue de jeu qui est un Observateur
        ViewCommand viewCommand = new ViewCommand(this, game); // une vue de commandes 

        game.init();
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
