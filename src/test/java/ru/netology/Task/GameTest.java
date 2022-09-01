package ru.netology.Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1,"player1",2);
    Player player2 = new Player(2,"player2",2);
    Player player3 = new Player(3,"player3",1);

    @Test
    public void test() throws NotRegisteredException {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected=0;
        int actual = game.round("player1","player2");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void test1() throws NotRegisteredException{
        Game game = new Game();
      //  game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 1;
        int actual = game.round("player2","player3");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void test2() throws NotRegisteredException{
        Game game = new Game();
        //  game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actual = game.round("player3","player2");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void test3() throws NotRegisteredException{
        Game game = new Game();
        //  game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class,
    () -> game.round("player1","player2"));
    }
    @Test
    public void test4() throws NotRegisteredException{
        Game game = new Game();
          game.register(player1);
       // game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("player1","player2"));
    }

}
