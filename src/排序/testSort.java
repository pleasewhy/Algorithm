package 排序;

import java.util.Arrays;
import java.util.Random;

public class testSort {

    /**
     *  MAXSIZE 待排序数组的长度
     *  RATE将时间换算为ms
     */
    static int MAXSIZE = 10_000_000;
    static int RATE = 1_000_000;

    public static int[] randomArray(int len) {
        int[] randomArr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; ++i) {
            randomArr[i] = random.nextInt(len);
        }
        return randomArr;
    }

    public static void main(String[] args) {
        int[] randomArr;

        // 系统排序
        randomArr = randomArray(MAXSIZE);
        long a = System.nanoTime();
        Arrays.sort(randomArr);
        System.out.println("Java库函数 " + (System.nanoTime() - a) / RATE + " ms");

        // 堆排序
        randomArr = randomArray(MAXSIZE);
        a = System.nanoTime();
        HeapSort.sort(randomArr);
        System.out.println("推排序：" + (System.nanoTime() - a) / RATE + " ms");

        // 快速排序
        randomArr = randomArray(MAXSIZE);
        a = System.nanoTime();
        QuickSort.sort(randomArr);
        System.out.println("快速排序：" + (System.nanoTime() - a) / RATE + " ms");

        // 插入排序
        randomArr = randomArray(1000);
        a = System.nanoTime();
        InsertSort.sort(randomArr);
        System.out.println("插入排序（数据较少）" + (System.nanoTime() - a) / RATE + " ms");

        // 归并排序
        randomArr = randomArray(MAXSIZE);
        a = System.nanoTime();
        MergeSort.sort(randomArr);
        System.out.println("归并排序：" + (System.nanoTime() - a) / RATE + " ms");


//        randomArr = randomArray(10);
//        MergeSort.sort(randomArr);
//        for (int i : randomArr
//        ) {
//            System.out.print(i + " ");
//        }
    }
}
