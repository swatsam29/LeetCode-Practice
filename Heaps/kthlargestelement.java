package Heaps;

import java.util.PriorityQueue;

public class kthlargestelement {
    class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for(int i: nums){
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        return minHeap.remove();    
    }
}
}
