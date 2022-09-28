//Problem 274
//TC : O(n)
//SC : O(n)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(citations == null || n ==0) return 0;
        int[] hIndexs = new int[n+1];
        
        for(int i:citations){
            if(i >= n) hIndexs[n]++;
            else hIndexs[i]++;
        }
        int sum=0;
        for(int i=n;i>=0;i--){
            sum+=hIndexs[i];
            if(sum>=i){
                return i;
            }
        }
        return 0;
    }
}
//Problem 275
//TC : O(logn)
//SC : O(1)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0,high=n-1;
        
        while(low<=high){
            int mid = low +(high-low)/2;
            int dif = n-mid;
            if(citations[mid] == dif){
                return dif;
            }else if(citations[mid] < dif){ 
                low = mid+1;
            }else{ //we need to find the very first citations[mid] > dif if we dont find the citations[mid] == dif
                high = mid-1;
            }
        }
        return n-low;   //when we didnt find anything in binary search low pointer will be at the correct position ex : [0,1,2,5,6]
    }
}
