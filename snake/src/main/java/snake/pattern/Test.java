package snake.pattern;

import snake.pattern.archi.SimpleGame;
import snake.pattern.view.ViewCommand;
import snake.pattern.view.ViewSimpleGame;

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
    }
}