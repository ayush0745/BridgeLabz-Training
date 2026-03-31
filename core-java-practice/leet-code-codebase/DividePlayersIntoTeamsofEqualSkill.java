class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
      long sum = 0;
      int n = skill.length-1;
      long temp = skill[0] + skill[n];
      for(int i = 0; i < skill.length/2; i++){
        if( temp != skill[i] + skill[n]) {
            return -1;
        }
            temp = skill[i] + skill[n];
            sum += skill[i] * skill[n];
            n--;
      }
        return sum;
    }
}