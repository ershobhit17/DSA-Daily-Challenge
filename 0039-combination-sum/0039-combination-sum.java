class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
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
            if (candidates[i] > remaining) {
                continue; // Skip if candidate is too large
            }
            
            // Choose the candidate
            current.add(candidates[i]);
            
            // Recursively find combinations with the same candidate allowed again
            backtrack(candidates, remaining - candidates[i], i, current, result);
            
            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}