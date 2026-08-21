class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates and enable pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int remaining, int start,
                          List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // If current candidate exceeds remaining, break (since array is sorted)
            if (candidates[i] > remaining) {
                break;
            }
            
            // Choose the candidate
            current.add(candidates[i]);
            
            // Move to i+1 because each number can only be used once
            backtrack(candidates, remaining - candidates[i], i + 1, current, result);
            
            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}