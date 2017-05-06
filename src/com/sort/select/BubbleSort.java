package com.sort.select;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/13.
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//数组大小
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }

            bubbleSort(A, n);
        }
    }

    private static void bubbleSort(int[] a, int n) {
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {//最多进行n-1趟
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {//将大的值放在后面
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
            if (i != n - 1) {
                System.out.print(",");
            }
        }
    }


}
