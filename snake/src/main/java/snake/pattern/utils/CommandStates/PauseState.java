package snake.pattern.utils.CommandStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import snake.pattern.Test;
import snake.pattern.archi.view.ViewCommand;

public class PauseState implements ViewCommandState
{
    ViewCommand viewCommand;

    /**
     * Logger de classe
     */
    private static final Logger logger = LoggerFactory.getLogger(PauseState.class);

    public PauseState(ViewCommand viewCommand)
    {
        this.viewCommand = viewCommand;
        viewCommand.getRestartButton().setEnabled(true);
        viewCommand.getPlayButton().setEnabled(true);
        viewCommand.getPauseButton().setEnabled(false);
        viewCommand.getStepButton().setEnabled(true);
        logger.debug("Nouvel état");
    }

    @Override
    public void restart() 
    {
        viewCommand.setViewCommandState(new StartingState(viewCommand));
    }

    @Override
    public void play() 
    {
        viewCommand.setViewCommandState(new RunningState(viewCommand));
    }

    @Override
    public void pause() 
    {
        logger.error("Pause non autorisée");
    }

    @Override
    public void step() 
    { 
        logger.debug("Step manuel");

        /**
         * A faire avec un observateur qui vérifie l'état de fin du jeu
         */
        if (viewCommand.getController().getGame().getCurentTurn() == viewCommand.getController().getGame().getMaxTurn())
            viewCommand.setViewCommandState(new EndState(viewCommand));
    }
}
