//TC = log(n)
//SC = O(1)
// Here we are using binary search approch. 

class HIndex{
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n-1
        while(left<=right){
            int mid = left + (right-left)/2;
            if(citations[mid] == n-mid) return citations[mid]; 
            else if(citations[mid] < n-mid){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return n-left;
    }
}