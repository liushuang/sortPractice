package ren.liushuang.sort;

import java.util.List;

/**
 * 堆排序
 *
 * @author liushuang
 * @create 2017-11-06 PM6:09
 */
public class HeapSort {

    public static void sort(List<Integer> data) {
        // 构造大顶堆
        buildHeap(data);
        for (int length = data.size() -1; length >= 0; length--) {
            swap(data, 0, length);
            // 调整堆
            adjustHeap(data, 0, length);
        }
    }

    private static void adjustHeap(List<Integer> data, int i, int length) {
        int largest = compareAndSwap(data, i, length);
        if (largest != i) {
            adjustHeap(data, largest, length);
        }
    }

    private static void buildHeap(List<Integer> data) {
        int startIndex = (data.size() - 2) /2;
        for (int i = startIndex; i >= 0; i--) {
            // 调整节点和对应的两个子节点
            adjustHeap(data, i, data.size());
        }
    }

    private static int compareAndSwap(List<Integer> data, int i, int length) {
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int largest = i;
        if (leftChild < length && data.get(leftChild) > data.get(largest)) {
            largest = leftChild;
        }
        if (rightChild < length && data.get(rightChild) > data.get(largest)) {
            largest = rightChild;
        }
        if (largest != i) {
            swap(data, largest, i);
        }
        return largest;
    }

    private static void swap(List<Integer> data, int a, int b) {
        int temp = data.get(a);
        data.set(a, data.get(b));
        data.set(b, temp);
    }
}
