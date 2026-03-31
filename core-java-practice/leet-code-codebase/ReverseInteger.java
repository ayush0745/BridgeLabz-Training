class Solution {
    public int reverse(int x) {
        int ans = 0;
        
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // Check for overflow before updating ans
            // Integer.MAX_VALUE is used
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0; 
            }
            // Integer.MIN_VALUE is used
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            ans = ans * 10 + pop;
        }
        
        return ans;
    }
}