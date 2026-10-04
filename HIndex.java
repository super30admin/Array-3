//Time Complexity: O(nlogn)
//Space Complexity: O(n)
class Solution {
    public int hIndex(int[] citations) {

        if(citations == null || citations.length == 0) return -1;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = citations.length;

        for(int c: citations)
        {
            q.add(c); //[0] size = 1

            if(q.peek() < q.size())
            {
                q.poll();
            }
        }

        return q.size();
    }
}