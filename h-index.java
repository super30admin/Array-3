// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
/*
To explain this, let's look at the following example:

{citations} = [1, 3, 2, 3, 100] 
citations=[1,3,2,3,100]
The counting results are:

kk	    0	1	2	3	4	5
count	0	1	1	2	0	1
s_ks    5	5	4	3	1	1
*/
// Your code here along with comments explaining your approach
//TC: O(n)
//SC: O(n)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] sort = new int[ n + 1];
        int papers = 0;
        for(int i = 0; i < n ; i++){
            if(citations[i] >= n)
                sort[n]++;
            else
                sort[citations[i]]++;
        }
        for(int x = n; x >= 0 ; x--){
            papers += sort[x];
            
            if(papers >= x) return x;
        }
        return 0;
    }
}