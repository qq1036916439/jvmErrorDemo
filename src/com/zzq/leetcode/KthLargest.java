package com.zzq.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    public Queue<Integer> q=null;
    int qsize=0;
    public KthLargest(int k, int[] nums) {
        q=new PriorityQueue(k);
        this.qsize=k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }

    public   int add(int val) {
        if(q.size()<qsize){
            q.add(val);
        }else{
            if(q.peek()<val){
                q.poll();
                q.offer(val);

            }
        }
        return q.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3,new int[]{4,5,8,3});

    }

}
