//Leetcode: 274. H-Index
//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int hIndex(int[] citations) {
        int n= citations.length;
        int[] res= new int[n+1];
        for(int i: citations){
            if(i>=n) {
                res[n]++;
            }
            else{
               res[i]++; 
            }
        }
        int sum=0;
        for(int k=n; k>=0;k--){
           sum=sum+res[k];
            if(sum>=k){
                return k;
            }
        }
        return -1;
    }
}