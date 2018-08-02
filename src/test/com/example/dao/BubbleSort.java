package com.example.dao;

import java.util.Arrays;

/**
 * @author LiGuanglong
 * @date 2018/8/2
 */
public class BubbleSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = getPartion(a, low, high);
        quickSort(a, low, index-1);
        quickSort(a, index + 1, high);
    }

    public static void swap(int[] a, int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    private static int getPartion(int[] a, int low, int high) {
        int ketNum = a[low];

        while (low < high) {
            while (a[high] >= ketNum && low < high) {
                high--;
            }
            if (a[high] < ketNum) {
                swap(a, high, low);
            }

                while (a[low] <= ketNum && low < high) {
                low++;
            }
            if (a[low] > ketNum) {
                swap(a, low, high);
            }
        }
        return high;
    }

    public static void main(String[] args) {
        //冒泡排序
//        int[] a = {2, 5, 6, 1, 3, 8, 2};
//        sort(a);

        //快速排序
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49};
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
