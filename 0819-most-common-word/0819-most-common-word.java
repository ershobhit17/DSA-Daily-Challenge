class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Convert banned array to a set for O(1) lookup
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }
        
        // Split paragraph into words, removing punctuation
        // Replace punctuation with spaces and split by spaces
        String[] words = paragraph.toLowerCase().replaceAll("[^a-z]", " ").split("\\s+");
        
        // Count frequency of each non-banned word
        Map<String, Integer> frequencyMap = new HashMap<>();
        String mostFrequent = "";
        int maxCount = 0;
        
        for (String word : words) {
            // Skip empty strings (can happen with multiple spaces)
            if (word.isEmpty()) continue;
            
            // Skip banned words
            if (bannedSet.contains(word)) continue;
            
            // Update frequency
            int count = frequencyMap.getOrDefault(word, 0) + 1;
            frequencyMap.put(word, count);
            
            // Update most frequent word
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = word;
            }
        }
        
        return mostFrequent;
    }
}