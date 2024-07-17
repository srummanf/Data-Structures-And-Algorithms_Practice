// Whenever character freq is used -- Use array instead of HashMap

// class Solution {
//     public int leastInterval(char[] tasks, int p) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//         int[] freq = new int[26];

//         int time = 0;
//         for (char ch : tasks) {
//             freq[ch - 'A']++;
//         }

//         for (int a : freq) {
//             if (a > 0)
//                 pq.offer(a);
//         }

//         while (pq.isEmpty() == false) {
//             ArrayList<Integer> temp = new ArrayList<>();
//             int cycle = p + 1;
//             int currtask = 0;
//             while (cycle > 0 && pq.isEmpty() == false) {
//                 cycle--;
//                 int currfreq = pq.poll();
//                 if (currfreq > 1)
//                     temp.add(currfreq - 1);
//                 currtask++;
//             }
//             temp.forEach(pq::offer);
//             // for (int element : currtask) {
//             //          pq.offer(element); }

//             time += pq.isEmpty()? currtask : p+1;
//         }

//         return time;

//     }
// }


class Solution {
    public int leastInterval(char[] tasks, int cooldown) {
        // Step 1: Count frequencies of each task
        int[] taskCounts = new int[26];
        int maxFrequency = 0;

        for (char task : tasks) {
            int index = task - 'A';
            taskCounts[index]++;
            maxFrequency = Math.max(maxFrequency, taskCounts[index]);
        }

        // Step 2: Count how many tasks have the maximum frequency
        int maxFrequencyTasks = 0;
        for (int count : taskCounts) {
            if (count == maxFrequency) {
                maxFrequencyTasks++;
            }
        }

        // Step 3: Calculate the minimum schedule length
        int minScheduleLength = Math.max(
            tasks.length, 
            (maxFrequency - 1) * (cooldown + 1) + maxFrequencyTasks
        );

        return minScheduleLength;
    }
}
