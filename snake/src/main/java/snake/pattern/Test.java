package snake.pattern;

import snake.pattern.archi.SimpleGame;

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
        SimpleGame game = new SimpleGame(10, Long.valueOf(1000));

        logger.info(("Démmarage du test"));

        game.init();
        game.step();
        game.run();

        logger.info("Fin du test");
    }
}