package snake.pattern.archi;

import snake.pattern.utils.AbstractController;
import snake.pattern.view.ViewCommand;
import snake.pattern.view.ViewSimpleGame;

public class ControllerSimpleGame extends AbstractController 
{

    public ControllerSimpleGame(int maxTurn, Long time)
    {
        game = new SimpleGame(maxTurn, time);     //Hériter de game par Abstract controlleur


        ViewSimpleGame viewGame= new ViewSimpleGame(); //une vue de jeu

        ViewCommand viewCommand = new ViewCommand(this); // une vue de commandes

        //Ajouter les Observateurs
        game.enregistrerObservateur(viewGame);
        game.enregistrerObservateur(viewCommand);
        
    }

    @Override 
    protected void restart()
    {
        game.gameOver();
        game.init();
    }

    @Override 
    protected void step()
    {
        game.step();
    }

    @Override 
    protected void play()
    {
        //game.setRunning(true);
        game.run();
    }

    @Override 
    protected void pause()
    {
        game.pause();
    }

    @Override 
    protected void setSpeed(double speed)
    {
        game.setTime((long) speed * 1000);
    }
}
