# 📘 DSA Cheat Sheet

This document is a structured collection of Data Structures and Algorithms (DSA) concepts, problems, and solutions.
It is designed to be a quick reference guide for interview preparation, competitive programming, and revision.

Each section contains:

- **Problem Name & Link** → Direct reference to the question.
- **Intuition** → Short explanation of the approach.
- **Key Steps / Notes** → Bullet-point steps to solve.
- **Company Tags** → Common companies where the problem has been asked.
- **Video Tutorials** → Video Solution of the problem.

Use this as a personal revision sheet while practicing coding problems.

- [📘 DSA Cheat Sheet](#-dsa-cheat-sheet)
  - [🔹 Two Pointers and Sliding Window](#-two-pointers-and-sliding-window)
  - [🔹 Testing](#-testing)

---

## 🔹 Two Pointers and Sliding Window

| Problem                                        | Link                                                                                     | Intuition (3–4 lines)                                                                                                                                                            | Key Steps / Notes                                                                                   | Company                | Video Tutorial                                                                                      |
| ---------------------------------------------- | ---------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | ---------------------- | --------------------------------------------------------------------------------------------------- |
| Longest Subarray With Sum ≤ K                 | ---                                                                                      | Use sliding window: keep expanding `r` while sum ≤ K. If sum > K, shrink from `l`. Always track max length of valid window.                                                  | Maintain running sum, expand/shrink window, maximize window length                                  | Amazon, Uber           | *---*                                                                                             |
| Maximum Points You Can Obtain from Cards       | [LeetCode 1423](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)    | Pick cards from either left or right. Precompute sum of first `k` cards, then slide window by removing one from left and adding from right. Keep max of `leftSum + rightSum`. | Precompute `leftSum`, use two pointers `(l = k-1, r = n-1)`, update max each step               | Google                 | [Striver](https://www.youtube.com/watch?v=pBWCOCS636U&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=2) |
| Longest Substring Without Repeating Characters | [LeetCode 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Use window `[l, r]` with hashmap storing last seen index. If `s[r]` repeats, move `l` past its last index. Window always has unique chars, update max length.               | HashMap for last index, expand `r`, adjust `l` on duplicate, track max length                   | Microsoft              | [Striver](https://youtu.be/-zSxTJkcdAo?si=tHnN2i8U9vnm9F7h)                                            |
| Reverse Vowels of a String                     | [LeetCode 345](https://leetcode.com/problems/reverse-vowels-of-a-string/)                   | Use two pointers from both ends of the string. Skip non-vowels, and when both pointers are at vowels, swap them. Continue until pointers meet to get the reversed vowels string.  | Convert to char array - Use two pointers (l, r) - Skip non-vowels - Swap vowels - Return new string | Google, Zoho, Flipkart | [CodeStoryWithMIK](https://youtu.be/pqzvpK8zTHU?si=YcEs1Uh80bE0YYlj)                                   |
| Max Consecutive Ones III | [LeetCode 1004](https://leetcode.com/problems/max-consecutive-ones-iii/) | Use sliding window to maximize subarray length by flipping at most `k` zeros. Maintain left pointer when zero count exceeds `k`. | - Expand right pointer- Count zeros- Shrink from left when count > k- Track max window size | Amazon, Google, Microsoft, Facebook | [Striver](https://www.youtube.com/watch?v=3E4JBHSLpYk&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=4&pp=iAQB) |
| Get Equal Substrings Within Budget | [LeetCode 1208](https://leetcode.com/problems/get-equal-substrings-within-budget/) | Use sliding window to maximize substring length where cost ≤ maxCost. Expand the window with right pointer, shrink from left when cost exceeds budget. Keep track of longest valid substring. | Expand right pointer and add diff to cost. Shrink left if cost > maxCost. Track max window length | Amazon, Bloomberg, Microsoft | [CodeStoryWithMIK](https://www.youtube.com/watch?v=MF2MgJQuFhA&pp=ygUiZ2V0IGVxdWFsIHN1YnN0cmluZ3Mgd2l0aGluIGJ1ZGdldA%3D%3D) |
| Remove Duplicates from Sorted Array | [LeetCode 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Use two pointers to overwrite duplicates in-place. One pointer scans the array while the other keeps track of the position for unique elements. Final index gives count of unique numbers. | Initialize two pointers (i, j). Move j forward. If nums[i] != nums[j], increment i and copy nums[j]. Return i+1 as new length. | Google, Amazon, Microsoft | [CodeStoryWithMIK](https://youtu.be/06ALbFrgIoQ?si=_Y3SjM6wjA0BsysP) |
| Reverse Words in a String | [LeetCode 151](https://leetcode.com/problems/reverse-words-in-a-string/) | Trim spaces, split words, and reverse their order. Ensure extra spaces are removed and only single spaces remain between words. | Trim leading/trailing spaces . Split by spaces and filter empty strings  . Reverse the list of words  . Join with single space | Amazon, Microsoft, MentorGraphics, MakeMyTrip, Goldman Sachs, Samsung, Adobe, Paytm, Accolite | [CodeStoryWithMIK](https://youtu.be/mdej8UiRCkI?si=xm49eZvYoChULKtj) |


## 🔹 Testing

| Problem                                        | Link                                                                                     | Intuition (3–4 lines)                                                                                                                                                            | Key Steps / Notes                                                                                   | Company                | Video Tutorial                                                                                      |
| ---------------------------------------------- | ---------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | ---------------------- | --------------------------------------------------------------------------------------------------- |
| Reverse Words in a String | [LeetCode 151](https://leetcode.com/problems/reverse-words-in-a-string/) | Trim spaces, split words, and reverse their order. Ensure extra spaces are removed and only single spaces remain between words. | Trim leading/trailing spaces . Split by spaces and filter empty strings  . Reverse the list of words  . Join with single space | Adobe, Paytm, Accolite | [CodeStoryWithMIK](https://youtu.be/mdej8UiRCkI?si=xm49eZvYoChULKtj) |
