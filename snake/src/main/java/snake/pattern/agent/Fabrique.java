package snake.pattern.agent;

import snake.pattern.agent.strategie.SnakeStrategie;
import snake.pattern.utils.features.FeaturesSnake;

/**
 * Interface de Frabrique abstraite
 * Fabrique
 */
public interface Fabrique
{
    Agent créerAgent(FeaturesSnake features, SnakeStrategie strategie);
}
