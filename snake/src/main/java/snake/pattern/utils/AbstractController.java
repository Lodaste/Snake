package snake.pattern.utils;

import snake.pattern.archi.Game;

public abstract class AbstractController 
{
    protected Game game;
    /**
     * arrêt et réinitialisation
     */
    public abstract void restart();

    /**
     * passage manuel d’une étape
     */
    public abstract void step();

    /**
     * passage automatique des étapes
     */
    public abstract void play();

    /**
     * interruption du passage automatique des étapes
     */
    public abstract void pause();

    /**
     * réglage de la vitesse du jeu
     */
    public abstract void setSpeed(double speed);
}
