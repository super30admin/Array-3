/*
TC: O(N)
SC: O(N) - an array of size n is created

1. We use the technique of counting sort. 
2. A count array with number of elements >= current element is created.
3. It is upper bounded by N - length of array.
4. Find h by reverse traversing the array. 

*/

public class HIndex {
    public int HIndex(int[] citations){
        int n = citations.length;
        int[] arr = new int[n + 1];

        for(int c : citations){
            if(c >= n){
                arr[n]++;
            }else{
                arr[c]++;
            }
        }

        int count = 0;
        for(int i = n; i >= 0; i--){
            count += arr[i];
            if(count >= i)
                return i;
        }
        return 0;
    }

    public static void main(String[] args){
        int arr[] = new int[]{6,3,4,2,5,1,7};
        HIndex hi = new HIndex();
        System.out.println(hi.HIndex(arr));
    }
}
