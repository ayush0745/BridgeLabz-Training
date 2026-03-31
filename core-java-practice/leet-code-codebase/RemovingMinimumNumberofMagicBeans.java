class Solution {
    public long minimumRemoval(int[] beans) {
        long sum = Long.MAX_VALUE;
        Arrays.sort(beans);
        long totalsum = 0;
        for( int val : beans){
            totalsum += val;
        }
        for( int i = 0; i < beans.length;i++ ){
        long temp = (long) beans[i] * (beans.length - i);
            sum = Math.min(totalsum - temp,sum);
        }    

        return sum;
    }
}