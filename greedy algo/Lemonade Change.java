class Solution {
    public boolean lemonadeChange(int[] bills) {

        int f = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                f++;

            else if (bills[i] == 10) {
                if (f < 1)
                    return false;
                ten++;
                f--;
            } else {
                if (f >= 1 && ten >= 1) {
                    f--;
                    ten--;
                } else if (f >= 3) {
                    f = f - 3;

                } else {
                    return false;
                }

            }
        }
        return true;
    }
}