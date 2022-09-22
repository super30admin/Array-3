//Approach - 2: Linear and Without Sorting by using Bucket Sort concept, Just sort in range
//Time Complexity : O(n)
//Space Complexity : O(n)



//notes
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        //Create an Array of n+1 length, push all elem>=range; 
        // h index will in array length range, after range number we don't require
        int[] bucket = new int[n+1];
        for(int i=0; i<n; i++){
            //if its not in range, just increase the count of last bucket
            if(citations[i] >= n){
                bucket[n]++;
            }
            //increase particular index and elements count
            else{
                bucket[citations[i]]++;
            }
        }
        
        int sum = 0;
        for(int i = n; i>=0;i--){
            //loop from last buckets count 
            sum = sum+ bucket[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
}



//Approach - 1: Linear and Sort
//Time Complexity : O(nlogn)
//Space Complexity : O(1)



//notes
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        //Sort if its not sorted
        Arrays.sort(citations);
        for(int i=0; i<n; i++){
            int diff = n-i;
            if(diff<=citations[i]){
                return diff;
            }
        }
        //[0,0,0,0] == [4,3,2,1] no diff<=citations[i] will match
        return 0;
    }
}
