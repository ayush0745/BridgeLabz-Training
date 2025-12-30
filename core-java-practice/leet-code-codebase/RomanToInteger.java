class Solution {
    public int romanToInt(String s) {
        int ans = 0;

        int pre = 0;
        int curr = 0;
        for(char ch : s.toCharArray()) {
            curr = getValue(ch);
            if(pre < curr)
                ans += (curr - 2 * pre);

            else ans += curr;

            pre = curr;
        }


        return ans;
    }

    public int getValue(char ch) {
        if(ch == 'M') return 1000;
        if(ch == 'D') return 500;
        if(ch == 'C') return 100;
        if(ch == 'L') return 50;
        if(ch == 'X') return 10;
        if(ch == 'V') return 5;
        return 1;
    }
}