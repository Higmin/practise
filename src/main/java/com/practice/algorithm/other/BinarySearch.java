package com.practice.algorithm.other;

/**
 * 请实现有重复数字的有序数组的二分查找。
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 *
 * 输入：5,4,[1,2,4,4,5]
 * 返回值：3
 *
 * 说明：输出位置从1开始计算
 *
 * @author Jimmy
 * @version 1.0, 2021/04/08
 * @since practice 1.0.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(upper_bound_(11, 5, new int[]{1, 2, 3, 4, 4, 4, 5, 5 ,6, 7, 8}));
        System.out.println(upper_bound_(9, 5, new int[]{1, 2, 3, 4, 4, 4, 6, 7, 8}));
        System.out.println(upper_bound_(9, 9, new int[]{1, 2, 3, 4, 4, 4, 6, 7, 8}));
    }

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_(int n, int v, int[] a) {
        // write code here
        if (n <= 0) {
            return 1;
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (v == a[mid]) {
                if (mid == 0 || a[mid - 1] < v) {
                    return mid;
                }
            } else if (v < a[mid]) {
                right = mid - 1;
            } else if (a[mid] < v) {
                left = mid + 1;
            }
        }

        if (right < n - 1 && a[right + 1] > v) {
            return right + 1;
        }

        return n + 1;
    }
}
