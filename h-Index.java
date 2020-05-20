// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length == 0)    return 0;
        
        int[] dp = new int[citations.length + 1];
        
        for(int n: citations)
        {
            if(n >= citations.length)
                dp[dp.length - 1] += 1;
            else
                dp[n] += 1;
        }
        
        int sum = 0;
        
        for(int i = dp.length - 1; i >= 0; i--)
        {
            sum += dp[i];
            if(sum >= i)
                return i;
        }
        return 0;
    }
}