class Solution {  
    public void moveZeroes(int[] nums) {  
        int j = -1;   
        for (int k = 0; k < nums.length; k++) {  
            if (nums[k] == 0) {  
                j = k;  
                break;  
            }  
        }  

        if (j == -1) return ;
        
     
        for (int i = j + 1; i < nums.length; i++) {  
            if (nums[i] != 0) {  
              
                int tmp = nums[i];  
                nums[i] = nums[j];  
                nums[j] = tmp;  
                j++; 
            }  
        }  
    }  
}