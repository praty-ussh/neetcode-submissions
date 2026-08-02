class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue <Map.Entry<int[], Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        int[][] result = new int[k][2];
        for(int[] point : points){
            int shortDist = point[0] * point[0] + point[1] * point[1];
            pq.offer(Map.entry(point, shortDist));
        }
        for(int i=0; i<k; i++){
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
