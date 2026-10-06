package snake.pattern.utils;

public interface Observateur 
{
    /**
     * Notification d'un nouveau tour
     * @param curentTurn
     */
    public void actualiser(int curentTurn);
}
