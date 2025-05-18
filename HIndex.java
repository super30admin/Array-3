class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); //O(nlogn)

        for(int i=0; i<citations.length; i++){ //O(n)
            if(citations[i] >= citations.length - i)
                return citations.length - i;
        }
        return 0;
    }
} 

/*
Time Complexity = O(nlong + n)
Space Complexity = O(1)
*/

class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int low = 0;
        int high = citations.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(citations[mid] == citations.length - mid){
                return citations.length - mid;
            }
            else if(citations[mid] < citations.length - mid){
                    low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return citations.length - low;
    }
}

//Time Complexity if Already sorted O(logn)
//Space Complexity = O(1)


//Bucket Sort

class HIndex {
    public int hIndex(int[] citations) {
        int[] arr = new int[citations.length+1];
        for(int i=0; i<citations.length; i++){
            if(citations[i] >= arr.length){
                arr[arr.length-1] += 1; 
            }
            else
            {
                arr[citations[i]] += 1;
            }
        }


        int sum = 0;
        for(int i=citations.length; i>=0; i--){
            sum+=arr[i];

            if(sum >= i)
                return i;
        }
    return 0;
    }
}