package 排序;

/**
 * 先将待排序数组，通过insert一个一个插入，建堆，建完后再一个一个取出来
 */
public class HeapSort {

    /**
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; ++i)
            insert(array, i, array[i]);
        for (int i = array.length; i > 0; --i) {
            deleteMin(array, i);
        }
    }

    /**
     * array和length用于表示这个堆，data为插入元素
     * @param array
     * @param length
     * @param data
     */
    public static void insert(int[] array, int length, int data) {
        int hole = length++;
        for (; hole != 0 && array[(hole - 1) / 2] > data; hole = (hole - 1) / 2)
            array[hole] = array[(hole - 1) / 2];
        array[hole] = data;
    }

    /**
     * 将堆顶元素放到数组的最后一个，并维护这个堆
     *
     * @param array  表示堆的数组
     * @param length 未被移除堆的元素个数
     */
    public static void deleteMin(int[] array, int length) {
        int topElement = array[0];
        int lastElement = array[--length];
        int i, child;
        for (i = 0; i * 2 + 1 <= length; i = child) {
            child = i * 2 + 1;
            if (child != length && array[child] > array[child + 1])
                child++;
            if (array[child] < lastElement)
                array[i] = array[child];
            else
                break;
        }
        array[i] = lastElement;
        array[length] = topElement;
    }
}
