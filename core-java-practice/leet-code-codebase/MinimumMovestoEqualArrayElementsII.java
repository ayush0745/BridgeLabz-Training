class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int x = nums[ ((nums.length )/ 2) ];
        int sum = 0;
        for( int val : nums){
            sum += Math.abs( x - val);
        }

        return sum;
    }
}