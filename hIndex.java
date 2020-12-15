// Time Complexity : o(nlogn + n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 274
//Approach : Sort inbuilt

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < n ; i++){
            int diff = n -i;
            if(diff <= citations[i]){
                return diff;
            }
        }
        return 0;
    }
    
}

// Time Complexity : o(2n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 274
//Approach : Bucket sort

class Solution {
    public int hIndex(int[] citations) {
    int n = citations.length; 
    int buckets[] = new int[n+1];
    for(int i = 0 ; i < n; i++){
        if(citations[i] > n){
            buckets[n]++;
        }
        else{
            buckets[citations[i]]++;
        }
    }
    int sum = 0 ;
        
    for(int i = n ; i >= 0; i--){
        sum += buckets[i];
        if(sum>=i){
            return i;
        }
    }
        return 101;
    }   
}