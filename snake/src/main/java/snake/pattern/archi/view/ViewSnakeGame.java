package snake.pattern.archi.view;


import javax.swing.*;

import org.slf4j.LoggerFactory;

import snake.pattern.archi.view.Panel.PanelSnakeGame;
import snake.pattern.utils.Observable;
import snake.pattern.utils.Observateur;
import snake.pattern.utils.features.FeaturesItem;
import snake.pattern.utils.features.FeaturesSnake;
import snake.pattern.archi.Game;
import snake.pattern.archi.SnakeGame;
import snake.pattern.archi.controller.AbstractController;
import snake.pattern.archi.model.InputMap;

import java.awt.*;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewSnakeGame implements Observateur
{
    /**
     * La fenêtre de cette interface
     */
    JFrame frame = new JFrame();

    JLabel jeu;

    InputMap inputMap;

    AbstractController controller;

    SnakeGame game;

    PanelSnakeGame panelSnakeGame;

    private static final Logger logger = LoggerFactory.getLogger(ViewSnakeGame.class);
    
    public ViewSnakeGame(InputMap inputMap, AbstractController controller, SnakeGame game) 
    {
        this.controller = controller;
        this.game = game;
        game.enregistrerObservateur(this);
        this.inputMap = inputMap;
        frame.setSize(new Dimension(700, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension windowSize = frame.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 50 ;
        int dy = centerPoint.y - windowSize.height / 50 - 350;
        frame.setLocation(dx, dy);
        

        jeu = new JLabel("TEST JEU", JLabel.CENTER);
        //frame.add(jeu);

        //----------------------

        

        this.panelSnakeGame = new PanelSnakeGame(inputMap.getSizeX(), inputMap.getSizeY(), inputMap.get_walls() , inputMap.getStart_snakes(), inputMap.getStart_items());

        frame.add(panelSnakeGame);
        frame.setVisible(true); 
    }



    @Override
    public void actualiser(int curentTurn) 
    {
        logger.debug("\t\tactualisation ...");
        panelSnakeGame.updateInfoGame(game.getSnakes(), game.getItems());
        panelSnakeGame.repaint();

    }
}
