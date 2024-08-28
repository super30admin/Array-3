class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int [] bu = new int[n+1];

        for(int i=0; i<n;i++){
            if(citations[i] >= n){
                bu[n]++;
            }else{
                bu[citations[i]]++;
            }
        }
        int temp = 0;
        for(int i = n;i>=0;i--){
            temp += bu[i];
            if(temp >= i){
                return i;
            }
        }
        return 0;
    }
}