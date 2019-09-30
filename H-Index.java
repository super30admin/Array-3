/*Time Complexity : O(Nlogn)
Space Complexity : O(1)
Did it run on LeetCode : Yes
Any problems: No
*/
class Solution {
    public int hIndex(int[] citations) {
    
    Arrays.sort(citations); // Sort the citations array. 
        
   int n =citations.length;
    for(int i=0;i<n;i++){
        if(citations[i]>=n-i) // Once we find the citation value that is equal to or greater than Length-i, we return that citation value.
            return n-i; // if we return citations[i], it misses a few edge cases.
        }
    return 0;
        
    }
}
