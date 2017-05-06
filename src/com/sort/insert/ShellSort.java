package com.sort.insert;

/**
 * 希尔排序
 */

import java.util.*;

public class ShellSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//数组大小
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }

            shellSort(A, n);
        }
    }

    public static void shellSort(int[] A, int n) {
        int step = n;//步长
        while (true) {
            for (int i = 0; i < step; i++) {//步长变化
                for (int j = i; j + step < n; j += step) {
                    int temp;
                    if (A[j] > A[j + step]) {
                        temp = A[j];
                        A[j] = A[j + step];
                        A[j + step] = temp;
                    }
                }
            }
            if (step == 1) {
                break;
            }
            step--;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(A[i]);
            if (i != n - 1) {
                System.out.print(",");
            }
        }
    }
}
