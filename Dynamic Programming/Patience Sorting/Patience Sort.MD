**Patience Sorting**

Patience sorting is a sorting algorithm inspired by the card game "Patience" (also known as Solitaire). The algorithm sorts a sequence of numbers by distributing them into piles using specific rules, and then merges the piles to produce a sorted sequence. The main steps of patience sorting are:

1. **Piling:** Distribute the numbers into piles such that each pile remains sorted. A number can either start a new pile or be placed on top of an existing pile where it is greater than or equal to the top card of that pile.
2. **Merging:** Merge the piles into a single sorted sequence.

```
private static int patienceSorting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
      
        List<Integer> piles = new ArrayList<>();
      
        for (int num : nums) {
            int position = Collections.binarySearch(piles, num);
            if (position < 0) {
                position = -(position + 1);
            }
            if (position == piles.size()) {
                piles.add(num);
            } else {
                piles.set(position, num);
            }
        }
      
        return piles.size();
    }
```

The algorithm is useful for finding the Longest Increasing Subsequence (LIS) in O(n log n) time.

### 20 LeetCode Problems Related to Patience Sorting

1. [#300 Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
2. [#354 Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/)
3. [#1671 Minimum Number of Removals to Make Mountain Array](https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/)
4. [#1713 Minimum Operations to Make a Subsequence](https://leetcode.com/problems/minimum-operations-to-make-a-subsequence/)
5. [#1626 Best Team With No Conflicts](https://leetcode.com/problems/best-team-with-no-conflicts/)
6. [#673 Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)
7. [#764 Largest Plus Sign](https://leetcode.com/problems/largest-plus-sign/)
8. [#1964 Find the Longest Valid Obstacle Course at Each Position](https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/)
9. [#1340 Jump Game V](https://leetcode.com/problems/jump-game-v/)
10. [#630 Course Schedule III](https://leetcode.com/problems/course-schedule-iii/)
11. [#1906 Minimum Absolute Difference Queries](https://leetcode.com/problems/minimum-absolute-difference-queries/)
12. [#1125 Smallest Sufficient Team](https://leetcode.com/problems/smallest-sufficient-team/)
13. [#940 Distinct Subsequences II](https://leetcode.com/problems/distinct-subsequences-ii/)
14. [#1765 Map of Highest Peak](https://leetcode.com/problems/map-of-highest-peak/)
15. [#1712 Ways to Split Array Into Three Subarrays](https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/)
16. [#1473 Paint House III](https://leetcode.com/problems/paint-house-iii/)
17. [#1312 Minimum Insertion Steps to Make a String Palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)
18. [#1192 Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/)
19. [#1658 Minimum Operations to Reduce X to Zero](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/)
20. [#354 Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/)

These problems often utilize the principles of patience sorting, especially for finding subsequences or dealing with interval-based problems.
