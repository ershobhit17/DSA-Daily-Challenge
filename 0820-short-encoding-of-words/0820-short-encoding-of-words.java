class Solution {
    public int minimumLengthEncoding(String[] words) {
        // Build a trie with reversed words
        TrieNode root = new TrieNode();
        Map<TrieNode, Integer> nodeDepth = new HashMap<>();
        
        // Insert each word into trie (reversed)
        for (String word : words) {
            TrieNode current = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
            }
            current.isEnd = true;
            nodeDepth.put(current, word.length() + 1); // +1 for '#'
        }
        
        // Sum lengths of leaf nodes (nodes that are not prefixes of any other word)
        int totalLength = 0;
        for (TrieNode node : nodeDepth.keySet()) {
            // If node has no children, it's a leaf
            if (node.children.isEmpty()) {
                totalLength += nodeDepth.get(node);
            }
        }
        
        return totalLength;
    }
    
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;
        
        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
}