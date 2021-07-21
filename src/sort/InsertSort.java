package sort;

import java.util.Arrays;

/**
 * @className: InsertSort
 * @author: coderhls
 * @date: 2021/6/16
 * @description: 插入排序
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort(arr);
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的数
            int insertVal = arr[i];
            // arr[1] 的前面一个数的下标
            int insertIndex = i - 1;
            // insertIndex >= 0保证给insertVal找插入位置，不越界
            // insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 将arr[insertIndex]后移
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 退出循环，找到插入的位置，insertIndex + 1
            arr[insertIndex + 1] = insertVal;
            System.out.println("第" + i + "轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }
}
