package datastructures.binarysearchtree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(27);
        bst.insert(52);
        bst.insert(82);

        System.out.println(bst.breadthFirstSearch());
    }

    //LeetCode

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int count = 0;
        int maxCount = 0;

        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int currentNum = n;
                count = 1;

                while (set.contains(currentNum + 1)) {
                    count++;
                    currentNum++;
                }

                maxCount = Math.max(maxCount,count);

            }
        }

        return maxCount;
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> set = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();

        for (int n : arr1) {
            set.add(n);
        }
        for (int n : arr2) {
            int complement = target - n;
            if (set.contains(complement)) {
                pairs.add(new int[]{n, complement});
            }
        }
        return pairs;
    }

    public static boolean hasUniqueChars(String str) {
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();

        for (char c : chars) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    public static List<Integer> removeDuplicates(List<Integer> myList) {
        Set<Integer> set = new HashSet<>(myList);
        return new ArrayList<>(set);
    }
}
