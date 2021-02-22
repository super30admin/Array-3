// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// bucket sort for citations using map. then travese from 1 to number of papers and keep decreasing number of papers
// by frequency of the number in map. when number is less than index return number. 

class Solution {
    public int hIndex(int[] citations) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< citations.length;i++){
            int b = map.getOrDefault(citations[i],0);
            map.put(citations[i],b+1);
        }
        int res = 0;
        int n = citations.length;
        int[] h = new int[n+1];
        h[0] = n;
        for(int i = 1; i < h.length;i++){
            if(map.containsKey(i-1)){
                 h[i] = h[i-1] - map.get(i-1);
            } else h[i] = h[i-1];
            if(h[i] >= i ) res = i;
            else return res;
        }
        return res;
    }
}