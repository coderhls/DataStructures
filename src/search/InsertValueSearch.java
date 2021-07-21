package search;

import java.util.Arrays;

/**
 * @className: InsertValueSearch
 * @author: coderhls
 * @date: 2021/7/21
 * @description: 插值查找法
 **/
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println(index);

    }

    /**
     * 插值查找算法
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param target 查找值
     * @return 找到返回下标，没找到返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int target) {
        if (left > right || target < arr[0] || target > arr[arr.length - 1]) return -1;

        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (target > midValue) return insertValueSearch(arr, mid + 1, right, target);
        else if (target < midValue) return insertValueSearch(arr, left, mid - 1, target);
        else  return mid;
    }
}
