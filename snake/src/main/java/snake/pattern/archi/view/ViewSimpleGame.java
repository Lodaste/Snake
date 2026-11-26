package snake.pattern.archi.view;

import javax.swing.*;

import snake.pattern.archi.controller.AbstractController;
import snake.pattern.archi.controller.ControllerSimpleGame;
import snake.pattern.utils.Observable;
import snake.pattern.utils.Observateur;

import java.awt.*;

/**
 * 
 * Classe permttant l'affichage d'une partie
 */
public class ViewSimpleGame implements Observateur
{

    /**
     * La fenêtre de cette interface
     */
    JFrame frame = new JFrame();

    JLabel jeu;

    AbstractController controller;

    Observable game;

    public ViewSimpleGame(AbstractController controller, Observable game) 
    {
        this.controller = controller;
        this.game = game;
        game.enregistrerObservateur(this);

        frame.setSize(new Dimension(700, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension windowSize = frame.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2 ;
        int dy = centerPoint.y - windowSize.height / 2 - 350;
        frame.setLocation(dx, dy);
        

        jeu = new JLabel("TEST JEU", JLabel.CENTER);
        frame.add(jeu);

        frame.setVisible(true); 
    }

    @Override
    public void actualiser(int curentTurn) {
        jeu.setText("Tour actuel : " + curentTurn);
    }


}

