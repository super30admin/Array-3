class Solution {
    public int hIndex(int[] citations) {
        
        /*
        method 1: sort the citations and check the difference
        between the citations and index. if difference < citations[i]
        if at any point the difference becomes greater than the citations, that is         the h index. 
        time complexity: o(nlogn + n) 
        space complexity :O(1)
        */
        // Arrays.sort(citations);//[3,0,6,1,5] -> 0,1,3,5,6
        // int n = citations.length;
        // for(int i = 0;i < citations.length;i++){
        //     int diff = n - i;
        //     if(diff <= citations[i]){
        //         return diff;
        //     }
        // }
        /*method 2 - bucket sort, here we sort the array elements into buckets
        //use a buckets array of size n+1
        //increase the count of bucket in that particluar bucket when seen
        //for element which is out of buckets array range, incease the last bucket index
        time complexity : O(n)
        space complexity :O(n)
        */
        int n = citations.length;
        int[]buckets = new int[n+1];
        for(int i = 0;i < citations.length;i++){
            if(citations[i] >= n){
                buckets[n]++;
            }else{
                buckets[citations[i]]++;
            }
            
        }
        int sum =0;
        for(int i = buckets.length-1;i >=0; i--){
            sum +=  buckets[i]; 
            if(sum  >= i){
                return i;
            }
        }
        return 0;
    }
}
