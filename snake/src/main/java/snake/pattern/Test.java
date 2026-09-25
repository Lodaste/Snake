package snake.pattern;

import snake.pattern.archi.SimpleGame;

public class Test 
{
    public static void main(String[] args) 
    {
        System.out.println("Hello world!");
        SimpleGame game = new SimpleGame(10, Long.valueOf(1000));

        game.init();
        game.step();
        game.run();
    }
}