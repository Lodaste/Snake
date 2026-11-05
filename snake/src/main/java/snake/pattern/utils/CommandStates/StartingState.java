package snake.pattern.utils.CommandStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import snake.pattern.Test;
import snake.pattern.archi.view.ViewCommand;

public class StartingState implements ViewCommandState
{
    /**
     * Logger de classe
     */
    private static final Logger logger = LoggerFactory.getLogger(StartingState.class);
    ViewCommand viewCommand;

    public StartingState(ViewCommand viewCommand)
    {
        this.viewCommand = viewCommand;
        viewCommand.getRestartButton().setEnabled(false);
        viewCommand.getPlayButton().setEnabled(true);
        viewCommand.getPauseButton().setEnabled(false);
        viewCommand.getStepButton().setEnabled(true);

        logger.debug("Nouvel état");
    }

    @Override
    public void restart() 
    {
        logger.error("Restart non autorisé");
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
        viewCommand.setViewCommandState(new PauseState(viewCommand));
    }
}
