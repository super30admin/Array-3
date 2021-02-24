/*time complexity O(2n)
space complexity O(n)
approach : using bucket sort*/


class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] bucket=new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>n){
                bucket[n]++;
            }
            else{
                bucket[citations[i]]++;
            }
        }
        int sum=0;
        for(int i=0;i<n+1;i++){
            sum=sum+bucket[n-i];
            if(sum-n+i>=0){
                return n-i;
            }
        }
        return 0;
    }
}