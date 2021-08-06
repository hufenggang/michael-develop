package cn.michael.dev.java.data.structure.heap;

/**
 * Created by hufenggang on 2021/8/6.
 */
public class MinBinaryHeap<AnyType extends Comparable<? super AnyType>> {
    // 默认容器大小
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private AnyType[] array;

    public MinBinaryHeap() {
    }

    public void insert(AnyType x) {

        // 扩容
        if (currentSize == array.length - 1) {

        }

        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }
}
