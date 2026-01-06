class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        Map<String, Long> countMap = new HashMap<>();
        long ans = 0;

        for (int[] rect : rectangles) {
            int w = rect[0];
            int h = rect[1];
            
            int common = gcd(w, h);
            String ratio = (w / common) + ":" + (h / common);
            
        
            long count = countMap.getOrDefault(ratio, 0L);
            ans += count;
            
            countMap.put(ratio, count + 1);
        }
        
        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}