package com.sort.insert;

/**
 * Created by Feng on 2017/3/13.
 * 折半插入排序
 */

import java.util.*;

public class BinaryInsertSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//数组的大小
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }

            binaryInsertSort(A, n);
        }
    }

    public static void binaryInsertSort(int[] A, int n) {
        for (int i = 1; i < n; i++) {
            int temp = A[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (high + low) / 2;//找到中间位置
                if (temp < A[mid]) {
                    //到小于mid的部分去找
                    high = mid - 1;
                } else {
                    //到大于mid的部分去找
                    low = mid + 1;
                }
            }

            for (int j = i; j > low; j--) {
                A[j] = A[j - 1];
            }

            A[low] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(A[i]);
            if (i != n - 1) {
                System.out.print(",");
            }
        }
    }
}

