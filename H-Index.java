/*
Time: O(2n)
Space: o(n)
Did this code successfully run on Leetcode : yes

Approach:
1. Use bucket sort as we have the range of numbers i.e. the number of papers
2. As the maximumx value of h can be size of array i.e n, so minimum value is 0 and max is n
3. Traverse the bucket from end to find the max value of h i.e no of papers >= citations value
*/
class Solution {
    public int hIndex(int[] citations) {

        int n= citations.length;

        int bucket[]=new int[n+1];

        for(int i=0;i<n;i++){
            if(citations[i]>=n){
                bucket[n]++;
            }
            else{
                bucket[citations[i]]++;
            }
        }
        int count=0;
        for(int i=n;i>=0;i--){

            count+=bucket[i];

            if(count>=i){
                return i;
            }
        }
        return 0;
    }
}