package ivan.boiko.algorithms.filling;


import ivan.boiko.algorithms.filling.exceptions.NegativeAmountException;
import ivan.boiko.algorithms.filling.exceptions.NoProperFillingException;
import ivan.boiko.algorithms.filling.exceptions.NullAmountException;

import java.util.*;

/**
 * Постановка задачи:
 * Написать программу которая должна определить,
 * сколькими способами можно залить воду в N литровый резервуар,
 * используя ведра литража: 10л, 5л, 2л, 1л.
 * <p>
 * Входящие данные - случайная выборка от 10 до 200 литров.
 * <p>
 * Примерный формат вывода информации:
 * n=6
 * 6 по 1л
 * 4 по 1л + 1 по 2л
 * 2 по 1л + 2 по 2л
 * 3 по 2л
 * 1 по 5л + 1 по 1л
 * <p>
 * Итого, при n=6 наш ответ будет 5.
 */
public class Vedra {

    public static void main(String[] args) {

        int amount = new Random().nextInt(200);

        List<Integer> volumes = Arrays.asList(10, 5, 2, 1);

        long start = System.nanoTime();
        List<Map<Integer, Integer>> variants = getVariants(amount, volumes);
        long finish = System.nanoTime();


        for (Map<Integer, Integer> map : variants) {
            for (Map.Entry<Integer, Integer> solution : map.entrySet()) {
                System.out.print(solution.getKey() + " л - " + solution.getValue() + " шт, ");
            }
            System.out.println();
        }

        System.out.println("For amount = " + amount + " total variants = " + variants.size());
        System.out.println("time = " + (finish - start) + " nano seconds");

    }

    public static List<Map<Integer, Integer>> getVariants(int amount, List<Integer> volumes) {

        if (amount < 0) throw new NegativeAmountException();

        if (amount == 0) throw new NullAmountException();

        if (amount < Collections.min(volumes)) throw new NoProperFillingException();

        List<Map<Integer, Integer>> solutions = new ArrayList<>();

        Map<Integer, Integer> solution = new HashMap<>();

        calculate(amount, volumes, solutions, solution);

        if (solutions.size() == 0) throw new NoProperFillingException();

        return solutions;
    }

    private static void calculate(int amount, List<Integer> volumes,
                                  List<Map<Integer, Integer>> solutions,
                                  Map<Integer, Integer> solution) {

        Integer firstVolume = volumes.get(0);

        if (volumes.size() == 1) {
            if (amount % firstVolume == 0) {
                solution.put(firstVolume, amount / firstVolume);
                solutions.add(solution);
            }

        } else if (volumes.size() > 1) {

            if (amount >= Collections.min(volumes)) {

                List<Integer> nextVolumes = volumes.subList(1, volumes.size());

                for (int i = amount / firstVolume; i >= 0; i--) {

                    Map<Integer, Integer> nextSolution = new HashMap<>(solution);

                    nextSolution.put(firstVolume, i);

                    int nextAmount = amount - i * firstVolume;

                    calculate(nextAmount, nextVolumes, solutions, nextSolution);
                }
            }
        }
    }
}

