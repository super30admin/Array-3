import java.util.PriorityQueue;

class Solution {
    public int hIndex(int[] citations) {
        return helperPQ(citations);
        // return helperOptimized(citations);
    }

    // Tc: O(nlogn)
    // Sc: O(1)
    public int helperOptimized(int[] c) {
        int low = 0, high = c.length;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            int cnt = 0;
            for (int i = 0; i < c.length; i++)
                if (c[i] >= mid)
                    cnt++;
            if (cnt >= mid)
                low = mid;
            else
                high = high = mid - 1;
        }
        return low;
    }

    // Tc: O(nlogn)
    // Sc: O(n)
    public int helperPQ(int[] citations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int hIndex = 0;

        for (int i : citations){
            pq.offer(i);
        }

        while (!pq.isEmpty() && pq.peek() > hIndex) {
            pq.poll();
            hIndex++;
        }

        return hIndex;
    }
}