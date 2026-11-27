package snake.pattern.archi;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import snake.pattern.agent.Agent;
import snake.pattern.agent.Fabrique;
import snake.pattern.agent.FabriqueSnake;
import snake.pattern.agent.strategie.RandomStrategie;
import snake.pattern.archi.model.InputMap;
import snake.pattern.utils.enumTypes.ColorSnake;
import snake.pattern.utils.features.FeaturesItem;
import snake.pattern.utils.features.FeaturesSnake;

public class SnakeGame extends  Game
{
     /**
     * Logger de classe
     */
    private static final Logger logger = LoggerFactory.getLogger(SnakeGame.class);

    InputMap inputMap;

    List<Agent> agents;
    List<FeaturesItem> items;
    
    public SnakeGame (int maxTurn, Long time, InputMap inputMap)
    {
        super(maxTurn, time);
        this.inputMap = inputMap;
        agents = new ArrayList<>();
        items = inputMap.getStart_items();

        for (FeaturesSnake snake : inputMap.getStart_snakes()) {
            logger.info("{}", snake);
        }
    }

    @Override
    protected boolean isGameOver()
    {
        return false;
    }


    @Override
    protected void initializeGame() 
    {
        logger.info("Début de la partie");
        
        /**
         * Création d'agent snake avec les informations présentes dans la liste de featureSnake de inputMap
         */
        agents.clear();
        Fabrique fabrique = new FabriqueSnake();
        for (FeaturesSnake snakeInfo : inputMap.getStart_snakes()) 
        {
            logger.debug("creation sanke one");
            agents.add(fabrique.créerAgent(snakeInfo, new RandomStrategie()));
        }

        logger.debug("agent snake : {} ", agents.toArray());
    }


    /**    (non-Javadoc)
     * Notifier les vues d'un nouveau tour
     * @see snake.pattern.archi.Game#takeTurn()
     */
    @Override
    protected void takeTurn() 
    {
        
        logger.info("Tour {} du jeu en cours", curentTurn);
        for (Agent agent : agents) 
        {
            agent.getStrategie().moveAgent(agent); // retourne une AgentAction (à utiliser dans )
        }
        notifierObservateurs();
    }


    @Override
    public void gameOver() 
    {
        isRunning = false;
        logger.info("Fin de la partie");
    }

    public InputMap getInputMap() {
        return inputMap;
    }


    public ArrayList<FeaturesSnake> getSnakes() 
    {

        logger.debug("getting snakes");
        ArrayList<FeaturesSnake> snakes = new ArrayList<>();
        for (Agent agent : agents) 
        {
            logger.debug("one snake ...");
            snakes.add(new FeaturesSnake(agent.getPosition(), agent.getLastAction(), ColorSnake.Green, false , false));   // à adapter au nom réel dans ta classe Agent
        }

        logger.debug("printing snakes");
        for (FeaturesSnake snake : snakes)
        {
            logger.debug("{}", snake);
        }

        return snakes;
    }

public ArrayList<FeaturesItem> getItems() 
{
    return new ArrayList<>(items);
}
    
}
