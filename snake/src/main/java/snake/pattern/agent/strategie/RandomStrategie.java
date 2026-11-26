package snake.pattern.agent.strategie;

import java.util.Random;

import snake.pattern.agent.Agent;
import snake.pattern.utils.enumTypes.AgentAction;

public class RandomStrategie implements SnakeStrategie
{
    public boolean isLegalMove(Agent agent, AgentAction action)
    {
        if(agent.getLastAction() == action)
            return false;
        else
            return true;
    }

    public AgentAction moveAgent(Agent agent)
    {
        Random random = new Random();
        int nombreAleatoire;
        AgentAction action ;

        do
        {
            nombreAleatoire = random.nextInt(4);
            action = switch (nombreAleatoire) 
            {
                case 0 -> AgentAction.MOVE_UP;
                case 1 -> AgentAction.MOVE_DOWN;
                case 2 -> AgentAction.MOVE_LEFT;
                case 3 -> AgentAction.MOVE_RIGHT;
                    
                default -> AgentAction.MOVE_UP; // Renvoyer une erreur
            };

        }
        while (isLegalMove(agent, action));
        return action;
    }

}
