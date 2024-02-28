class Solution {
    //TC: O(n)
    //SC: O(n)
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int [] bucket = new int[n+1];
        for(int el : citations){
            if(el >= n){
                bucket[n]++;
            }else{
                bucket[el]++;
            }
        }
        int sum = 0;
        for(int i = n; i>=0; i--){
            sum += bucket[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
}
