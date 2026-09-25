package snake.pattern.view;

import javax.swing.*;
import java.awt.*;

public class ViewCommand 
{
    JFrame frame = new JFrame();

    public ViewCommand()
    {
        frame.setSize(new Dimension(700, 250));
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension windowSize = frame.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2 ;
        int dy = centerPoint.y - windowSize.height / 2 - 350;
        frame.setLocation(dx, dy);
        

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 4));

        JPanel turnsPanel = new JPanel();
        turnsPanel.setLayout(new GridLayout(1, 2));

        mainPanel.add(buttonsPanel);
        mainPanel.add(turnsPanel);

        Icon restartIcon = new ImageIcon("snake/src/main/resources/icons/icon_restart.png");
        JButton restartButton = new JButton(restartIcon);

        Icon playIcon = new ImageIcon("snake/src/main/resources/icons/icon_play.png");
        JButton playButton = new JButton(playIcon);

        Icon pauseIcon = new ImageIcon("snake/src/main/resources/icons/icon_pause.png"); 
        JButton pauseButton = new JButton(pauseIcon);

        Icon stepIcon = new ImageIcon("snake/src/main/resources/icons/icon_step.png");
        JButton stepButton = new JButton(stepIcon);

        buttonsPanel.add(restartButton);
        buttonsPanel.add(playButton);
        buttonsPanel.add(stepButton);
        buttonsPanel.add(pauseButton);

        Panel subTurnsPanel = new Panel();
        subTurnsPanel.setLayout(new GridLayout(2, 1));

        JLabel turnsSec = new JLabel("Nobre de tours par secondes", JLabel.CENTER);
        JSlider turnsSlider = new JSlider(1, 10, 1);

        turnsSlider.setPaintTicks(true);
        turnsSlider.setPaintLabels(true);
        turnsSlider.setPaintTrack(true);
        turnsSlider.setMajorTickSpacing(1);

        subTurnsPanel.add(turnsSec);
        subTurnsPanel.add(turnsSlider);

        JLabel turns = new JLabel("Tour actuel : 5", JLabel.CENTER);

        turnsPanel.add(subTurnsPanel);
        turnsPanel.add(turns);

        frame.add(mainPanel);


        

        frame.setVisible(true); 
    }
    


    public static void main(String[] args) 
    {
        ViewCommand viewCommand = new ViewCommand();
    }
}
