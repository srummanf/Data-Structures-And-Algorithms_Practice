class Solution {
    public boolean lemonadeChange(int[] bills) {
        int change_five = 0;
        int change_ten = 0;
        int change_tw = 0;

        for (int i : bills) {
            if (i == 5)
                change_five++;
            if (i == 10) {
                change_ten++;
                if (change_five == 0)
                    return false;
                else
                    change_five--;
            }
            if (i == 20) {
                change_tw++;
                if (change_five <= 0 || change_five * 5 + change_ten * 10 < 15)
                    return false;
                else {
                    if (change_ten > 0) {
                        change_ten--;
                        change_five--;
                    } else {
                        change_five = change_five - 3;
                    }

                }
            }

        }

        return true;

    }
}