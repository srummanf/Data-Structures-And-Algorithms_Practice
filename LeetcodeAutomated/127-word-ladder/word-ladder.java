// // BFS

// class Solution {
//     class Pair {
//         String s;
//         int val;

//         Pair(String s, int val) {
//             this.s = s;
//             this.val = val;
//         }
//     }

//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         int n = wordList.size();
//         Queue<Pair> q = new LinkedList<>();
//         HashSet<String> hash = new HashSet<>(wordList);
//         int ctr = 1;
//         q.add(new Pair(beginWord, ctr));
//         while (q.isEmpty() == false) {
//             Pair p = q.poll();
//             String word = p.s;
//             int count = p.val;
//             int nn = word.length();
//             for (int i = 0; i < nn; i++) {
//                 int ch = 97;
//                 for (int j = 0; j < 26; j++) {
//                     char newch = (char)(ch + j);
//                     String newword = word.replace(word.charAt(i), newch);
//                     if (hash.contains(newword)) {
//                         q.offer(new Pair(newword, ctr + 1));
//                         hash.remove(newword);
//                         if (newword.equals(endWord))
//                             return ctr;
//                     }
//                 }
//             }
//             ctr += 1;
//         }

//         return 0;
//     }
// }

class Solution {
    class Pair {
        String s;
        int val;

        Pair(String s, int val) {
            this.s = s;
            this.val = val;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> hash = new HashSet<>(wordList); // Use a set for quick lookup
        
        if (!hash.contains(endWord)) {
            return 0; // If endWord is not in the wordList, return 0
        }
        
        q.add(new Pair(beginWord, 1)); // Start with the first word with a count of 1
        hash.remove(beginWord); // Remove the beginWord from the set to avoid revisiting
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.s;
            int count = p.val;
            
            // Generate all possible transformations
            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray(); // Convert to char array to modify specific index
                
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (wordArray[i] == ch) continue; // Skip if the character is the same
                    
                    wordArray[i] = ch; // Change one character at index i
                    String newword = new String(wordArray);
                    
                    // Check if the transformed word is in the set
                    if (hash.contains(newword)) {
                        if (newword.equals(endWord)) {
                            return count + 1; // Return the count + 1 if we reach the endWord
                        }
                        
                        q.offer(new Pair(newword, count + 1)); // Add the new word to the queue
                        hash.remove(newword); // Remove it from the set to avoid revisiting
                    }
                }
            }
        }

        return 0; // If there's no valid transformation sequence
    }
}
