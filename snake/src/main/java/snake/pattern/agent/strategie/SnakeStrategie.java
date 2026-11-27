package snake.pattern.agent.strategie;

import snake.pattern.agent.Agent;
import snake.pattern.agent.Snake;
import snake.pattern.utils.enumTypes.AgentAction;

public interface SnakeStrategie 
{
    boolean isLegalMove(Agent agent, AgentAction action); 
    void moveAgent(Agent agent);
}
