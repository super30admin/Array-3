//TC O(n)
//SC O(n)

//Bucket sort.
//1. Create an array with size citatations.length+1. If the value is greater that
// the max possible hIndex val, update the value in the array for corresponding index
//2. Iterate throught the array from the end and check for valid hindex value

class Problem2 {
    public int hIndex(int[] citations) {
        int[] hArray = new int[citations.length+1];

        for(int i= 0;i<citations.length; i++){
            if(citations[i]>citations.length)
                hArray[hArray.length-1]++;
            else
                hArray[citations[i]]++;
        }
        int result = 0;
        int temp = 0;
        for(int i=hArray.length-1 ; i>=0 ; i--){
            hArray[i] += temp;
            if(hArray[i] >= i){
                result = i;
                break;
            }

            temp = hArray[i];

        }

        return result;

    }
}
