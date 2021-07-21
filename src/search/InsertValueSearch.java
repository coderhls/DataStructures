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
        System.out.println(Arrays.toString(arr));
    }
}
