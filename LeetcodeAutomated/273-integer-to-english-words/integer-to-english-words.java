class Solution {
    private static final HashMap<Integer, String> hm = new HashMap<>();

    static {
        hm.put(0, "Zero");
        hm.put(1, "One");
        hm.put(2, "Two");
        hm.put(3, "Three");
        hm.put(4, "Four");
        hm.put(5, "Five");
        hm.put(6, "Six");
        hm.put(7, "Seven");
        hm.put(8, "Eight");
        hm.put(9, "Nine");
        hm.put(10, "Ten");
        hm.put(11, "Eleven");
        hm.put(12, "Twelve");
        hm.put(13, "Thirteen");
        hm.put(14, "Fourteen");
        hm.put(15, "Fifteen");
        hm.put(16, "Sixteen");
        hm.put(17, "Seventeen");
        hm.put(18, "Eighteen");
        hm.put(19, "Nineteen");
        hm.put(20, "Twenty");
        hm.put(30, "Thirty");
        hm.put(40, "Forty");
        hm.put(50, "Fifty");
        hm.put(60, "Sixty");
        hm.put(70, "Seventy");
        hm.put(80, "Eighty");
        hm.put(90, "Ninety");
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return convert(num);
    }

    private String convert(int num) {
        if (num < 20) return hm.get(num);
        if (num < 100) return hm.get(num - num % 10) + (num % 10 != 0 ? " " + convert(num % 10) : "");
        if (num < 1000) return convert(num / 100) + " Hundred" + (num % 100 != 0 ? " " + convert(num % 100) : "");
        if (num < 1000000) return convert(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + convert(num % 1000) : "");
        if (num < 1000000000) return convert(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + convert(num % 1000000) : "");
        return convert(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + convert(num % 1000000000) : "");
    }
}



// class Solution {
//     public String numberToWords(int num) {
//         String s = Integer.toString(num);
//         int len = s.length();
//         HashMap<String, String> hm = new HashMap<>();
//         hm.put("0", "Zero");
//         hm.put("1", "One");
//         hm.put("2", "Two");
//         hm.put("3", "Three");
//         hm.put("4", "Four");
//         hm.put("5", "Five");
//         hm.put("6", "Six");
//         hm.put("7", "Seven");
//         hm.put("8", "Eight");
//         hm.put("9", "Nine");
//         hm.put("10", "Ten");
//         hm.put("11", "Eleven");
//         hm.put("12", "Twelve");
//         hm.put("13", "Thirteen");
//         hm.put("14", "Fourteen");
//         hm.put("15", "Fifteen");
//         hm.put("16", "Sixteen");
//         hm.put("17", "Seventeen");
//         hm.put("18", "Eighteen");
//         hm.put("19", "Nineteen");
//         hm.put("20", "Twenty");
//         hm.put("30", "Thirty");
//         hm.put("40", "Forty");
//         hm.put("50", "Fifty");
//         hm.put("60", "Sixty");
//         hm.put("70", "Seventy");
//         hm.put("80", "Eighty");
//         hm.put("90", "Ninety");
//         hm.put("100", "Hundred");

//         if (len == 1)
//             return hm.get(s);
//         if (len == 2 && num >= 10 && num <= 20)
//             return hm.get(s);
//         if (len == 2 && num > 20 && num <= 99) {
//             String ten = Integer.toString((num / 10) * 10);
//             String one = Integer.toString(num - (num / 10) * 10);
//             return hm.get(ten) + " " + hm.get(one);
//         }
//         if (len == 3) {
//             String h = Integer.toString((num / 10) / 10);
//             String hundred = hm.get(h) + " Hundred ";
//             s = s.substring(1);
//             num = Integer.parseInt(s);
//             if (num >= 10 && num <= 20)
//                 return hundred + hm.get(s);
//             if (num > 20 && num <= 99) {
//                 String ten = Integer.toString((num / 10) * 10);
//                 String one = Integer.toString(num - (num / 10) * 10);
//                 return hundred + hm.get(ten) + " " + hm.get(one);
//             }

//         }

//         if (len == 4) {
//             String t = Integer.toString((num / 10) / 10/ 10);
//             String thousand = hm.get(t) + " Thousand ";

//             String h = Integer.toString((num / 10) / 10);
//             String hundred = hm.get(h) + " Hundred ";

//             s = s.substring(2);
//             num = Integer.parseInt(s);
//             if (num >= 10 && num <= 20)
//                 return thousand + hundred + hm.get(s);
//             if (num > 20 && num <= 99) {
//                 String ten = Integer.toString((num / 10) * 10);
//                 String one = Integer.toString(num - (num / 10) * 10);
//                 return thousand + hundred + hm.get(ten) + " " + hm.get(one);
//             }

//         }




//         return hm.get("11");

//     }
// }