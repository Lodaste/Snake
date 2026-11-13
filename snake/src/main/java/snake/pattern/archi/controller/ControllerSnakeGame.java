package snake.pattern.archi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import snake.pattern.archi.SnakeGame;
import snake.pattern.archi.model.InputMap;
import snake.pattern.archi.view.ViewCommand;
import snake.pattern.archi.view.ViewSnakeGame;

public class ControllerSnakeGame extends AbstractController
{
    /**
     * Controlleur de la classe
     */
    private static final Logger logger = LoggerFactory.getLogger(ControllerSnakeGame.class);

    public ControllerSnakeGame(int maxTurn, Long time, String map)
    {
        game = new SnakeGame(maxTurn, time);     //Hériter de game par Abstract controlleur

        InputMap inputMap = new InputMap(map);
        //snake/src/main/resources/layouts/alone.lay

        ViewSnakeGame viewGame= new ViewSnakeGame(inputMap); //une vue de jeu

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
