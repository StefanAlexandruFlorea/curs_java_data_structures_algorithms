package datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 2, 5, 1, 0, 11, 6};
        List<Integer> result = streamMax(nums);
// Expected output: [10, 10, 10, 10, 10, 11, 11]

        System.out.println(result);
    }

    public static int findKthSmallest(int[] nums, int k) {
        Heap heap = new Heap();

        for (int i : nums) {
            heap.insert(i);
            if (heap.getHeap().size() > k) heap.remove();
        }

        return heap.remove();
    }

    public static List<Integer> streamMax(int[] nums){
        List<Integer> result = new ArrayList<>();
        Heap heap = new Heap();

        for(int i : nums){
            heap.insert(i);
            result.add(heap.getHeap().get(0));
        }

        return result;
    }
}
