package s30.arrays.array3;


//Algo: we need to find fixed h papers that can range from 0 -> n
// check for max limit of h, if we have atleast h papers greater than limit.
// applied count sort kind of array.

//Tc: O(n);
//Sc: O(n);
public class hIndex {


    public int hIndex(int[] citations) {

        int n = citations.length;

        int[] hArray = new int[n+1];


        for(int i=0; i < n ; i++){
            int index = citations[i] > n ? n : citations[i];
            hArray[index]++;
        }

        if(n <=  hArray[n]) return n;

        for(int i= n - 1; i >=0; i--){
            hArray[i] += hArray[i+1];
            if(i <=  hArray[i]) return i;
        }

        return -1;
    }
    public static void main(String[] args) {

    }
}
