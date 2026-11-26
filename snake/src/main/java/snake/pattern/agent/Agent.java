package snake.pattern.agent;

import snake.pattern.agent.strategie.SnakeStrategie;
import snake.pattern.utils.enumTypes.AgentAction;

public abstract class Agent
{
    SnakeStrategie strategie;
    
    public Agent(SnakeStrategie strategie)
    {
        this.strategie = strategie;
    }

    public SnakeStrategie getStrategie()
    {
        return strategie;
    }

    public abstract AgentAction getLastAction();
}
