class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int MOD = 1_000_000_007;

        for (int num : nums) {
            int key = num - rev(num);
            count = (count + freq.getOrDefault(key, 0)) % MOD;
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        return count;
    }

    private int rev(int n) {
        int num = 0;
        while (n > 0) {
            num = num * 10 + (n % 10);
            n /= 10;
        }
        return num;
    }
}
