class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int minOps = Integer.MAX_VALUE;
        
        // Try all rotations from 0 to n-1
        for (int rotation = 0; rotation < n; rotation++) {
            int ops = rotation; // Cost of left rotations
            
            int left = 0, right = n - 1;
            
            while (left < right) {
                // Get characters considering the rotation
                char c1 = s.charAt((left + rotation) % n);
                char c2 = s.charAt((right + rotation) % n);
                
                // Minimum cyclic increments to make c1 and c2 equal
                int dist1 = (c2 - c1 + 26) % 26; // increment c1 to reach c2
                int dist2 = (c1 - c2 + 26) % 26; // increment c2 to reach c1
                ops += Math.min(dist1, dist2);
                
                left++;
                right--;
            }
            
            minOps = Math.min(minOps, ops);
        }
        
        return minOps;
    }
}