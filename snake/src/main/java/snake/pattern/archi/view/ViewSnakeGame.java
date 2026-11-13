package snake.pattern.archi.view;


import javax.swing.*;

import snake.pattern.archi.view.Panel.PanelSnakeGame;
import snake.pattern.utils.Observateur;
import snake.pattern.archi.model.InputMap;

import java.awt.*;

public class ViewSnakeGame implements Observateur
{
    /**
     * La fenêtre de cette interface
     */
    JFrame frame = new JFrame();

    JLabel jeu;

    InputMap inputMap;
    public ViewSnakeGame(InputMap inputMap) 
    {
        this.inputMap = inputMap;
        frame.setSize(new Dimension(700, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension windowSize = frame.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2 ;
        int dy = centerPoint.y - windowSize.height / 2 - 350;
        frame.setLocation(dx, dy);
        

        jeu = new JLabel("TEST JEU", JLabel.CENTER);
        //frame.add(jeu);

        //----------------------

        

        PanelSnakeGame panelSnakeGame = new PanelSnakeGame(inputMap.getSizeX(), inputMap.getSizeY(), inputMap.get_walls() , inputMap.getStart_snakes(), inputMap.getStart_items());

        frame.add(panelSnakeGame);
        frame.setVisible(true); 
    }



    @Override
    public void actualiser(int curentTurn) {
        jeu.setText("Tour actuel : " + curentTurn);
    }
}
