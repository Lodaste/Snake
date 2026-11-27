package snake.pattern.agent;



import java.util.ArrayList;

import snake.pattern.agent.strategie.SnakeStrategie;
import snake.pattern.utils.enumTypes.AgentAction;
import snake.pattern.utils.features.Position;

public class Snake extends Agent
{
    
	AgentAction lastAction;

	

	public Snake(SnakeStrategie strategie,ArrayList<Position> position)
	{
		super(strategie, position);
		lastAction = AgentAction.MOVE_DOWN;
	}

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

	public AgentAction getLastAction() {
		return lastAction;
	}

	public void setLastAction(AgentAction lasAction) {
		this.lastAction = lasAction;
	}

	@Override
	public void updatePosition(AgentAction lastAction) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updatePosition'");
	}
	
}
