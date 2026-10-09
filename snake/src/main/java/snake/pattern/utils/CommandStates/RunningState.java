package snake.pattern.utils.CommandStates;

import snake.pattern.utils.ViewCommandState;
import snake.pattern.view.ViewCommand;

public class RunningState implements ViewCommandState
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
        viewCommand.getPlayButton().setEnabled(false);
    }

    @Override
    public void pause() 
    {
        viewCommand.getPauseButton().setEnabled(true);
        viewCommand.setViewCommandState(new PauseState());
    }

    @Override
    public void step() 
    { 
        viewCommand.getStepButton().setEnabled(false);
    }
}
