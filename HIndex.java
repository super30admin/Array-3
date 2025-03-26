//In this approach, we will make use of bucketsort to put number of papers with same iterations into buckets to get the solution in linear time.
//Because the max h-index could be only till the length of the array+1, for all the papers that have citations greater than n+1, we put them in the last number bucket
//Now we keep a count of papers from the end and when we get that count as greater than or equal to citations, then we return that index
//Time Complexity:O(n)
//Space Complexity: O(n)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1]; //because h-index could be from 0 to n+1
        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--){
            count += buckets[i];
            if(count >= i){
                return i;
            }
        }
        return 0;
    }
}
