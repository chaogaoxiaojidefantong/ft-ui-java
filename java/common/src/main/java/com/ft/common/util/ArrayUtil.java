package com.ft.common.util;

public class ArrayUtil {
    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    public   int[]  BubbleSort(int []arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=arr.length-1;j>i;j--){
                int item;
                if(arr[j]<arr[j-1]){
                    item=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=item;
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序
     * @param a 排序的集合
     * @param l 起始坐标，一般先为0
     * @param r 最后一个坐标，一般为length-1
     * @return
     */
    public   int [] quickSort(int a[],int l,int r){
        if(l>=r)
            return null;
        int i = l; int j = r; int key = a[l];//选择第一个数为key
        int g[]={42,20,17,13,28,14,23,15};
        while(i<j){
            while(i<j && a[j]>=key)//从右向左找第一个小于key的值
                j--;
            if(i<j){
                a[i] = a[j];
                i++;
            }
            while(i<j && a[i]<key)//从左向右找第一个大于key的值
                i++;
            if(i<j){
                a[j] = a[i];
                j--;
            }
        }
        //i == j
        a[i] = key;
        quickSort(a, l, i-1);//递归调用
        quickSort(a, i+1, r);//递归调用
        return a;
    }
}
