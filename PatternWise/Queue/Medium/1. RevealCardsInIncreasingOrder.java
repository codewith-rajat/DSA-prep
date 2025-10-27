// https://leetcode.com/problems/reveal-cards-in-increasing-order/description/

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int  res[] = new int[deck.length];
        Deque<Integer> dq = new LinkedList<>();
        for(int i=deck.length-1;i>=0;i--){
            if(!dq.isEmpty()) dq.addFirst(dq.removeLast());
            dq.addFirst(deck[i]);
        }
        int idx = 0;
        for(int card : dq) res[idx++] = card;
        return res;
    }
}