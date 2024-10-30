package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу
     * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1439">https://acm.timus.ru/problem.aspx?space=1&num=1439</a>
     */
    public List<Integer> getOriginalDoorNumbers(int maxDoors, List<Action> actionList) {
        var destroyedRooms = new TreeMap<Integer, Integer>();
        var output = new ArrayList<Integer>();

        for (var action : actionList) {
            var roomNumber = action.getDoorNumber();
            if (action.isLook()) {
                var destroyedMap = destroyedRooms.headMap(roomNumber, true);
                var shift = destroyedMap.getOrDefault(roomNumber, 0);
                output.add(roomNumber + shift);
            } else {
                destroyedRooms.merge(roomNumber, 1, (k, v) -> v + 1);
            }
        }
        return output;
    }

    /**
     * <h1>Задание 2.</h1>
     * Решить задачу <br/>
     * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1521">https://acm.timus.ru/problem.aspx?space=1&num=1521</a><br/>
     * <h2>Пошагово</h2>
     * Для 5 3 входных данных:<br/>
     * _ -> 3 позиции<br/>
     * _ 1 2 <b>3</b> 4 5 => 3 <br/>
     * <b>1</b> 2 _ 4 5 => 1 <br/>
     * _ 2 4 <b>5</b> => 5 <br/>
     * <b>2</b> 4 _ => 2 <br/>
     * _ <b>4</b> => 4
     */
    public List<Integer> getLeaveOrder(int totalSoldiers, int interval) {
        List<Integer> remainingSoldiers = new ArrayList<>();
        List<Integer> leavingOrder = new ArrayList<>();
        for (int soldierNumber = 1; soldierNumber <= totalSoldiers; soldierNumber++) {
            remainingSoldiers.add(soldierNumber);
        }

        int currentIndex = 0;

        while (!remainingSoldiers.isEmpty()) {
            currentIndex = (currentIndex + interval - 1) % remainingSoldiers.size();
            leavingOrder.add(remainingSoldiers.remove(currentIndex));
        }

        return leavingOrder;
    }
}
