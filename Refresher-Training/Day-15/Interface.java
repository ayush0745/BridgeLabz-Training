import java.util.*;
interface AdvancedArithmetic{
  int divisor_sum(int n);
}
class MyCalculator implements AdvancedArithmetic{
  public int divisor_sum(int n){
    int sum = 1 ;
        for(int i = 2;i <= n; i++){
            if(n % i == 0){
                sum += i;
            }
        }
    
    return sum;
  }
}
//Write your code here

class Solution{