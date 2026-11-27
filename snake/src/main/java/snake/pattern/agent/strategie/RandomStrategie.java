package snake.pattern.agent.strategie;

import java.util.Random;


import snake.pattern.agent.Agent;
import snake.pattern.utils.enumTypes.AgentAction;
import snake.pattern.utils.features.Position;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implémente un statégie aléatoire pour un Snake
 * RandomStrategie
 */
public class RandomStrategie implements SnakeStrategie
{

    /**
     * Logger de la classe
     */
    private static final Logger logger = LoggerFactory.getLogger(RandomStrategie.class);

    /**    (non-Javadoc)
     * Détermine simplement si un mouvement est légal ou non
     * @see snake.pattern.agent.strategie.SnakeStrategie#isLegalMove(snake.pattern.agent.Agent, snake.pattern.utils.enumTypes.AgentAction)
     */
    public boolean isLegalMove(Agent agent, AgentAction action)
    {
        return switch (agent.getLastAction())
        {
            case MOVE_UP -> action != AgentAction.MOVE_DOWN;
            case MOVE_DOWN -> action != AgentAction.MOVE_UP;
            case MOVE_LEFT -> action != AgentAction.MOVE_RIGHT;
            case MOVE_RIGHT -> action != AgentAction.MOVE_LEFT;
            default -> true;
        };
    }

    /**    (non-Javadoc)
     * Méthode qui détermine le mouvement d'un agent et met à jour sa position
     * @see snake.pattern.agent.strategie.SnakeStrategie#moveAgent(snake.pattern.agent.Agent)
     */
    public void moveAgent(Agent agent)
    {
        Random random = new Random();
        int nombreAleatoire;
        AgentAction action ;

        //Vérifier si le move est légal
        do
        {
            nombreAleatoire = random.nextInt(4);
            logger.debug("Valeur aléatoire : {}", nombreAleatoire);
            action = switch (nombreAleatoire) 
            {
                case 0 -> AgentAction.MOVE_UP;
                case 1 -> AgentAction.MOVE_DOWN;
                case 2 -> AgentAction.MOVE_LEFT;
                case 3 -> AgentAction.MOVE_RIGHT;
                    
                default ->
                {
                    logger.debug("Default action, previous was {}", agent.getLastAction());
                    yield AgentAction.MOVE_UP;
                }

                
                 
            };

        }
        while (!isLegalMove(agent, action));

        logger.debug("moving : {}", action);

        //Mettre à jour la position
        int x = agent.getPosition().getFirst().getX();
        int y = agent.getPosition().getFirst().getY();
        logger.debug("x : {}, y : {}", x, y);
        switch (action) 
        {
            case AgentAction.MOVE_UP -> --y;
            case AgentAction.MOVE_DOWN -> ++y;
            case AgentAction.MOVE_RIGHT -> ++x;
            case AgentAction.MOVE_LEFT -> --x;

            default -> logger.error("Mouvement Impossible"); // Renvoyer une erreur

        }
        logger.debug("x : {}, y : {}", x, y);


        agent.getPosition().addFirst(new Position(x, y));
        agent.setLastAction(action);
    }

}
