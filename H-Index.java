// Time Complexity : O(n) where n is the number of citations
// Space Complexity : O(n) where n is the number fo citations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Make an array with citations as the index for the new array. Count the number of
citations each of the other citations have that is more than the particular citations. If the citation gets out of the bounds, we store it at the
last citation number of the array since it is only for counting purpose. Start traversing from the end of the bucket array to the start and sum
the number of papers that each citations have. As the sum exceeds the citation number or becomes equal, you have got the H index.
*/
class Solution {
    public int hIndex(int[] citations) {
     if(citations == null || citations.length == 0){return 0;}
     int[] buckets = new int[citations.length+1];                                                       // Buckets upto citations number
        int s = 0;                                                                              // sum of the paper counts
     for(int i = 0; i < citations.length; i++){
         if(citations[i] < citations.length){                                                               
             buckets[citations[i]]++;                                                               // Count the number of papers of the particular citation
         }else {
             buckets[citations.length]++;                                                       // If citation number exceeds citations length
         }
     }
    for(int i = buckets.length-1; i>=0; i--){
        s+=buckets[i];
        if(s >= i) return i;                                                                // Sum of count of papers exceeds the citation number is the h index
    }
        return -1;
     }
}