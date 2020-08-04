// Time complexity - O(n)
// Space complexity - O(n)

class Solution {
    public int hIndex(int[] citations) {
        int total=0;
        int n=citations.length;
        int[] temp=new int[n+1];
        for(int c:citations){
            if(c>=n){
                temp[n]++;
            }
            else{
                temp[c]++;
            }
        }
        for(int i=n;i>=0;i--){
            total+=temp[i];
            if(total>=i){
                return i;
            }
        }
        return 0;
    }
} 
