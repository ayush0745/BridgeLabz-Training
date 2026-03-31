class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
       String[] words1 = s1.split(" ");  
        String[] words2 = s2.split(" ");  
        
      
        Map<String, Integer> wordCount = new HashMap<>();  
        
      
        for (String word : words1) {  
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);  
        }  
        
               for (String word : words2) {  
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);  
        }  
        
               List<String> uncommon = new ArrayList<>();  
        
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {  
            if (entry.getValue() == 1) {  
                uncommon.add(entry.getKey());  
            }  
        }  
        
             String[] result = new String[uncommon.size()];  
        for (int i = 0; i < uncommon.size(); i++) {  
            result[i] = uncommon.get(i);  
        }  
        
        return result;  

    }
}