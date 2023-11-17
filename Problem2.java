// Time Complexity : O(n) - O(n+n) as we traverse through citations and nums
// Space Complexity : O(n) size of nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }

        int n = citations.length;
        int[] nums = new int[n + 1];

        for(int i = 0; i < n; i++){
            int index = citations[i];
            if(index >= n){
                nums[n]++;
            }else{
                nums[index]++;
            }
        }

        int total = 0;
        for(int i = n; i >= 0; i--){
            total = total + nums[i];
            if(total >= i){
                return i;
            }
        }

        return 0;
    }
}