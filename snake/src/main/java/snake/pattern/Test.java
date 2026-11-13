package snake.pattern;

import snake.pattern.archi.SimpleGame;
import snake.pattern.archi.controller.ControllerSimpleGame;
import snake.pattern.archi.controller.ControllerSnakeGame;
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
        //ControllerSimpleGame controllerSimpleGame = new ControllerSimpleGame(10, (long) 1000);

        ControllerSnakeGame controllerSnakeGame = new ControllerSnakeGame(10, (long) 1000, "snake/src/main/resources/layouts/alone.lay");






        /*
        SimpleGame game = new SimpleGame(10, Long.valueOf(2000)); //temps ebtre chaque tours x/1000 secondes
        
        ViewSimpleGame viewGame= new ViewSimpleGame(); //une vue de jeu

        ViewCommand viewCommand = new ViewCommand(); // une vue de commandes

        //Ajouter les Observateurs
        game.enregistrerObservateur(viewGame);
        game.enregistrerObservateur(viewCommand);

        logger.info(("Démmarage du test"));

        game.init();
        game.step();
        game.run();

        logger.info("Fin du test");
        */
    }
}