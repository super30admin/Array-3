
//TC-O(N) -space O(l)
public class HIndex {
    public int hIndex(int[] citations) {
        int l=citations.length;
        int total=0;
        int[] arr=new int[l+1];

        for(int i=0;i<l;i++){
            if(citations[i]>l)
                arr[l]++;
            else
                arr[citations[i]]++;
        }


        for(int i=l;i>=0;i--){
            total+=arr[i];
            if(total>=i){
                return i;
            }
        }
        return 0;
    }
}

//TC-nLog(n) -space O(1)
/*
 public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(citations[mid]==n-mid){
                return n-mid;
            } else if(citations[mid]<n-mid){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return n-left;
    }

 */


