package snake.pattern.archi;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import snake.pattern.utils.Observable;
import snake.pattern.utils.Observateur;


/**
 * Classe abstraite représentant une patron de méthode
 * Game
 */
public abstract class Game implements Runnable, Observable
{
    private static final Logger logger = LoggerFactory.getLogger(Game.class);
    /**
     * Le tour courrent
     */
    int curentTurn;

    /**
     * Le nombre maximum de tours
     */
    int maxTurn;

    /**
     * Drapeau boolean indiquant si le jeu tourne encore
     */
    boolean isRunning;

    /**
     * Temps en milisecondes entre chaque tours
     */
    Long time;

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * Une instance de jeu
     */
    Thread thread;

    protected List<Observateur> views = new ArrayList<>();

    public Game (int maxTurn, long time)
    {
        this.maxTurn = maxTurn;
        this.time = time;
    }

    /**
     * Méthode poour initialiser mettre à zéro certains paramêtre d'une partie
     */
    public void init()
    {
        curentTurn = 0;
        isRunning = true;
        
        initializeGame();
    }

    /**
     * Initialise une partie
     */
    protected abstract void initializeGame();

    /**
     * Initialise une instance de jeu (thread)
     */
    public void launch()
    {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    
    /**
     * Méthode se pérocupant du prochain de lancer leprochain tour de jeu si possible
     */
    public void step()
    {
        curentTurn ++;
        if (isGameOver() || curentTurn == maxTurn)
        {
            isRunning = false;
            gameOver();
        }
        else
        {
            takeTurn();
        }
    }

    /**
     * Prochain tour de jeu
     */
    protected abstract void takeTurn();

    /**
     * Méthode pour terminer une partie
     */
    protected abstract void gameOver();

    /**
     * Méthode indiquant si la partie est finie
     * @return l'état de la partie
     */
    protected abstract boolean isGameOver();

    /**
     * Met en pause le jeu
     */
    void pause()
    {
        isRunning = false;
    }

    /**    (non-Javadoc)
     * Méthode core d'une partie invoquant le possible tour à venir
     * @see java.lang.Runnable#run()
     */
    public void run()
    {
        while(isRunning)
        {
            step();
            try 
            {
                Thread.sleep(time);
            } catch (InterruptedException e) 
            {
                logger.error("Le programme ne s'est pas endormis", e);
            }
        }
    }

    @Override
    public void enregistrerObservateur(Observateur view) 
    {
        views.add(view);
    }

    @Override
    public void supprimerObservateur(Observateur view) 
    {
        views.remove(view);
    }

    @Override
    public void notifierObservateurs() 
    {
        for (Observateur view : views) 
        {
            view.actualiser(curentTurn);
        }
    }
}
