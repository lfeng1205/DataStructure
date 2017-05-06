package com.sort.select;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/14.
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//数组大小
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }

            int low = 0;
            int high = A.length - 1;
            quickSort(A, low, high);

            for (int i = 0; i < n; i++) {
                System.out.print(A[i]);
                if (i != n - 1) {
                    System.out.print(",");
                }
            }
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low > high) {
            return;
        }

        int index = partition(a, low, high);//划分操作，将表分为两个表
        quickSort(a, low, index - 1);//依次对两个表进行递归排序
        quickSort(a, index + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        //选取一个元素作为基准
        int key = a[low];
        while (low < high) {//循环条件
            while (a[high] >= key && high > low) {//从后半部分扫描
                high--;
            }
            a[low] = a[high];//将比枢纽值小的元素移到左端

            while (a[low] <= key && low < high) {//从前半部分向后扫描
                low++;
            }
            a[high] = a[low];//将比枢纽值大的元素移到右端
        }

        a[low] = key;//枢纽元素存放到最终位置

        return low;
    }
}
