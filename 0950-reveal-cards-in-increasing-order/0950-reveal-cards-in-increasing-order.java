class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        
        // Use deque to simulate the process in reverse
        Deque<Integer> deque = new ArrayDeque<>();
        
        // Process cards from largest to smallest
        for (int i = n - 1; i >= 0; i--) {
            if (!deque.isEmpty()) {
                // Move bottom card to top (reverse of moving top to bottom)
                deque.addFirst(deque.removeLast());
            }
            // Add current card to front
            deque.addFirst(deck[i]);
        }
        
        // Convert deque to array
        int[] result = new int[n];
        int index = 0;
        for (int card : deque) {
            result[index++] = card;
        }
        
        return result;
    }
}