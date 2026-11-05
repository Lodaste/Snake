package snake.pattern.utils.CommandStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import snake.pattern.Test;
import snake.pattern.archi.view.ViewCommand;

public class RunningState implements ViewCommandState
{
    ViewCommand viewCommand;
    /**
     * Logger de classe
     */
    private static final Logger logger = LoggerFactory.getLogger(RunningState.class);

    public RunningState(ViewCommand viewCommand)
    {
        this.viewCommand = viewCommand;
        viewCommand.getRestartButton().setEnabled(true);
        viewCommand.getPlayButton().setEnabled(false);
        viewCommand.getPauseButton().setEnabled(true);
        viewCommand.getStepButton().setEnabled(false);
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
        logger.error("Play non autorisé");
    }

    @Override
    public void pause() 
    {
        viewCommand.setViewCommandState(new PauseState(viewCommand));
    }

    @Override
    public void step() 
    { 
        logger.error("Step non autorisé");
    }
}
