class KthLargest {

    private final int k;
    private final PriorityQueue <Integer> pq = new PriorityQueue<>((a,b) -> a - b);

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i=0; i<nums.length; i++){
            add(nums[i]);
        }
        
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
