package snake.pattern.archi;

public abstract class Game implements Runnable
{
    int curentTurn;
    int maxTurn;
    boolean isRunning;
    Long time;
    Thread thread;

    public Game (int maxTurn, long time)
    {
        this.maxTurn = maxTurn;
        this.time = time;
    }

    public void init()
    {
        curentTurn = 0;
        isRunning = true;
        
        initializeGame();
    }

    protected abstract void initializeGame();

    public void launch()
    {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    
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

    protected abstract void takeTurn();

    protected abstract void gameOver();

    protected abstract boolean isGameOver();

    void pause()
    {
        isRunning = false;
    }

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
                System.out.println("Erreur time"); // Throw une erreur ?
            }
        }
    }
}
