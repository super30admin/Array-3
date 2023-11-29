// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length; int cnt = 0;
        int[] bucket = new int[n+1];
        for(int x : citations){
            if(x >= n)
                bucket[n]++;
            else
                bucket[x]++;
        }
        for(int i = n; i >=0 ; i--){
            cnt+=bucket[i];
            if(cnt >= i)
                return i;
            
        }
        return 0;
    }
}
