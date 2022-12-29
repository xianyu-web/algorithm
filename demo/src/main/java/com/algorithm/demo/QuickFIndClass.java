package com.algorithm.demo;

/**
 * @Description 查找相关的类：二分
 * @Author gongqiangwei
 * @Date 2022/12/29
 **/
public class QuickFIndClass {
    /**
     * 二分： 题目一：一个有序数组，找到指定数字的下标位置。
     * 注意下：tempindex的取值，是计算出中间值后+beginIndex的值
     * 然后在重新计算beginInde和endIndex时需要+1和减-1开始计算。
     *
     * @param arr
     */
    public void first(int[] arr, int num) {
        if (arr.length == 1) {
            if (num == arr[0]) {
                System.out.println(0);
                return;
            }
            System.out.println("no result");
            return;
        }
        int beginIndex = 0;
        int endIndex = arr.length - 1;
        while (true) {
            int tempIndex = (endIndex - beginIndex) / 2 + beginIndex;
            if (arr[tempIndex] == num) {
                System.out.println(tempIndex);
                return;
            }
            if (beginIndex == endIndex) {
                System.out.println("no result");
                return;
            }
            if (arr[tempIndex] > num) {
                endIndex = tempIndex - 1;
            } else {
                beginIndex = tempIndex + 1;
            }
        }

    }

    /**
     * 二分： 一个有序数组，找到大于等于n（数字），最左边的一个值。
     * 还是利用二分的思想去做。二分后，判断结果是否大于等于n，如果是，将左边和中间值继续二分。如果不是，将右边那段二分，
     * 一直到二分结束。那么第一个值就是符合条件的最左值。
     *
     * @param arr
     */
    public void two(int[] arr, int num) {
        int beginIndex = 0;
        int endIndex = arr.length - 1;
        while (true) {
            int tempIndex = (endIndex - beginIndex) / 2 + beginIndex;
            if (arr[tempIndex] >= num) {
                //左边那段继续分页
                endIndex = tempIndex;
            } else {
                //右边那段继续分页
                beginIndex = tempIndex + 1;
            }
            if (endIndex == beginIndex) {
                if (arr[endIndex] == num) {
                    System.out.println(beginIndex);
                    return;
                } else {
                    System.out.println("no result");
                    return;
                }
            }
        }
    }

    /**
     * 一个无序数组，找到其中一个最小中间数，要求时间复杂度小于O(N)
     * leetcode上的一到题目，其实可以直接一次循环解决，这样的话，时间复杂度是O(N)。
     * 先判断下第一位和最后一位，如果满足条件直接返回。
     * 不满足条件，那么这个数组从开始是arr[0]<arr[1]并且a[n-1]<arr[n-2] .那么中间一定会存在最小中间数（理解成一条线，将数字大小用线链接起来）
     * 然后直接进行二分。判断当前二分的结果，不满足，那么左边或者右边一定是存在满足条件的数。
     * @param arr
     */
    public void three(int[] arr) {
        if (arr.length<2){
            System.out.println("arr 不符合条件");
            return;
        }
        int beginIndex=0;
        int endIndex=arr.length-1;
        if (arr[0]<arr[1]) {
            System.out.println(0);
            return;
        }
        if (arr[arr.length-1]<arr[arr.length-2]) {
            System.out.println(arr[arr.length-1]);
            return;
        }
        while (true) {
            int tempIndex = (endIndex - beginIndex) / 2 + beginIndex;
            if (arr[tempIndex]<arr[tempIndex-1]&&arr[tempIndex]<arr[tempIndex+1]) {
                System.out.println(tempIndex);
                return;
            }
            if (arr[tempIndex]>=arr[tempIndex-1]) {
                //左边的继续二分
                endIndex=tempIndex-1;

            }
           else  if (arr[tempIndex]>=arr[tempIndex+1]) {
                //右边的继续二分
                beginIndex=tempIndex+1;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {6,  5,5, 4,6, 7, 8, 9, 11};
        QuickFIndClass quickFIndClass = new QuickFIndClass();
        quickFIndClass.three(arr);
    }
}
