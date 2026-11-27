package snake.pattern.agent;

import java.util.ArrayList;

import snake.pattern.agent.strategie.SnakeStrategie;
import snake.pattern.utils.enumTypes.AgentAction;
import snake.pattern.utils.features.Position;

/**
 * Classe représetant des agents du jeu (pour le moment des Snake)
 * Agent
 */
public abstract class Agent
{
    SnakeStrategie strategie;
    ArrayList<Position> position;
    
    public Agent(SnakeStrategie strategie, ArrayList<Position> position)
    {
        this.strategie = strategie;
        this.position = position;
    }

    public abstract void updatePosition(AgentAction lastAction);
    public abstract AgentAction getLastAction();
    public abstract void setLastAction(AgentAction lastAction);

    public SnakeStrategie getStrategie() {
        return strategie;
    }

    public void setStrategie(SnakeStrategie strategie) {
        this.strategie = strategie;
    }

    public ArrayList<Position> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<Position> position) {
        this.position = position;
    }

    
}
