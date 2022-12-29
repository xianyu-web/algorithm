package com.algorithm.demo;

import java.nio.channels.SelectionKey;

/**
 * @Description 排序相关的类：冒泡，选择，插入
 * @Author gongqiangwei
 * @Date 2022/12/29
 **/
public class SortClass {

    /**
     * 冒泡排序：最大值放到右边，小值相对左边移动，每循环一次，确定最大值。依次确定 n-1,[n-2,n-1],[n-3,n-1].......[0,n-1]的排序。
     * @param arr
     */
    public void bubblingSort(int[] arr){
        if (arr.length<=1) {
            printArr(arr);
            return;
        }
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }
        printArr(arr);
    }

    /**
     * 选择排序：每次将最小值放到最右边，依次确定 0,[0,1],[0,2].....【0,n-1]的排序。
     * @param arr
     */
    public void selectSort(int[] arr){
        if (arr.length<=1) {
            printArr(arr);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]) {
                    swap(arr,i,j);
                }
            }
        }
        printArr(arr);
    }

    /**
     * 插入排序：依次确认0，[0,1],[0,2]。。。[0,n-1]的排序，但是这个和冒泡以及选择不同。
     * @param arr
     */
    public void insertSort(int[] arr){

    }
    public static void main(String[] args) {
        int[] arr={1,2,9,9,8,2,4,7,3,9,3,4,2,5};
        SortClass sortClass=new SortClass();
        sortClass.bubblingSort(arr);
    }

    /**
     * 交换i和j的位置值
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
