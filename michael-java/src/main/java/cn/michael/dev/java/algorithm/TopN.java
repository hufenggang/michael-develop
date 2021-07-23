package cn.michael.dev.java.algorithm;

/**
 * Created by hufenggang on 2021/7/21.
 *
 * 10亿数据找出前100大的数据
 *
 * 实现思路
 * 基于堆排实现：
 * 1. 获取前N个数，建立一个小根堆，建堆的时间复杂度为O(nlogn)
 * 2. 顺序读取后边的元素，如果该元素比堆顶的元素小，直接丢弃，如果大于堆顶的元素则替换它，然后调整堆，最坏的情况是每一次都需要调整堆。
 * 时间复杂度为O(mlogn)。m为数据总数，n表示前n大的数。
 */
public class TopN {
}
