package ivan.boiko.algorithms.filling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int FIVE = 5;
    private static final int TEN = 10;

    public static void main(String[] args) {

        int amount = 57;
//        int amount = new Random().nextInt(100);

        long begin = System.nanoTime();

//        countOptionsToFillVolume(amount);
        List<Map<Integer, Integer>> variants = countOptionsToFillVolume(amount);

        System.out.println("time = " + (System.nanoTime() - begin));

//        Collections.sort(variants, new Comparator<Map<Integer, Integer>>() {
//            @Override
//            public int compare(Map<Integer, Integer> o1, Map<Integer, Integer> o2) {
//
//                if (o1.get(ONE) != o2.get(ONE)){
//                    return  -(o1.get(ONE) - o2.get(ONE));
//
//                } else if (o1.get(TWO) != o2.get(TWO)){
//                    return  -(o1.get(TWO) - o2.get(TWO));
//
//                } else if (o1.get(FIVE) != o2.get(FIVE)){
//                    return  -(o1.get(FIVE) - o2.get(FIVE));
//
//                } else return -(o1.get(TEN) - o2.get(TEN));
//            }
//        });


        for (Map<Integer, Integer> map : variants) {

            for (Map.Entry<Integer, Integer> solution : map.entrySet()) {
                System.out.print(solution.getKey() + " л - " + solution.getValue() + " шт, ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Итого, при n = " + amount + " наш ответ будет = " + variants.size());


    }

    //    private static void countOptionsToFillVolume(int volume) {
    private static List<Map<Integer, Integer>> countOptionsToFillVolume(int volume) {

        List<Map<Integer, Integer>> solutions = new ArrayList<>();

        if (volume >= 0 && volume <= 200) {

            int count = 0;

            for (int i = volume / ONE; i >= 0; i--) {

                for (int j = volume / TWO; j >= 0; j--) {

                    for (int k = volume / FIVE; k >= 0; k--) {

                        for (int l = volume / TEN; l >= 0; l--) {

                            if (ONE * i + TWO * j + FIVE * k + TEN * l == volume) {

                                Map<Integer, Integer> solution = new HashMap<>();
                                solution.put(ONE, i);
                                solution.put(TWO, j);
                                solution.put(FIVE, k);
                                solution.put(TEN, l);

                                solutions.add(solution);

//                                System.out.println(count + 1 + ") " + l + " по 10л + " + k + " по 5л + " + j + " по 2л + " + i + " по 1л" + "\n");
                                count++;
                            }
                        }
                    }
                }
            }
//            System.out.println("Итого, при n = " + volume + " наш ответ будет = " + count);
            return solutions;

        } else {
//            System.out.println("invalid value of volume: " + volume);
            return solutions;
        }
    }
}
