package snake.pattern.archi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import snake.pattern.archi.SnakeGame;
import snake.pattern.archi.model.InputMap;

public class ControllerSnakeGame extends AbstractController
{
    /**
     * Controlleur de la classe
     */
    private static final Logger logger = LoggerFactory.getLogger(ControllerSnakeGame.class);

    public ControllerSnakeGame(int maxTurn, Long time, String map)
    {
        

        InputMap inputMap = new InputMap(map);
        //snake/src/main/resources/layouts/alone.lay

        game = new SnakeGame(maxTurn, time, inputMap);     //Hériter de game par Abstract controlleur

        //ViewSnakeGame viewGame= new ViewSnakeGame(inputMap); //une vue de jeu qui est un Observateur

        //ViewCommand viewCommand = new ViewCommand(this); // une vue de commandes 
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
