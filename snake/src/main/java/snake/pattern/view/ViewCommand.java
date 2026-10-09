package snake.pattern.view;

import javax.swing.*;

import snake.pattern.archi.ControllerSimpleGame;
import snake.pattern.utils.AbstractController;
import snake.pattern.utils.Observateur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe permttant l'affichage de comandes pour contrôler une partie
 */
public class ViewCommand implements Observateur
{
    /**
     * La fenêtre de cette interface
     */
    JFrame frame = new JFrame();

    /**
     * Nombre de tours courant
     */
    JLabel turns;

    AbstractController controller;

    public ViewCommand(AbstractController controller) 
    {
        this.controller = controller;

        //Créer des propriétés pour la fenêtre
        frame.setSize(new Dimension(700, 250));
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension windowSize = frame.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2 ;
        int dy = centerPoint.y - windowSize.height / 2 - 350;
        frame.setLocation(dx, dy);
        

        //Créer les trois conteneurs principaux de la fenêtre
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 4));

        JPanel turnsPanel = new JPanel();
        turnsPanel.setLayout(new GridLayout(1, 2));

        //Intégrer les deux conteneurs dans le principal
        mainPanel.add(buttonsPanel);
        mainPanel.add(turnsPanel);

        //Créer des boutons et y mettre des icônes
        Icon restartIcon = new ImageIcon("snake/src/main/resources/icons/icon_restart.png");
        JButton restartButton = new JButton(restartIcon);

        Icon playIcon = new ImageIcon("snake/src/main/resources/icons/icon_play.png");
        JButton playButton = new JButton(playIcon);

        Icon pauseIcon = new ImageIcon("snake/src/main/resources/icons/icon_pause.png"); 
        JButton pauseButton = new JButton(pauseIcon);

        Icon stepIcon = new ImageIcon("snake/src/main/resources/icons/icon_step.png");
        JButton stepButton = new JButton(stepIcon);


        /**
         * Ajout d'actions pour les boutons
         */
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evenement) {
            controller.restart();
            }
        });

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evenement) {
            controller.play();
            }
        });

        stepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evenement) {
            controller.step();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evenement) {
            controller.pause();
            }
        });

        //Ajouter les boutons au premier conteneur
        buttonsPanel.add(restartButton);
        buttonsPanel.add(playButton);
        buttonsPanel.add(stepButton);
        buttonsPanel.add(pauseButton);


        //Créer un sous conteneur pour une barre et un texte
        Panel subTurnsPanel = new Panel();
        subTurnsPanel.setLayout(new GridLayout(2, 1));

        JLabel turnsSec = new JLabel("Nobre de tours par secondes", JLabel.CENTER);
        JSlider turnsSlider = new JSlider(1, 10, 1);

        turnsSlider.setPaintTicks(true);
        turnsSlider.setPaintLabels(true);
        turnsSlider.setPaintTrack(true);
        turnsSlider.setMajorTickSpacing(1);

        //Ajouter les éléments au conteneur
        subTurnsPanel.add(turnsSec);
        subTurnsPanel.add(turnsSlider);

        //Créer un label pour le tour courant
        turns = new JLabel("Tour actuel : 5", JLabel.CENTER);

        //Ajouter les éléments au second conteneur
        turnsPanel.add(subTurnsPanel);
        turnsPanel.add(turns);

        //Ajouter le conteneur principal à la fenêtre
        frame.add(mainPanel);
        //Rendre la fenêtre visible
        frame.setVisible(true); 
    }
    


    public static void main(String[] args) 
    {
        ViewCommand viewCommand = new ViewCommand(new ControllerSimpleGame(10, Long.valueOf(2000)));
    }



    @Override
    public void actualiser(int curentTurn)
    {
        System.out.println(curentTurn);
        turns.setText("Tour actuel : " + curentTurn);
    }
}
