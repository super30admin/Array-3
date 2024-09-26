// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class HIndex {
    public int hIndex(int[] citations) {
        if(citations==null){
            return 0;
        }
        int n=citations.length;
        int[] arr=new int[n+1];
        for(int cit:citations){
            if(cit>=n){
                arr[n]+=1;
            }
            else{
                arr[cit]+=1;
            }
        }
        int sum=0;
        for(int x=arr.length-1;x>=0;x--){
            sum+=arr[x];
            if(sum>=x){
                return x;
            }
        }
        return 0;
    }
}