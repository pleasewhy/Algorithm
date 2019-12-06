package 排序;


/**
 * 归并排序
 * <p>
 * 利用二分的思想，要将当前序列排序，先将左半边序列和右半边序列排好序，直到
 * 序列的长度小于等于2，这样做是因为对于两个有序序列合并成一个有序数列的时间
 * 复杂度为O(M+N)，M和N为两个序列的长度。而对于整个序列的合并的时间为O(N)，
 * 且需要O(logN)的次数，所以总的复杂度为O(NlogN)
 */
public class MergeSort {

    static int temp;
    static int[] tempArr;
    static int i, j, k;

    public static void sort(int[] array) {
        tempArr = new int[array.length];
        mergeSort(array, 0, array.length);
    }

    private static void merge(int[] array, int start1, int end1, int start2, int end2) {
        i = start1;
        j = start2;
        k = 0;
        while (i < end1 && j < end2) {
            if (array[i] > array[j]) {
                tempArr[k++] = array[i++];
            } else {
                tempArr[k++] = array[j++];
            }
        }
        while (i < end1) {
            tempArr[k++] = array[i++];
        }
        while (j < end2) {
            tempArr[k++] = array[j++];
        }

        k = 0;
        int len = end2 - start1;
        while (k < len) {
            array[start1++] = tempArr[k++];
        }
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (end - start <= 2) {
            if (array[start] < array[end - 1]) {
                temp = array[start];
                array[start] = array[end - 1];
                array[end - 1] = array[temp];
            }
            return;
        }

        mergeSort(array, start, (start + end) / 2);
        mergeSort(array, (start + end) / 2, end);
        merge(array, start, (start + end) / 2, (start + end) / 2, end);
    }
}
