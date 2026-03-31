class Solution {
    public int climbStairs(int n) {
        int [] arr = new int[n+1];
         return helper(arr,n);
    }
    public static int helper(int [] arr,int n){
              if(n==0){
                return 1;
              }
              if(n<0){
                return 0;
              }
              if(arr[n] != 0) return arr[n];

              return arr[n]=  helper(arr,n-1) + helper(arr,n-2);
    }
}