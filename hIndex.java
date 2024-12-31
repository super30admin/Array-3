/*
 * tc - o(n)
 * sc- o(n)
 */

public class hIndex {
     //o(n)
     public int hIndex(int[] citations) {
        int n = citations.length;
        int nums[] = new int[n+1];
        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                nums[n]++;
            }else{
                nums[citations[i]]++;
            }
        }
        int sum =0;
        for(int i = n; i >= 0; i--){
            sum += nums[i];
            if(i <= sum){
                return i;
            } 
        }
        return 0;
    }
}
