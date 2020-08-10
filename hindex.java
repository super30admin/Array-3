//Time complexity:O(n)
//Space complexity:O(n)
class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] bucket=new int[n+1];
        for(int i:citations){
            bucket[Math.min(i,n)]++;
        }
        int diff=0;
        for(int i=bucket.length-1;i>=0;i--){
            diff+=bucket[i];
            if(diff>=i){
                return i;
            }
        }
        return 0;
    }
}