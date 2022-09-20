//TC - O(N);
//SC - O(N);
//LC - 274
class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0) return 0;
        
        int n = citations.length;
        int[] arr = new int[n+1];
        
        for(int i=0;i<n;i++){
            if(citations[i]>n){
                arr[n]++;
            }
            else{
                arr[citations[i]]++;
            }
        }
        int res=0;
        for(int i=n;i>=0;i--){
            res=res+arr[i];
            
            if(res>=i) return i;
        }
        
        return 0;
    }
}