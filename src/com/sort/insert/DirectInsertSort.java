package com.sort.insert;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/13.
 * 直接插入排序
 */
public class DirectInsertSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//数组大小
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            directInsertSort(A, n);
        }
    }

    public static void directInsertSort(int[] A, int n) {
        for (int i = 1; i < n; i++) {
            //第0位独自作为有序数列，从第1位开始向后遍历
            //0~i-1位为有序，若第i位小于i-1位，继续寻位并插入，
            //否则认为0~i位也是有序的，忽略此次循环，相当于continue
            if (A[i] < A[i - 1]) {
                int temp = A[i];//保存第i位的值
                int k = i - 1;
                for (int j = k; j >= 0 && temp < A[j]; j--) {
                    //从第i-1位向前遍历并移位，直至找到小于第i位值停止
                    A[j + 1] = A[j];
                    k--;
                }
                A[k + 1] = temp;//插入第i位的值
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(A[i]);
            if (i != n - 1) {
                System.out.print(",");
            }
        }
    }
}