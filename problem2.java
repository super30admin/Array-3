/*

The intuition here is to use bucket sort technique to find the h index, as the given array is not sorted

we will create a bucket of size n, and as we encounter citations, we will keep increasing the citation index count
the citation >= n would be counted on the last index
once we establish the counts , we will keep decrementing the index from last while adding the citation at that index and check if the citation are >= to the index,
whereever that coundtion is true, that index would be our h-index
*/
// Time : O(2n) , Space : O(n)
class Solution {
    public int hIndex(int[] citations) {

        int[] bucket = new int[citations.length+1];

        for(int i=0;i<citations.length;i++){ // O(n)
            int val = citations[i];

            if (val < citations.length){
                bucket[val]++;
            }
            else{
                bucket[bucket.length-1]++;
            }
        }

        // now we will find the h index
        int citationSum=0;
        for(int i=bucket.length-1;i>=0;i--){
            int val = bucket[i];
            citationSum+= val;
            if(citationSum >= i){
                return i;
            }
        }
        return -1; // not reachable
    }
}