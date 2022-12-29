package com.algorithm.demo;

/**
 * @Description 使用运算符的一些事
 * @Author gongqiangwei
 * @Date 2022/12/29
 **/
public class OperatorClass {
    /**
     * 一个数组，只有一个数的数量是奇数，其余都是偶数，求这个数字是什么？
     * @param arr
     */
    public void first(int[] arr){
        int temp=0;
        for (int i : arr) {
            temp=temp^i;
        }
        System.out.println(temp);
    }

    /**
     * - 一个数组，只有二个数的数量是奇数，其余都是偶数，求这个两个数字是什么？
     * 1：全部异或，得到的值就是两个数的异或值。
     * 2：两个值，肯定有一个数不同（二进制），那么将数组中分成两组。数1在一组，数2在一组。其他数字都是偶数了，也就无所谓。
     * 3：将2中的结果在异或得到其中的一个数。将得到的数和1的结果异或，就是最后的结果了。
     * @param arr
     */
    public void two(int[] arr){
        int temp=0;
        for (int i : arr) {
            temp=temp^i;//现在temp就是两个数的异或
        }
        int temp2=0;
        //提取最右边的1出来
        int right=temp&(~temp+1);
        for (int i : arr) {
            if ((i&right)==0) {
                temp2=temp^i;
            }
        }
        System.out.println(temp2+":"+(temp^temp2));
    }

    public static void main(String[] args) {
        int[] arr={1,1,2,2,5,6,5,7};
        OperatorClass operatorClass=new OperatorClass();
        operatorClass.two(arr);
    }
}
