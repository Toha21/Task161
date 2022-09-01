package ru.netology.Task;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }
    /*register(Player player) - метод регистрации игрока; если игрок не зарегистрирован,
    то он не сможет играть в турнире.
     Вам нужно хранить всех зарегистрированных игроков в поле класса Game в виде списка.*/

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Player не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player не зарегистрирован");
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        return 2;
    }
}

    /*round(String playerName1, String playerName2) - метод соревнования между двумя игроками.
     Если хотя бы один из игроков незарегистрирован, должно выкинуться исключение NotRegisteredException
     (сами создайте его класс). Обратите внимание, что игроки передаются методу через имя - полную информацию
      об игроке нужно будет найти в коллекции зарегистрированных игроков (см. аналог в виде findById из
      прошлых дз). Выигрывает тот игрок, у которого больше strength (сила); если сила одинаковая,
      то будет ничья. Метод должен возвращать одно число - 0 в случае ничьи,
     1 в случае победы первого игрока и 2 в случае победы второго игрока.
    * */

