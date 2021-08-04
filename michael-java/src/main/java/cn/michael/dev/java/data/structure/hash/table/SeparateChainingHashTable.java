package cn.michael.dev.java.data.structure.hash.table;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hufenggang on 2021/8/3.
 * <p>
 * 分离链接散列表的实现
 */
public class SeparateChainingHashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 101;

    // The array of list.
    private List<AnyType>[] theLists;
    private int currentSize;

    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size) {
        this.currentSize = size;
    }

    public void insert(AnyType x) {
        List<AnyType> whichList = theLists[myHash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);
        }
    }

    /**
     * hash函数
     *
     * @param x
     * @return
     */
    private int myHash(AnyType x) {
        int hashVal = x.hashCode();
        hashVal %= theLists.length;
        if (hashVal < 0) {
            hashVal += theLists.length;
        }
        return hashVal;
    }

    /**
     * 获取该数字下一个相邻的最小素数
     *
     * @param n
     * @return
     */
    private int nextPrime(int n) {
        if (n % 2 == 0) {
            n++;
        }

        for (; !isPrime(n); n += 2) {
        }

        return n;
    }

    /**
     * 测试数据是否为素数的内部方法
     *
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }

        if (n == 1 || n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
