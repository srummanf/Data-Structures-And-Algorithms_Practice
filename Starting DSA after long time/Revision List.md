# 📘 DSA Cheat Sheet

- [📘 DSA Cheat Sheet](#-dsa-cheat-sheet)
  - [🔹 Two Pointers and Sliding Window](#-two-pointers-and-sliding-window)

---

## 🔹 Two Pointers and Sliding Window
| Problem                                        | Link                                                                                        | Intuition (3–4 lines)                                                                                                                                                         | Key Steps / Notes                                                                 | Company      |
| ---------------------------------------------- | ------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | ------------ |
| Longest Subarray With Sum ≤ K                  | *(Add your link)*                                                                           | Use sliding window: keep expanding `r` while sum ≤ K. If sum > K, shrink from `l`. Always track max length of valid window.                                                   | Maintain running sum, expand/shrink window, maximize window length                | Amazon, Uber |
| Maximum Points You Can Obtain from Cards       | [LeetCode 1423](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)    | Pick cards from either left or right. Precompute sum of first `k` cards, then slide window by removing one from left and adding from right. Keep max of `leftSum + rightSum`. | Precompute `leftSum`, use two pointers `(l = k-1, r = n-1)`, update max each step | Google       |
| Longest Substring Without Repeating Characters | [LeetCode 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Use window `[l, r]` with hashmap storing last seen index. If `s[r]` repeats, move `l` past its last index. Window always has unique chars, update max length.                 | HashMap for last index, expand `r`, adjust `l` on duplicate, track max length     | Microsoft    |
| Reverse Vowels of a String | [LeetCode 345](https://leetcode.com/problems/reverse-vowels-of-a-string/) | Use two pointers from both ends of the string. Skip non-vowels, and when both pointers are at vowels, swap them. Continue until pointers meet to get the reversed vowels string. | Convert to char array - Use two pointers (l, r) - Skip non-vowels - Swap vowels - Return new string | Google, Zoho, Flipkart |

