//Time Complexity: O(nlogn) to sort the array
//Space Complexity: O(1)
//Did it run on leetcode: yes
/** Approach: In the sorted array we will check if there h or more papers at index h**/

class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0)
            return 0;
        
        Arrays.sort(citations);
        int n = citations.length;
        
        int index = -1;
        for(int i=0; i<n; i++){
            if(citations[i]>=n-i)
                return n-i;
        }
        
        return 0;
    }
}
