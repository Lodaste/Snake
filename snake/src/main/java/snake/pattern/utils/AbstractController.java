package snake.pattern.utils;

import snake.pattern.archi.Game;

public abstract class AbstractController 
{
    protected Game game;
    /**
     * arrêt et réinitialisation
     */
    protected abstract void restart();

    /**
     * passage manuel d’une étape
     */
    protected abstract void step();

    /**
     * passage automatique des étapes
     */
    protected abstract void play();

    /**
     * interruption du passage automatique des étapes
     */
    protected abstract void pause();

    /**
     * réglage de la vitesse du jeu
     */
    protected abstract void setSpeed(double speed);
}
