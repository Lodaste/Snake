package snake.pattern;

import snake.pattern.archi.Game;
import snake.pattern.archi.SimpleGame;
import snake.pattern.archi.SnakeGame;
import snake.pattern.archi.controller.AbstractController;
import snake.pattern.archi.controller.ControllerSimpleGame;
import snake.pattern.archi.controller.ControllerSnakeGame;
import snake.pattern.archi.model.InputMap;
import snake.pattern.archi.view.ViewCommand;
import snake.pattern.archi.view.ViewSimpleGame;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe pour tester l'application
 */
public class Test 
{
    /**
     * Logger de classe
     */
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) 
    {
        logger.debug("test");
        logger.info("test");
        logger.warn("test");
        logger.error("test");

        SnakeGame snakeGame = new SnakeGame(10, Long.valueOf(2000), new InputMap("snake/src/main/resources/layouts/alone.lay"));

        ControllerSnakeGame controllerSnakeGame = new ControllerSnakeGame(snakeGame);






        /* 
        Game game = new SimpleGame(10, Long.valueOf(2000)); //temps ebtre chaque tours x/1000 secondes
        
        AbstractController simple = new ControllerSimpleGame(game);

        logger.info(("Démmarage du test"));

        game.init();
        game.step();
        game.run();

        logger.info("Fin du test");
        */
        
    }
}