package 排序;

import java.util.Arrays;
import java.util.Random;

public class testSort {
    public static int[] randomArray(int len) {
        int[] randomArr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; ++i) {
            randomArr[i] = random.nextInt(len);
        }
        return randomArr;
    }

    public static void main(String[] args) {
        int[] randomArr = randomArray(1000000);
        long a = System.nanoTime();
        HeapSort.sort(randomArr);
        System.out.println((System.nanoTime() - a) / 1_000_000);

        randomArr = randomArray(1000000);
        a = System.nanoTime();
        QuickSort.sort(randomArr);
        System.out.println((System.nanoTime() - a) / 1_000_000);
        randomArr = randomArray(10);
        QuickSort.sort(randomArr);
        for (int i:randomArr
             ) {
            System.out.print(i + " ");
        }
    }
}
