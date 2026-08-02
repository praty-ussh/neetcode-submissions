class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int stone: stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int second =0;
            int max = pq.poll();
            if(pq.size()!=0){
                second = pq.poll();
            }
            if(max!=second){
                pq.offer((max-second));
            }
        }
        if(pq.size() == 0){
            return 0;
        }
        else{
            return pq.peek();
        }
    }
}
