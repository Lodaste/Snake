package snake.pattern.utils.CommandStates;

import snake.pattern.utils.ViewCommandState;
import snake.pattern.view.ViewCommand;

public class PauseState implements ViewCommandState
{
    ViewCommand viewCommand;

    @Override
    public void restart() 
    {
        viewCommand.getRestartButton().setEnabled(true);
        viewCommand.setViewCommandState(new StartingState());
    }

    @Override
    public void play() 
    {
        viewCommand.getPlayButton().setEnabled(true);
        viewCommand.setViewCommandState(new RunningState());
    }

    @Override
    public void pause() 
    {
        viewCommand.getPauseButton().setEnabled(false);
    }

    @Override
    public void step() 
    { 
        viewCommand.getStepButton().setEnabled(true);
    }
}
