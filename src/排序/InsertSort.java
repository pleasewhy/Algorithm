package 排序;


/**
 * 插入排序
 *
 * 将当前元素向前依次比较，得到当前元素的插入位置，并交换
 *
 * @author hy
 */
public class InsertSort {
    public static void sort(int[] array) {
        int hole, temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            hole = i;
            for (; hole != 0 && array[hole - 1] < temp; --hole) {
                array[hole] = array[hole - 1];
            }
            array[hole] = temp;
        }
    }

}
