package datastructures.hashtable;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 3};
        int target = 3;

        System.out.println(Arrays.toString(subarraySum(new int[]{3, 1, 2, 3}, 3)));

    }

    //LeetCode
    public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> sumAndIndex = new HashMap<>();
        sumAndIndex.put(0, -1); // first sum in map is 0, index -1,  in case first no in nums is the target sum return map.get(0) +1 ==> index 0

        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int complement = currentSum - target;

            if (sumAndIndex.containsKey(complement)) {
                return new int[]{sumAndIndex.get(complement) + 1, i};
            }
            sumAndIndex.put(currentSum, i);

        }
        return new int[]{};
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(num, i);
            }

        }
        return new int[]{};
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strings) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String canonical = new String(chars);

            if (anagramGroups.containsKey(canonical)) {
                anagramGroups.get(canonical).add(str);
            } else {
                List<String> group = new ArrayList<>();
                group.add(str);
                anagramGroups.put(canonical, group);
            }
        }
        return new ArrayList<>(anagramGroups.values());
    }

    public static List<List<String>> groupAnagramsFrequency(String[] strings) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String s : strings) {
            // find the frequency of each letter in s
            int[] frequencyArray = new int[26];
            for (char c : s.toCharArray()) {
                frequencyArray[c - 'a']++;
            }
            String frequencyString = Arrays.toString(frequencyArray);

            // check if the map contains key frequencyString
            if (anagramGroups.containsKey(frequencyString)) {
                anagramGroups.get(frequencyString).add(s);
            } else {
                List<String> anagramsList = new ArrayList<>();
                anagramsList.add(s);
                anagramGroups.put(frequencyString, anagramsList);
            }
        }
        return new ArrayList<>(anagramGroups.values());
    }


    public static Character firstNonRepeatingChar(String str) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (charCounts.get(c) == 1) return c;
        }

        return null;
    }

    public static boolean itemInCommon(int[] arr1, int[] arr2) {
        HashMap<Integer, String> map = new HashMap<>();

        for (int i : arr1) {
            map.put(i, "");
        }

        for (int i : arr2) {
            if (map.get(i) != null) return true;
        }
        return false;
    }

    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Integer> numCounts = new HashMap<>();

        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }

        for (int num : numCounts.keySet()) {
            int value = numCounts.get(num);
            if (value > 1) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

}
