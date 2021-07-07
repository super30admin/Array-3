//Time : O(n)
//Space : O(n)

// Approach:
// 1. Since max index will be number of papers have an array of size given array +1.
// 2. This array store number of papers having i citations . For papers with citations > max h index store them in last cell of array.
// 3. Start from end of this resultant array and check number of papers >= current index .If true return current index else move on to i-1
//    index and check again .
public class hindex {
    public static int hIndex(int[] citations) {
        int[] result = new int[citations.length+1];
        for(int i = 0;i<citations.length;i++){
            if(citations[i]>=citations.length)
                result[result.length-1]++;
            else result[citations[i]]++;
        }
        int sum = 0;
        for(int i = result.length-1;i>0;i--){
            sum+=result[i];
            if(sum>=i)  return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1,5,6};
        System.out.print(hIndex(nums));
    }
}
