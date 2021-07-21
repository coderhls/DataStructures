package sort;

import java.util.Arrays;

/**
 * @className: SelectSort
 * @author: coderhls
 * @date: 2021/6/16
 * @description: 选择排序
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.print("排序前：");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);

        System.out.print("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                // 说明假定的最小值，并不是最小
                if (min > arr[j]) {
                    // 重置min值
                    min = arr[j];
                    // 重置minIndex值
                    minIndex = j;
                }
            }

            // 将最小值，放在arr[0]，即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
