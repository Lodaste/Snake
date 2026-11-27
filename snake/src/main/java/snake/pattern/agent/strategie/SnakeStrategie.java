package snake.pattern.agent.strategie;

import snake.pattern.agent.Agent;
import snake.pattern.utils.enumTypes.AgentAction;

/**
 * Interface de stratégie pour les agents
 * SnakeStrategie
 */
public interface SnakeStrategie 
{
    boolean isLegalMove(Agent agent, AgentAction action); 
    void moveAgent(Agent agent);
}
