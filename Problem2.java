//TC: O(n)
//SC: O(n)

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>n){
                arr[n] += 1;
            }
            else{
                arr[citations[i]] += 1;
            }
        }
        int sum=0;
        for(int i=n; i>=0 ; i--){
            sum += arr[i];
            if(sum>=i ) return i;
            
        }
        
        return -1;
    }
}
