/*
 * TC: O(n) n: length of citations
 * SC: O(1) 
 * 
 * Approach: In my Approach, at each iteration i will check if my index <= citation, if it is then i found the H-index.
 */

class Solution {
    public int hIndex(int[] citations) {
    
     for(int i =0; i< citations.length; i++)
        if(i <= citations[i]) return i;
        
    return 0;
    }
}