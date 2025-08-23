import java.util.HashMap;
import java.util.Map;

public class AlphabetsFreq {
    // Function for decoding the string
    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) == ')') {
                // Handle the pattern 2(40)
                int j = i - 1;
                while (s.charAt(j) != '(') j--;
                int repeatCount = Integer.parseInt(s.substring(j + 1, i));
                char ch = (char) ('a' + (s.charAt(j - 1) - '1'));
                result.append(String.valueOf(ch).repeat(Math.max(0, repeatCount)));
                i = j - 2;
            } else if (s.charAt(i) == '#') {
                // Handle the pattern 26#
                int num = Integer.parseInt(s.substring(i - 2, i));
                char ch = (char) ('a' + num - 1);
                result.append(ch);
                i -= 3;
            } else if (Character.isDigit(s.charAt(i))) {
                // Handle single digits
                char ch = (char) ('a' + (s.charAt(i) - '1'));
                result.append(ch);
                i--;
            } else {
                // Skip spaces or any other characters
                i--;
            }
        }

        // Reverse the result since we built it backwards
        return result.reverse().toString();
    }

    // Function for calculating the frequency
    public static Map<Character, Integer> countFrequency(String decoded) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : decoded.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        String input = "12(3)420#2";
        String decodedString = decodeString(input);
        System.out.println("Decoded String: " + decodedString);

        Map<Character, Integer> frequency = countFrequency(decodedString);

        System.out.println("Character Frequency:");
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
