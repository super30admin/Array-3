
// Time O(n)
// Space O(n)

public class Hindex {
	public int hIndex(int[] citations) {
        int n  = citations.length;
        int[] arr = new int[n+1]; 
        for(int i=0;i<n;i++){
            int num = citations[i];
            if(num > n){
                arr[n]++;
            }else{
                arr[num]++;
            }
        }
        int temp =0;
        for(int i=n;i>=0;i--){
            temp+=arr[i];
             if(temp >=i)
                return i; 
        }
    return 12345;
    }
}
