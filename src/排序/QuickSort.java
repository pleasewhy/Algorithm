package 排序;

public class QuickSort {
    public static void sort(int[] array){
        qsort(array,0, array.length);
    }
    public static void qsort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int i = start;
        int j = end - 1;
        int base = array[start];
        while (i < j) {
            while (i < j && array[j] <= base)
                j--;
            while (i < j && array[i] >= base)
                i++;
            if (i < j)
                swap(array, i, j);
        }
        swap(array, start, i);
        qsort(array, start, i - 1);
        qsort(array, i + 1, end);
    }

    static int temp;

    private static void swap(int[] arr, int a, int b) {
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
