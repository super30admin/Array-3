//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int[] sort = new int[n+1];
        for(int x : citations){
            if(x >= n){
                sort[n]++;
            }
            else{
                sort[x]++;
            }
        }
        int papers = 0;
        for(int i = n; i >= 0;i--){
            papers += sort[i];
            if(papers >= i)
                return i;
        }
        return 0;
    }
}