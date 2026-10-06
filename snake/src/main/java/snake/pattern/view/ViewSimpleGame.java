package snake.pattern.view;

import javax.swing.*;

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

    public ViewSimpleGame() 
    {
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

    public static void main(String[] args) 
    {
        ViewSimpleGame vuViewSimpleGame = new ViewSimpleGame();
    }

    @Override
    public void actualiser(int curentTurn) {
        jeu.setText("Tour actuel : " + curentTurn);
    }


}

